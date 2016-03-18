package com.xiong.tuan.model;

import com.xiong.tuan.entity.User;

/**
 * Created by hui.xiong on 2016/3/18.
 */
public interface LoginModel {
    void login(String phoneNum, String passwd);

    void fetchInitData(int version);

    void fetchUserInfo(User user);

    void loadLeaderMsgs(User user, int currentPage);

    void loadAgencyMsgs(User user, int currentPage);

    void leaderReadMsg(User user, String messageId);

    void agencyReadMsg(User user, String messageId);

    void feedback(User user, String role, String detail);

    void checkVersion(User user, String version);
}
