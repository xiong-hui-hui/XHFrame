package com.xiong.tuan.utils.sharePreference;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.xiong.tuan.entity.User;
import com.xiong.tuan.utils.LogUtils;

/**
 * Created by bingbing.tu
 * 2015/8/19.
 */
public class SPUtils {

    public static final String SP_NAME = "captain";
    public final static String PUSH_SP_NAME = "push";

    public static boolean isFirstEnter(Context context){
        SharedPreferences sp = getSharedPreferences(context, SP_NAME);
        boolean guideStatus=sp.getBoolean("guide", true);
        SharedPreferences.Editor edit=sp.edit();
        edit.putBoolean("guide", false);
        edit.apply();
        return guideStatus;
    }

    public static int decreaseVersionCancelCount(Context context) {
        SharedPreferences sp = getSharedPreferences(context, PUSH_SP_NAME);
        int msgCount = sp.getInt("versionCancelCount", 0);
        msgCount--;
        sp.edit().putInt("versionCancelCount", msgCount).apply();
        return msgCount;
    }

    public static int getVersionCancelCount(Context context){
        return getSharedPreferences(context, PUSH_SP_NAME).getInt("versionCancelCount", 0);
    }

    public static void saveVersionCancelCount(Context context, int count){
        getSharedPreferences(context, PUSH_SP_NAME).edit().putInt("versionCancelCount", count).apply();
    }


    public static boolean getMsgRing(Context context) {
        SharedPreferences sp = getSharedPreferences(context, PUSH_SP_NAME);
        return sp.getBoolean("msg_ring", true);
    }

    public static void saveMsgRing(Context context, boolean isOn) {
        SharedPreferences sp = getSharedPreferences(context, PUSH_SP_NAME);
        sp.edit().putBoolean("msg_ring", isOn).apply();
    }

    public static boolean getMsgVibrate(Context context) {
        SharedPreferences sp = getSharedPreferences(context, PUSH_SP_NAME);
        return sp.getBoolean("msg_vibrate", true);
    }

    public static void saveMsgVibrate(Context context, boolean isOn) {
        SharedPreferences sp = getSharedPreferences(context, PUSH_SP_NAME);
        sp.edit().putBoolean("msg_vibrate", isOn).apply();
    }

    public static int getLeaderConfirmMsgCount(Context context){
        SharedPreferences sp = getSharedPreferences(context, PUSH_SP_NAME);
        return sp.getInt("leaderConfirmMsgCount", 0);
    }
    public static void clearLeaderConfirmMsgCount(Context context) {
        SharedPreferences sp = getSharedPreferences(context, PUSH_SP_NAME);
        sp.edit().putInt("leaderConfirmMsgCount", 0).apply();
    }
    public static int increaseLeaderConfirmMsgCount(Context context) {
        SharedPreferences sp = getSharedPreferences(context, PUSH_SP_NAME);
        int msgCount = sp.getInt("leaderConfirmMsgCount", 0);
        msgCount++;
        sp.edit().putInt("leaderConfirmMsgCount", msgCount).apply();
        return msgCount;
    }

    public static int getLeaderInviteMsgCount(Context context){
        SharedPreferences sp = getSharedPreferences(context, PUSH_SP_NAME);
        return sp.getInt("leaderInviteMsgCount", 0);
    }

    public static void clearLeaderInviteMsgCount(Context context) {
        SharedPreferences sp = getSharedPreferences(context, PUSH_SP_NAME);
        sp.edit().putInt("leaderInviteMsgCount", 0).apply();
    }

    public static int increaseLeaderInviteMsgCount(Context context) {
        SharedPreferences sp = getSharedPreferences(context, PUSH_SP_NAME);
        int msgCount = sp.getInt("leaderInviteMsgCount", 0);
        msgCount++;
        sp.edit().putInt("leaderInviteMsgCount", msgCount).apply();
        return msgCount;
    }

    ////

    public static int getAgencyConfirmMsgCount(Context context){
        SharedPreferences sp = getSharedPreferences(context, PUSH_SP_NAME);
        return sp.getInt("agencyConfirmMsgCount", 0);
    }

