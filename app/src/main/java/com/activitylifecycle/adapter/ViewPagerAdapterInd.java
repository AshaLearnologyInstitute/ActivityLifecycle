package com.activitylifecycle.adapter;


import com.activitylifecycle.fragment.FragmentA;
import com.activitylifecycle.fragment.FragmentB;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import static com.activitylifecycle.ViewPagerIndActivity.NO_OF_ITEM;

public class ViewPagerAdapterInd extends FragmentStatePagerAdapter {
    FragmentManager fm;

    public ViewPagerAdapterInd(FragmentManager fm) {
        super(fm,FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.fm=fm;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new FragmentA();
        } else if (position == 1) {
            fragment = new FragmentB();
        } else {
            fragment = new FragmentA();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return NO_OF_ITEM;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0) {
            title = "Tab-1";
        } else if (position == 1) {
            title = "Tab-2";
        } else {
            title = "Tab-"+(position+1);
        }
        return title;
    }
}
