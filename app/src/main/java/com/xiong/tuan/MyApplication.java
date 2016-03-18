package com.xiong.tuan;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by hui.xiong on 2016/3/14.
 */
public class MyApplication extends Application {

   private RefWatcher refWatcher ;
    @Override
    public void onCreate() {
        super.onCreate();
       refWatcher = LeakCanary.install(this);

    }

    public static RefWatcher getRefWatcher(Context context) {
        MyApplication application = (MyApplication) context.getApplicationContext();
        return application.refWatcher;
    }
}
