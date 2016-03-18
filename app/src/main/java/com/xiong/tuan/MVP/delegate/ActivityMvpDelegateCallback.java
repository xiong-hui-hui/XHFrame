package com.xiong.tuan.MVP.delegate;

import com.xiong.tuan.MVP.delegate.BaseMvpDelegateCallback;
import com.xiong.tuan.MVP.delegate.ActivityMvpDelegate;
import com.xiong.tuan.MVP.mvp.MvpPresenter;
import com.xiong.tuan.MVP.mvp.MvpView;

/**
 * The MvpDelegate callback that will be called from  {@link
 * ActivityMvpDelegate}. This interface must be implemented by all
 * Activities that you want to support mosby's mvp.
 **/
public interface ActivityMvpDelegateCallback<V extends MvpView, P extends MvpPresenter<V>> extends BaseMvpDelegateCallback<V,P> {


    //TODO
}
