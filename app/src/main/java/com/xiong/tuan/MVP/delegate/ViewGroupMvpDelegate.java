package com.xiong.tuan.MVP.delegate;

import com.xiong.tuan.MVP.mvp.MvpPresenter;
import com.xiong.tuan.MVP.mvp.MvpView;

/**
 * Created by hui.xiong on 2016/3/16.
 */
public interface ViewGroupMvpDelegate<V extends MvpView, P extends MvpPresenter<V>> {

    void onAttachedToWindow();
    void onDetachedFromWindow();
}
