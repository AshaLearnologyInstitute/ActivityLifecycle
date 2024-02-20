package com.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class FrameLayoutActivity extends AppCompatActivity {
    private int layoutType = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Thread background = new Thread() {
            public void run() {
                try {
                    Log.e("Thread","Started");
                    sleep(2*1000);
                    layoutType=1;
//                    layoutType = (layoutType + 1) % 2;
                    onResume();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        background.start();
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (layoutType == 0) {
            setContentView(R.layout.activity_frame_layout);
        } else {
            setContentView(R.layout.activity_frame_layout2);
        }
    }


}