package com.xiong.tuan.MVP.delegate;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.xiong.tuan.MVP.mvp.MvpPresenter;
import com.xiong.tuan.MVP.mvp.MvpView;

/**
 * The default implementation of {@link FragmentMvpDelegate}
 * @param <V> The type of {@link MvpView}
 * @param <P> The type of {@link MvpPresenter}
 */
public class FragmentMvpDelegateImpl<V extends MvpView, P extends MvpPresenter<V>>
        implements FragmentMvpDelegate {

    protected BaseMvpDelegateCallback<V,P> delegateCallback;
    protected MvpInternalDelegate<V,P> internalDelegate;

    public FragmentMvpDelegateImpl(BaseMvpDelegateCallback<V,P> delegateCallback){
        if (delegateCallback == null) {
            throw new NullPointerException("MvpDelegateCallback is null!");
        }
        this.delegateCallback = delegateCallback;
    }
    protected MvpInternalDelegate<V, P> getInternalDelegate() {
        if (internalDelegate == null) {
            internalDelegate = new MvpInternalDelegate<>(delegateCallback);
        }
        return internalDelegate;
    }

    @Override
    public void onCreate(Bundle saved) {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getInternalDelegate().createPresenter();
        getInternalDelegate().attachView();
    }

    @Override
    public void onDestroyView() {
        getInternalDelegate().detachView();
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

    }

    @Override
    public void onAttach(Activity activity) {

    }

    @Override
    public void onDetach() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }
}

