package com.xiong.tuan.utils.volley;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.xiong.tuan.utils.LogUtils;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by hui.xiong on 2016/3/18.
 * A canned request for retrieving the response body at a given URL as any type(T).
 */
public class GsonRequest<T> extends Request<T> {


    private final Gson gson = new Gson();
    private final Class<T> clazz;
    private final Response.Listener<T> listener;
    private final Response.ErrorListener errorListener;
    private Map<String, String> headers;
    private Map<String, String> params;

    public GsonRequest(String url, Class<T> clazz,
                       Response.Listener<T> listener, Response.ErrorListener errorListener) {
        this(Method.GET,url,clazz,null,null,listener,errorListener);
    }
    public GsonRequest(int method, String url, Class<T> clazz, Map<String, String> params,
                       Response.Listener<T> listener, Response.ErrorListener errorListener){
        this(method,url,clazz,params,null,listener,errorListener);
    }

    public GsonRequest(int method, String url, Class<T> clazz, Map<String, String> params, Map<String, String> headers,
                       Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.clazz = clazz;
        this.headers = headers;
        this.params = params;
        this.listener = listener;
        this.errorListener = errorListener;
    }
    /**
     * Returns a Map of POST parameters to be used for this request, or null if
     * a simple GET should be used.  Can throw {@link AuthFailureError} as
     * authentication may be required to provide these values.
     * <p>Note that only one of getPostParams() and getPostBody() can return a non-null
     * value.</p>
     * @throws AuthFailureError In the event of auth failure
     * @deprecated Use {@link #getParams()} instead.
     */
    @Override
    public Map<String, String> getParams() {
        return params;
    }
    /**
     * Returns a list of extra HTTP headers to go along with this request. Can
     * throw {@link AuthFailureError} as authentication may be required to
     * provide these values.
     * @throws AuthFailureError In the event of auth failure
     */
    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers != null ? headers : super.getHeaders();
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(
                    response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            LogUtils.e(json);
            return Response.success(
                    gson.fromJson(json, clazz),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(T response) {

        listener.onResponse(response);
    }
    public Response.ErrorListener getErrorListener(){
        return errorListener;
    }
}
