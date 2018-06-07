package com.example.fanjie.newmvp.constant;

import com.example.fanjie.newmvp.model.bean.LoginBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * author:Created by Constraint.
 */

public interface LoginApi {
    @GET("user/login")
    Observable<LoginBean> login(@QueryMap Map<String,String> map);
}
