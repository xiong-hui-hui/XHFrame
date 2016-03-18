package com.xiong.tuan.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by hui.xiong on 2016/3/18.
 */
public class NetWorkUtils {
    public static final int RES_OK = 0;
    public static final int RES_FAIL = 1;
    public static final String SUCCESS = "SUCCESS"; // common request params error：公共参数不能传空
    public static final String COMMON_PARAM_ERROR_CODE = "FA_FILT_1001"; // common request params error：公共参数不能传空
    public static final String LOGIN_TOKEN_ERROR_CODE = "FA_FILT_1002"; // loginToken过期或者错误
    public static final String AGENCY_HANG_UP_CODE = "FA_AGEN_1017"; // 旅行社挂起
    public static final String LEADER_HANG_UP_CODE = "FA_TRIP_1024"; // 领队导游挂起

    /**
     * 发送网络请求之前判断网络是否连接
     * @param context
     * @return
     */
    public static boolean isNetwkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo[] infos = cm.getAllNetworkInfo();
            if (infos != null) {
                for (NetworkInfo info : infos) {
                    if (info.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
