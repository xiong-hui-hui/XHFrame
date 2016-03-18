package com.xiong.tuan.utils.volley;

/**
 * Created by hui.xiong on 2016/3/18.
 * 所有的response都是基于登录成功，若是登录不成功，则根据不同原因报相应错误
 */
public class BaseResponse {

    public boolean isSuccess() {
        return true;
    }
    public boolean isLoginTokenError(){
        return false;
    }
   }

