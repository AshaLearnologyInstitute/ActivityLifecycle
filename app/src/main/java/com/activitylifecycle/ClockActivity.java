package com.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockActivity extends AppCompatActivity {

    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);

        textview = findViewById(R.id.textview);
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:MM:SS");
        textview.setText(formatter.format(today));
        blink();
    }

    private void blink() {
        final Handler hander = new Handler();
        new Thread(() -> {
            try {
                Thread.sleep(550);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hander.post(() -> {
                if(textview.getVisibility() == View.VISIBLE) {
                    textview.setVisibility(View.INVISIBLE);
                } else {
                    textview.setVisibility(View.VISIBLE);
                }
                blink();
            });
        }).start();
    }
}