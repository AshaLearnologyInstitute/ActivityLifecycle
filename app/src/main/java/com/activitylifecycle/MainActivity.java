package com.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "onCreate Called", Toast.LENGTH_LONG).show();
        Log.e("Activity Lifecycle","onCreate Called" );

        findViewById(R.id.btnRec).setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, RecycleActivity.class)));
        findViewById(R.id.btnNext).setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, TableLayoutActivity.class)));
    }

    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart Called", Toast.LENGTH_LONG).show();
        Log.e("Activity Lifecycle","onStart Called" );
    }

    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart Called", Toast.LENGTH_LONG).show();
        Log.e("Activity Lifecycle", "onRestart Called");
    }
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume Called", Toast.LENGTH_LONG).show();
        Log.e("Activity Lifecycle", "onResume Called");
    }
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause Called", Toast.LENGTH_LONG).show();
        Log.e("Activity Lifecycle", "onPause Called");
    }
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop Called", Toast.LENGTH_LONG).show();
        Log.e("Activity Lifecycle", "onStop Called");
    }
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy Called", Toast.LENGTH_LONG).show();
        Log.e("Activity Lifecycle", "onDestroy Called");
    }
}