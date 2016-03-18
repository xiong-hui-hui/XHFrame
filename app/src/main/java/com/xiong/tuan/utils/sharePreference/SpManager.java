package com.xiong.tuan.utils.sharePreference;

import android.content.SharedPreferences;

/**
 * Created by bingbing.tu
 * 2015/5/15.
 */
public class SpManager {

    private static SpManager mInstance;
    private SharedPreferences mSp;

    public SpManager(SharedPreferences sp){
        mSp = sp;
    }

    public static synchronized void initializeInstance(SharedPreferences sp){
        if(mInstance == null) mInstance = new SpManager(sp);
    }

    public static SpManager getInstance(){
        if(mInstance == null){
            throw new IllegalStateException(SpManager.class.getSimpleName() +
                    " is not initialized, call initializeInstance(..) method first.");
        }
        return mInstance;
    }

    public void executeQuery(final SpExecutor executor) {
        executor.run(mSp);
    }

    @SuppressWarnings("unused") // public api
    public void executeQueryTask(final SpExecutor executor) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                executor.run(mSp);
            }
        }).start();
    }
}
