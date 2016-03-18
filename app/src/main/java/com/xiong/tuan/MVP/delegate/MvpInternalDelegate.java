package com.xiong.tuan.MVP.delegate;

import com.xiong.tuan.MVP.mvp.MvpPresenter;
import com.xiong.tuan.MVP.mvp.MvpView;

/**
 * This is just the internal implementation for the delegate. Don't use it by your own.
 * @param <V> The type of {@link MvpView}
 * @param <P> The type of {@link MvpPresenter}
 **/
class MvpInternalDelegate<V extends MvpView, P extends MvpPresenter<V>> {

    protected BaseMvpDelegateCallback<V,P> delegateCallback;

    MvpInternalDelegate(BaseMvpDelegateCallback<V,P> delegateCallback){
        if (delegateCallback == null){
            throw new NullPointerException("MvpDelegateCallback is null!");
        }
        this.delegateCallback = delegateCallback;
    }
    /**
     * Called  to create the presenter (if no other one already exisits)
     */
    void createPresenter(){
        P presenter = delegateCallback.getPresenter();
        if (presenter == null){
            presenter = delegateCallback.createPresenter();
        }
        if (presenter == null) {
            throw new NullPointerException("Presenter is null! Do you return null in createPresenter()?");
        }
        delegateCallback.setPresenter(presenter);
    }
    private P getPresenter(){
        P presenter = delegateCallback.getPresenter();
        if (presenter == null) {
            throw new NullPointerException("Presenter returned from getPresenter() is null");
        }
        return presenter;
    }
    /**
     * Attaches the view to the presenter
     */
    void attachView(){
        getPresenter().attachView(delegateCallback.getMvpView());
    }
    /**
     * Called to detach the view from presenter
     */
    void detachView() {
        getPresenter().detachView(delegateCallback.shouldInstanceBeRetained());
    }
}
