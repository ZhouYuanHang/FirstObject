package com.foxhis.mobile.retrofit2.HttpRequestInterface;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by zyh on 2017/12/27.
 */

public interface CheckUpdate {
    @POST("xopspring-web/rest")
    Call<String> checkUpdate(@Body RequestBody body);
}