    public static void clearAgencyConfirmMsgCount(Context context) {
        SharedPreferences sp = getSharedPreferences(context, PUSH_SP_NAME);
        sp.edit().putInt("agencyConfirmMsgCount", 0).apply();
    }

    public static int increaseAgencyConfirmMsgCount(Context context) {
        SharedPreferences sp = getSharedPreferences(context, PUSH_SP_NAME);
        int msgCount = sp.getInt("agencyConfirmMsgCount", 0);
        msgCount++;
        sp.edit().putInt("agencyConfirmMsgCount", msgCount).apply();
        return msgCount;
    }

    public static int getAgencyApplyMsgCount(Context context){
        SharedPreferences sp = getSharedPreferences(context, PUSH_SP_NAME);
        return sp.getInt("agencyApplyMsgCount", 0);
    }

    public static void clearAgencyApplyMsgCount(Context context) {
        SharedPreferences sp = getSharedPreferences(context, PUSH_SP_NAME);
        sp.edit().putInt("agencyApplyMsgCount", 0).apply();
    }

    public static int increaseAgencyApplyMsgCount(Context context) {
        SharedPreferences sp = getSharedPreferences(context, PUSH_SP_NAME);
        int msgCount = sp.getInt("agencyApplyMsgCount", 0);
        msgCount++;
        sp.edit().putInt("agencyApplyMsgCount", msgCount).apply();
        return msgCount;
    }

    public static int getLeaderMsgCount(Context context){
        SharedPreferences sp = getSharedPreferences(context, PUSH_SP_NAME);
        return sp.getInt("leaderMsgCount", 0);
    }

    public static void clearLeaderMsgCount(Context context) {
        SharedPreferences sp = getSharedPreferences(context, PUSH_SP_NAME);
        sp.edit().putInt("leaderMsgCount", 0).apply();
    }

    public static int increaseLeaderMsgCount(Context context){
        SharedPreferences sp = getSharedPreferences(context, PUSH_SP_NAME);
        int msgCount = sp.getInt("leaderMsgCount", 0);
        msgCount++;
        sp.edit().putInt("leaderMsgCount", msgCount).apply();
        return msgCount;
    }
    public static int getAgencyMsgCount(Context context){
        SharedPreferences sp = getSharedPreferences(context, PUSH_SP_NAME);
        return sp.getInt("agencyMsgCount", 0);
    }

    public static void clearAgencyMsgCount(Context context) {
        SharedPreferences sp = getSharedPreferences(context, PUSH_SP_NAME);
        sp.edit().putInt("agencyMsgCount", 0).apply();
    }

    public static int increaseAgencyMsgCount(Context context){
        SharedPreferences sp = getSharedPreferences(context, PUSH_SP_NAME);
        int msgCount = sp.getInt("agencyMsgCount", 0);
        msgCount++;
        sp.edit().putInt("agencyMsgCount", msgCount).apply();
        return msgCount;
    }

    public static String getCurrentRole(Context context){
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getString("role", "");
    }

    public static void saveCurrentRole(Context context, String role){
        SharedPreferences sp = getSharedPreferences(context);
        sp.edit().putString("role", role).apply();
    }

    public static void saveUser(Context context, User user){
        String userJson = "{}";
        if(user != null){
            userJson =new Gson().toJson(user);
        }
        SharedPreferences sp = getSharedPreferences(context);
        sp.edit().putString("user", userJson).apply();
    }

    public static User getUser(Context context){
        SharedPreferences sp = getSharedPreferences(context);
        String userJson = sp.getString("user", "{}");
        User user = new User();
        try {
            user = new Gson().fromJson(userJson, User.class);
        }catch (Exception e){
            LogUtils.i(e);
        }
        return user;
    }

    private static SharedPreferences getSharedPreferences(Context context, String name) {
        return context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
    }

    public static boolean clearUser(Context context) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.edit().putString("user", "{}").commit();
    }

}
