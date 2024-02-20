package com.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TableLayout;

public class TableLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);

        findViewById(R.id.btnNext1).setOnClickListener(view ->
                startActivity(new Intent(TableLayoutActivity.this, ClockActivity.class)));

    }
}