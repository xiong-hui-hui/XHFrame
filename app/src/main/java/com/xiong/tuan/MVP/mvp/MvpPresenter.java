package com.xiong.tuan.MVP.mvp;

/**
 * Created by hui.xiong on 2016/3/16.
 */
public interface MvpPresenter<V extends MvpView> {
    /**
     * Set or attach the view to this presenter
     */
     void attachView(V view);
    /**
     * Will be called if the view has been destroyed. Typically this method will be invoked from
     * <code>Activity.detachView()</code> or <code>Fragment.onDestroyView()</code>
     */
     void detachView(boolean retainInstance) ;
}
