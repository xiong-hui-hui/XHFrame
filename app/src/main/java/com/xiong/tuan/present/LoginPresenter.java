package com.xiong.tuan.present;


import com.xiong.tuan.MVP.mvp.MvpPresenter;
import com.xiong.tuan.entity.User;
import com.xiong.tuan.view.LoginView;

/**
 * Created by hui.xiong on 2016/3/17.
 */
public interface LoginPresenter extends MvpPresenter<LoginView> {

    void login(String phoneNum, String passwd);
    void fetchUserInfo(User user);
}
