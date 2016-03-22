package com.xiong.tuan.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hui.xiong on 2016/3/17.
 */
public class Agency implements Parcelable{
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
    public static final Parcelable.Creator<Agency> CREATOR = new Parcelable.Creator<Agency>() {
        public Agency createFromParcel(Parcel source) {
            return new Agency();
        }

        public Agency[] newArray(int size) {
            return new Agency[size];
        }
    };
}
