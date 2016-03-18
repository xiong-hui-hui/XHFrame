package com.xiong.tuan.utils.volley;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by hui.xiong on 2016/3/18.
 */
public class VolleySingleton {

    public static final String NETWK_ERROR_MSG = "后台小伙瞌睡去了~";
    private static VolleySingleton mInstance;
    private RequestQueue mRequestQueue;
    private static Context mCtx;

    private VolleySingleton(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized VolleySingleton getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new VolleySingleton(context.getApplicationContext());
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
       /*       if (Build.VERSION.SDK_INT >= 9) {
                try {
                    // Create a KeyStore containing our trusted CAs
                    //InputStream caInput = new BufferedInputStream(mCtx.getResources().openRawResource(R.raw.captain));
                    String keyStoreType = KeyStore.getDefaultType();
                    KeyStore keyStore = KeyStore.getInstance(keyStoreType);
                   // keyStore.load(caInput, "tzcaptain".toCharArray());
                    String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
                    TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
                    tmf.init(keyStore);

                    SSLContext context = SSLContext.getInstance("TLS");
                    context.init(null, tmf.getTrustManagers(), null);

                    mRequestQueue = Volley.newRequestQueue(mCtx, new HurlStack(null, context.getSocketFactory()));
                }catch (Exception e){
                    mRequestQueue = Volley.newRequestQueue(mCtx);
                    e.printStackTrace();
                }
            } else {
                mRequestQueue = Volley.newRequestQueue(mCtx);
            }*/
            mRequestQueue = Volley.newRequestQueue(mCtx);
        }
        return mRequestQueue;
    }


    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}
