package com.xiong.tuan.MVP.base;

import android.content.Context;
import android.support.annotation.Nullable;

import com.xiong.tuan.MVP.mvp.MvpPresenter;
import com.xiong.tuan.MVP.mvp.MvpView;

import java.lang.ref.WeakReference;

import de.greenrobot.event.EventBus;

/**
 * A base implementation of a {@link MvpPresenter} that uses a <b>WeakReference</b> for referring
 * to the attached view.
 * <p>
 * You should always check {@link #isViewAttached()} to check if the view is attached to this
 * presenter before calling {@link #getView()} to access the view.
 * </p>
 */
public class MvpBasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private WeakReference<V> viewRef;
    protected Context mContext;

    protected MvpBasePresenter(Context context){
        this.mContext = context.getApplicationContext();
    }

    @Override public void attachView(V view) {
        viewRef = new WeakReference<V>(view);
        EventBus.getDefault().register(this);
    }

    /**
     * Get the attached view. You should always call {@link #isViewAttached()} to check if the view
     * is
     * attached to avoid NullPointerExceptions.
     *
     * @return <code>null</code>, if view is not attached, otherwise the concrete view instance
     */
    @Nullable public V getView() {
        return viewRef == null ? null : viewRef.get();
    }

    /**
     * Checks if a view is attached to this presenter. You should always call this method before
     * calling {@link #getView()} to get the view instance.
     */
    public boolean isViewAttached() {
        return viewRef != null && viewRef.get() != null;
    }

    @Override public void detachView(boolean retainInstance) {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
        EventBus.getDefault().unregister(this);
    }


}

