package com.xiong.tuan.view;

import com.xiong.tuan.MVP.mvp.MvpView;
import com.xiong.tuan.entity.User;

/**
 * Created by hui.xiong on 2016/3/16.
 */
public interface LoginView extends MvpView{
    void showLoginDialog();
    void dismissLoginDialog();

    void showLoginResultMsg(String msg);

    void loginSucc(User user);

    void loginFail();

    void showUserHangUpDialog();
}
