package com.example.fanjie.newmvp.view;

import com.example.fanjie.newmvp.model.bean.LoginBean;

/**
 * author:Created by Constraint.
 */

public interface LoginIView extends IView{
    void loginSuccess(LoginBean loginBean);
    void loginFaild(Throwable e);
}
