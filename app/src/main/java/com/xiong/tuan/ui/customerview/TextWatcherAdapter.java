package com.xiong.tuan.ui.customerview;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by hui.xiong on 2016/3/11.
 */
public class TextWatcherAdapter implements TextWatcher{

    interface TextWatcherListener{
        void onTextChanged(String s);
    }

    private TextWatcherListener listener;

    public TextWatcherAdapter(TextWatcherListener listener){
        listener = listener;
    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
         listener.onTextChanged(s.toString());
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
