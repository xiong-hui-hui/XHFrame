package com.xiong.tuan.present;

import android.content.Context;

import com.xiong.tuan.MVP.base.MvpBasePresenter;
import com.xiong.tuan.entity.User;
import com.xiong.tuan.model.LoginModel;
import com.xiong.tuan.model.LoginModelImpl;
import com.xiong.tuan.view.LoginView;

/**
 * Created by hui.xiong on 2016/3/18.
 */
public class LoginPresenterImpl extends MvpBasePresenter<LoginView> implements LoginPresenter {

    public LoginModel mModel;

    public LoginPresenterImpl(Context context){
        super(context);
        mModel = new LoginModelImpl(context);
    }

    @Override
    public void login(String phoneNum, String passwd) {

    }

    @Override
    public void fetchUserInfo(User user) {

    }


    public void onEvent(){

    }
}
