package com.example.fanjie.newmvp.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author:Created by Constraint.
 */

public class RetrofitManager {
    public static final String BASE_URL = "https://www.zhaoapi.cn/";
    private final Retrofit mRetrofit;

    private OkHttpClient buildOkhttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
                //使用请求头
                .addInterceptor(new Logger())
                .build();
    }
    private Retrofit buildRetrofit(){
        return new Retrofit.Builder()
                //可以利用client添加拦截器
                .client(buildOkhttpClient())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private RetrofitManager(String baseUrl) {
        mRetrofit = buildRetrofit();
    }
    public static class SINGLE_HOLDER {
        public static final RetrofitManager INSTANCE = new RetrofitManager(BASE_URL);
    }
    public static RetrofitManager getInstance(){
        return SINGLE_HOLDER.INSTANCE;
    }
    public <T> T create(Class<T> clazz){
        return mRetrofit.create(clazz);
    }
    //定义请求头
    class Logger implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request original = chain.request();
            HttpUrl url=original.url().newBuilder()
                    .addQueryParameter("source","android")
                    .build();
            //添加请求头
            Request request = original.newBuilder()
                    .url(url)
                    .build();
            return chain.proceed(request);
        }
    }
}
