package com.xiong.tuan.ui;

/**
 * Created by hui.xiong on 2016/3/14.
 */
public class MyOut {
    private static int out;
    public MyIn in = new MyIn();

    public void outMethord() {
        in.inMethord();
    } //内部类

    public   class MyIn {
        public void inMethord() {
            //内部类可以使用外部类的方法、变量，包括private类型
            int in = out;
            //outMethord();
        }
    }
}
