package com.xiong.tuan.utils;

import android.util.Log;

/**
 * Created by hui.xiong on 2016/3/18.
 */
public class LogUtils {

    private static final String DEFAULT_TAG = "captain-test";
    private static final String DEFAULT_MSG = "msg -> ";
    private static final boolean DEBUG = true;

    public static void i(String tag, String msg){
        if(DEBUG){
            Log.i(tag, msg);
        }
    }
    public static void i(Throwable tr){
        if(DEBUG){
            Log.i(DEFAULT_TAG, DEFAULT_MSG, tr);
        }
    }
    public static void d(Throwable tr){
        if(DEBUG){
            Log.d(DEFAULT_TAG, DEFAULT_MSG, tr);
        }
    }
    public static void d(String tag, String msg){
        if(DEBUG){
            Log.d(tag, msg);
        }
    }
    public synchronized static void e(String tag, String msg){
        if(DEBUG){
            Log.e(tag, msg);
        }
    }
    public static void i(String msg){
        i(DEFAULT_TAG, msg);
    }
    public static void d(String msg){
        d(DEFAULT_TAG, msg);
    }
    public static void e(String msg){
        e(DEFAULT_TAG, msg);
    }

}
