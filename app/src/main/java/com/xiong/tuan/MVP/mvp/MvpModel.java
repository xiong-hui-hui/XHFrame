package com.xiong.tuan.MVP.mvp;

import android.content.Context;

import java.util.Set;

import de.greenrobot.event.EventBus;

/**
 * Created by hui.xiong on 2016/3/16.
 */
public interface MvpModel {

    EventBus getEventBus();
    Context getContext();

    /**
     * @return 服务器出错消息
     */
    String getServerErrorMsg();

    /**
     * @return 网络出错消息
     */
    String getNetworkErrorMsg();

    /**
     * @return 网络请求tags
     */
    Set<String> getTags();

    /**
     * 取消网络请求
     */
    void cancelAllReq();
}
