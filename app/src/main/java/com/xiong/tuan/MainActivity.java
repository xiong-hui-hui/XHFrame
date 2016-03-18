package com.xiong.tuan;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.xiong.tuan.ui.customerview.ClearableEditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClearableEditText a =new ClearableEditText(this);

        a.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
    }


}
