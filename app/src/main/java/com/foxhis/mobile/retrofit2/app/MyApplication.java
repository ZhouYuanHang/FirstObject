package com.foxhis.mobile.retrofit2.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by zyh on 2017/12/26.
 */

public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
