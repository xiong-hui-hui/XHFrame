package com.xiong.tuan.MVP.base;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.xiong.tuan.MVP.mvp.MvpModel;
import com.xiong.tuan.utils.database.DatabaseManager;
import com.xiong.tuan.utils.sharePreference.SpManager;
import com.xiong.tuan.utils.volley.VolleySingleton;

import java.util.HashSet;
import java.util.Set;

import de.greenrobot.event.EventBus;

/**
 * Created by hui.xiong on 2016/3/18.
 * a base of model
 * 还可以在里面封装网络请求方法（下载图片）
 */
public abstract class MvpBaseModel implements MvpModel{

    protected Context mCtx;
    /**
     * 消息组件
     */
    protected EventBus mEventBus;
    /**
     * 网络请求组件
     */
    protected RequestQueue mVolley;
    /**
     * 数据库管理组件
     */
    protected DatabaseManager mDm;
    /**
     * SharedPreferences组件
     */
    protected SpManager mSpm;

    /**
     * 网络请求Tags，后续据此取消请求
     */
    protected Set<String> tags = new HashSet<>();

    public MvpBaseModel(Context context){
        mCtx = context;
        mEventBus = EventBus.getDefault();
        mVolley = VolleySingleton.getInstance(mCtx).getRequestQueue();
        mDm = DatabaseManager.getInstance();
        mSpm = SpManager.getInstance();
    }

    /**
     *
     * @return 网络出错消息
     */
    @Override
    public String getNetworkErrorMsg(){
        return "网络出错";
    }

    /**
     *
     * @return 服务器出错消息
     */
    @Override
    public String getServerErrorMsg(){
        return "服务器出错";
    }

    /**
     * @return 网络请求tags
     */
    @Override
    public Set<String> getTags(){
        return tags;
    }

    /**
     * 取消网络请求
     */
    @Override
    public void cancelAllReq() {
        for (String tag:tags){
            mVolley.cancelAll(tag);
        }
    }

    @Override
    public EventBus getEventBus() {
        return mEventBus;
    }

    @Override
    public Context getContext() {
        return mCtx;
    }

    /*protected void uploadImg(final InputStream photo, final User user, int who) {
        final String uploadImgUrl = URLBuilder.buildImgUpload();
        UploadImgEvent event = new UploadImgEvent();
        event.setWho(who);
        final MutilPartRequest<UploadImgResponse> request = new MutilPartRequest<>(uploadImgUrl, UploadImgResponse.class,
                new SuccessListener<UploadImgResponse, UploadImgEvent>(event, this){
                    @Override
                    public void onResponse(UploadImgResponse response) {
                        super.onResponse(response);
                    }

                    @Override
                    public void onSucc(UploadImgResponse response) {
                        super.onSucc(response);
                        getEvent().setImgId(response.getImgId());
                        mEventBus.post(getEvent());
                    }
                },
                new FailListener<UploadImgEvent>(event, this){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        super.onErrorResponse(error);
                    }
                });

        new TaskHelper(new TaskHelper.LightWork() {
            @Override
            public void onBackground() {
                request.prepare();
                request.addFormField("loginPhone", user.getLoginPhone());
                request.addFormField("loginToken", user.getLoginToken());
                request.addFormField("phoneToken", UUIDFactory.getInstance(mCtx).getUUID());
                request.addFilePart("image", photo);
                request.send();
            }

            @Override
            public void onUi() {}
        }).doLightWork();
    }*/
}
