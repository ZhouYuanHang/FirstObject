package com.foxhis.mobile.retrofit2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.foxhis.mobile.retrofit2.HttpRequestInterface.ShengService;
import com.foxhis.mobile.retrofit2.UI.DragView;
import com.foxhis.mobile.retrofit2.entity.SyncDataRequestBean;
import com.foxhis.mobile.retrofit2.entity.Weather;
import com.foxhis.mobile.retrofit2.greendao.DaoManager;
import com.foxhis.mobile.retrofit2.greendao.WeatherDao;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @BindView(R.id.cityName)
    TextView cityName;
    @BindView(R.id.insertBtn)
    Button insertBtn;
    @BindView(R.id.updateBtn)
    Button updateBtn;
    @BindView(R.id.baseLayout)
    LinearLayout baseLayout;
    @BindView(R.id.tl_custom)
    Toolbar tlCustom;
    @BindView(R.id.lv_left_menu)
    ListView lvLeftMenu;
    @BindView(R.id.dl_left)
    DrawerLayout dlLeft;
    @BindView(R.id.coordinator)
    CoordinatorLayout coordinator;
    private WeatherDao weatherDao;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tlCustom.setTitle("Toolbar");
        tlCustom.setTitleTextColor(Color.parseColor("#ffffff")); //设置标题颜色
        setSupportActionBar(tlCustom);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerToggle = new ActionBarDrawerToggle(this, dlLeft, tlCustom, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
//                mAnimationDrawable.stop();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
//                mAnimationDrawable.start();
            }
        };
        mDrawerToggle.syncState();
        dlLeft.addDrawerListener(mDrawerToggle);


        weatherDao = DaoManager.getInstance().getSession().getWeatherDao();
        updateBtn.setBackgroundResource(R.drawable.yuan);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://menudev.test.foxhis.com:80/")
                .addConverterFactory(ScalarsConverterFactory.create()).build();
        ShengService service = retrofit.create(ShengService.class);
        SyncDataRequestBean bean = new SyncDataRequestBean();
        List<SyncDataRequestBean.ParamsBean> list = new ArrayList<>();
        SyncDataRequestBean.ParamsBean pb = new SyncDataRequestBean.ParamsBean();
        pb.setHotelid("FoxhisX");
        pb.setTenantid("1");
        list.add(pb);
        SyncDataRequestBean.ExtrasBean eb = new SyncDataRequestBean.ExtrasBean();
        eb.setToken("E8864BABD10F16A450F44BE599C5E5F1");
        bean.setExtras(eb);
        bean.setParams(list);
        String route = new Gson().toJson(bean);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), route);
        Call<String> call = service.getShengName(body);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.e(TAG, "onResponse: " + response.body().toString());
//                        String cityName = response.body().getSk_info().getCityName();
//                        String temp = response.body().getSk_info().getTemp();
//                        String wd = response.body().getSk_info().getWd();
//                        String ws = response.body().getSk_info().getWs();
//                        MainActivity.this.cityName.setText(cityName + temp + wd + ws);
//                        Log.e(TAG, "onResponse: " + cityName + temp + wd + ws);
//
//                        Weather weather = new Weather(null, cityName, temp, wd, ws);
//                        weatherDao.insert(weather);
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            dlLeft.openDrawer(GravityCompat.START);//打开侧滑菜单
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.cityName, R.id.insertBtn, R.id.updateBtn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cityName:
                DragView dragView = new DragView(this, baseLayout);
                dragView.setBackgroundColor(Color.BLACK);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(200, 200);
                baseLayout.addView(dragView, params);
                Toast.makeText(this, "呵呵", Toast.LENGTH_SHORT).show();
                break;
            case R.id.insertBtn:
                Snackbar.make(getWindow().getDecorView(), "插入", Snackbar.LENGTH_LONG).setAction("确定", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                    }
                }).setDuration(10000).show();
//                Toast.makeText(this, "插入", Toast.LENGTH_SHORT).show();
                break;
            case R.id.updateBtn:
                List<Weather> list = weatherDao.queryBuilder().where(WeatherDao.Properties.CityName.eq("北京")).list();
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).setCityName("我家");
                    list.get(i).setTemperature("-25");
                    list.get(i).setWindDirection("东北风");
                    list.get(i).setWindLevel("8");
                    weatherDao.update(list.get(i));
                }
                break;
        }
    }
}
