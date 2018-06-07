package com.example.fanjie.newmvp.presenter;

import com.example.fanjie.newmvp.model.LoginModel;
import com.example.fanjie.newmvp.model.bean.LoginBean;
import com.example.fanjie.newmvp.view.LoginIView;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * author:Created by Constraint.
 */

public class LoginPresenter extends IPresenter<LoginIView>{

    private LoginModel loginModel;

    public LoginPresenter(LoginIView view) {
        super(view);
    }

    @Override
    protected void init() {
        loginModel = new LoginModel();
    }
    //登录
    public void login(Map<String,String> map){
        Observable<LoginBean> loginObservable = loginModel.login(map);
        loginObservable
                //需要在io子线程连网
                .subscribeOn(Schedulers.io())
                //需要在主线程更新UI
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(@NonNull LoginBean loginBean) throws Exception {
                        view.loginSuccess(loginBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        view.loginFaild(throwable);
                    }
                });
    }
}
