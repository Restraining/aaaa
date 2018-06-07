package com.example.fanjie.newmvp.presenter;

import com.example.fanjie.newmvp.view.IView;

/**
 * author:Created by Constraint.
 */

public abstract  class IPresenter<T extends IView> {
    protected T view;
    public IPresenter(T view){
        this.view=view;
        //用来创建model
        init();
    }

    protected abstract void init();
}
