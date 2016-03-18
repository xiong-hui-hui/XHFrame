package com.xiong.tuan.ui.customerview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.EditText;

/**
 * Created by hui.xiong on 2016/3/10.
 */
public class ClearableEditText extends EditText implements View.OnTouchListener,
        View.OnFocusChangeListener,TextWatcherAdapter.TextWatcherListener {

    private Drawable mDrawable;
    private Context mContext;
    private int mTouchSlop;
    private OnTouchListener mTouchListener;
    private OnFocusChangeListener mFocusListener;

    public ClearableEditText(Context context) {
        this(context,null);
    }

    public ClearableEditText(Context context, AttributeSet attrs) {
        this(context, attrs,0);

    }
    public ClearableEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext=context;
        mTouchSlop= ViewConfiguration.get(context).getScaledTouchSlop();
        mDrawable = getCompoundDrawables()[2];
       if (mDrawable == null){
           mDrawable = ContextCompat.getDrawable(mContext,android.R.drawable.presence_offline);
          // mDrawable = getResources().getDrawable(android.R.drawable.presence_offline,context.getTheme());
       }
        super.setOnTouchListener(this);
        super.setOnFocusChangeListener(this);
        addTextChangedListener(new TextWatcherAdapter(this));
    }

    @Override
    public void setOnTouchListener(OnTouchListener l) {
        super.setOnTouchListener(l);
        this.mTouchListener =l;
    }

    @Override
    public void setOnFocusChangeListener(OnFocusChangeListener l) {
        super.setOnFocusChangeListener(l);
        this.mFocusListener = l;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {

        if(hasFocus){
            setClearIconVisible(!TextUtils.isEmpty(getText().toString()));
        }else {
            setClearIconVisible(false);
        }
        if (mFocusListener !=null){
            mFocusListener.onFocusChange(v,hasFocus);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        float downX = 0,downY =0;
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                downX = event.getX();
                downY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                if (Math.abs(event.getX() - downX) < mTouchSlop && Math.abs(event.getY() - downY) < downY) {
                    if (getCompoundDrawables()[2] != null && event.getX() > (getWidth() - mDrawable.getIntrinsicWidth() - getPaddingRight())) {
                        setText("");
                        return true;
                    }
                    if (mTouchListener != null){
                        return mTouchListener.onTouch(v,event);
                    }
                }
                break;
        }
        return false;
    }

    protected void setClearIconVisible(boolean visible){
        setCompoundDrawables(getCompoundDrawables()[0],getCompoundDrawables()[1],visible?mDrawable:null,getCompoundDrawables()[3]);
    }

    @Override
    public void onTextChanged(String s) {
        if (isFocused()){
            setClearIconVisible(!TextUtils.isEmpty(s));
        }
    }
}
