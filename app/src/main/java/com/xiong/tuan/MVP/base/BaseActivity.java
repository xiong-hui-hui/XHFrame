package com.xiong.tuan.MVP.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.xiong.tuan.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import de.greenrobot.event.EventBus;

/**
 * Created by hui.xiong on 2016/3/11.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        ButterKnife.inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    public void toFragment(int resource, Fragment fragment, String tag){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (getSupportFragmentManager().findFragmentByTag(tag) == null){
            fragmentTransaction.add(resource,fragment,tag).commit();
        }
    }

    @Optional
    @OnClick(R.id.imgBack)
    public void backClick(){
        finish();
    }

}
