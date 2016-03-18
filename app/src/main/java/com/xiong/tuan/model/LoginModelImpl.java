package com.xiong.tuan.model;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.xiong.tuan.MVP.base.MvpBaseModel;
import com.xiong.tuan.entity.User;
import com.xiong.tuan.utils.volley.GsonRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hui.xiong on 2016/3/18.
 */
public class LoginModelImpl extends MvpBaseModel implements LoginModel  {
    public LoginModelImpl(Context context) {
        super(context);
    }

    @Override
    public void login(String phoneNum, String passwd) {

    }

    @Override
    public void fetchInitData(int version) {
        Map<String, String> params = new HashMap<>();
        params.put("dataVersion", version+"");
        GsonRequest<User> request =new GsonRequest<User>(Request.Method.POST, "url", User.class, params, new Response.Listener<User>() {
            @Override
            public void onResponse(User response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }

    @Override
    public void fetchUserInfo(User user) {

    }

    @Override
    public void loadLeaderMsgs(User user, int currentPage) {

    }

    @Override
    public void loadAgencyMsgs(User user, int currentPage) {

    }

    @Override
    public void leaderReadMsg(User user, String messageId) {

    }

    @Override
    public void agencyReadMsg(User user, String messageId) {

    }

    @Override
    public void feedback(User user, String role, String detail) {

    }

    @Override
    public void checkVersion(User user, String version) {

    }
}
