package com.xiong.tuan.present;

import android.content.Context;

import com.xiong.tuan.model.LoginModel;
import com.xiong.tuan.model.LoginModelImpl;
import com.xiong.tuan.view.LoginView;

/**
 * Created by hui.xiong on 2016/3/18.
 */
public class LoginPresenterImpl implements LoginPresenter {

    public LoginModel mModel;

    public LoginPresenterImpl(Context context){
       // super(context);
        mModel = new LoginModelImpl();
    }

    @Override
    public void login(String phoneNum, String passwd) {

    }

    @Override
    public void attachView(LoginView view) {

    }

    @Override
    public void detachView(boolean retainInstance) {

    }
}
