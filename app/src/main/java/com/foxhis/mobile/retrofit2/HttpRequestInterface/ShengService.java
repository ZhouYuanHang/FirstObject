package com.foxhis.mobile.retrofit2.HttpRequestInterface;

import com.foxhis.mobile.retrofit2.bean.ShengBean;
import com.foxhis.mobile.retrofit2.entity.SyncDataRequestBean;

import java.util.HashMap;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by zyh on 2017/12/25.
 */

public interface ShengService {
    @POST("xopspring-web/rest")
    Call<String> getShengName(@Body RequestBody body);
}
