package com.activitylifecycle;


import android.os.Bundle;

import com.activitylifecycle.adapter.ViewPagerAdapter;
import com.activitylifecycle.fragment.FragmentOne;
import com.activitylifecycle.fragment.FragmentTwo;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerActivity extends AppCompatActivity implements FragmentOne.SendMessage{

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        viewPager = findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void sendData(String message) {

        String tag = "android:switcher:" + R.id.viewPager + ":" + 1;
        FragmentTwo fragmentTwo = (FragmentTwo) getSupportFragmentManager().findFragmentByTag(tag);
        if(fragmentTwo!=null)
            fragmentTwo.displayReceivedData(message);
        viewPager.setCurrentItem(1);
    }
}