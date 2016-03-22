package com.xiong.tuan.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hui.xiong on 2016/3/17.
 */
public class Leader implements Parcelable{
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
    public static final Parcelable.Creator<Leader> CREATOR = new Parcelable.Creator<Leader>() {
        public Leader createFromParcel(Parcel source) {
            return new Leader();
        }

        public Leader[] newArray(int size) {
            return new Leader[size];
        }
    };
}
