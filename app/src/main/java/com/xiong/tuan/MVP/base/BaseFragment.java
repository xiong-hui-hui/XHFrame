package com.xiong.tuan.MVP.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.fragmentargs.FragmentArgs;
import com.squareup.leakcanary.RefWatcher;
import com.xiong.tuan.MyApplication;
import com.xiong.tuan.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by hui.xiong on 2016/3/14.
 */
public abstract class BaseFragment extends Fragment{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentArgs.inject(this);
    }

    @LayoutRes
    protected abstract int getLayoutRes();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutRes(),container,false);
        ButterKnife.inject(this,view);
        return view;
    }

    @Optional
    @OnClick(R.id.imgBack)
    public void backClick(){
        getActivity().finish();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = MyApplication.getRefWatcher(getActivity());
        refWatcher.watch(this);
    }
}
