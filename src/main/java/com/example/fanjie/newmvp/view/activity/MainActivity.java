package com.example.fanjie.newmvp.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.fanjie.newmvp.R;
import com.example.fanjie.newmvp.model.bean.LoginBean;
import com.example.fanjie.newmvp.presenter.LoginPresenter;
import com.example.fanjie.newmvp.view.LoginIView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements LoginIView {
    private static final String TAG = "MainActivity";
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginPresenter = new LoginPresenter(this);
    }
    //去登录
    public void login(View view){
        HashMap<String, String> map = new HashMap<>();
        map.put("mobile","18701053989");
        map.put("password","5201314");
        loginPresenter.login(map);
}
    @Override
    public void loginSuccess(LoginBean loginBean) {
        Toast.makeText(MainActivity.this,loginBean.getMsg(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFaild(Throwable e) {
        Log.e(TAG, "loginFaild: "+e.getMessage() );
    }
}