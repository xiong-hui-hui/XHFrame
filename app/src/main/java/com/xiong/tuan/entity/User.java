package com.xiong.tuan.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/**
 * Created by hui.xiong on 2016/3/17.
 */
public class User implements Parcelable {
    public static final String ROLE_LEADER = "LEADER";
    public static final String ROLE_AGENCY = "AGENCY";

    private String memberId;

    private String loginPhone;

    private String loginToken;

    private Agency agency;

    private Leader leader;
    public static boolean isLogined(User user){
        return user != null && !TextUtils.isEmpty(user.getMemberId());
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? "" : memberId.trim();
    }

    public String getLoginPhone() {
        return loginPhone;
    }

    public void setLoginPhone(String loginPhone) {
        this.loginPhone = loginPhone == null ? "" : loginPhone.trim();
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken == null ? "" : loginToken.trim();
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.memberId);
        dest.writeString(this.loginPhone);
        dest.writeString(this.loginToken);
        dest.writeParcelable(this.agency, flags);
        dest.writeParcelable(this.leader, flags);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.memberId = in.readString();
        this.loginPhone = in.readString();
        this.loginToken = in.readString();
        this.agency = in.readParcelable(Agency.class.getClassLoader());
        this.leader = in.readParcelable(Leader.class.getClassLoader());
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public String toString() {
        return "User{" +
                "memberId='" + memberId + '\'' +
                ", loginPhone='" + loginPhone + '\'' +
                ", loginToken='" + loginToken + '\'' +
                ", agency=" + agency +
                ", leader=" + leader +
                '}';
    }
}
