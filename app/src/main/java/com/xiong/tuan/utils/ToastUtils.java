package com.xiong.tuan.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by bingbing.tu
 * 2015/5/12.
 */
public class ToastUtils {

    public static void show(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void show(Context context, String msg, int duration){
        Toast.makeText(context, msg, duration).show();
    }
}
