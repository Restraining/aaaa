package com.example.fanjie.newmvp.model;

import com.example.fanjie.newmvp.constant.LoginApi;
import com.example.fanjie.newmvp.model.bean.LoginBean;
import com.example.fanjie.newmvp.utils.RetrofitManager;

import java.util.Map;

import io.reactivex.Observable;


/**
 * author:Created by Constraint.
 */

public class LoginModel implements IModel{
    public Observable<LoginBean> login(Map<String,String> map){
        LoginApi loginApi = RetrofitManager.getInstance().create(LoginApi.class);
        return loginApi.login(map);
    }
}
