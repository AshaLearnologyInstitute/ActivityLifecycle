package com.activitylifecycle;


import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.activitylifecycle.adapter.ViewPagerAdapterInd;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerIndActivity extends AppCompatActivity{

    public static final int NO_OF_ITEM=4;
    private LinearLayout llPagerDots;
    ViewPager viewPager;
    ViewPagerAdapterInd viewPagerAdapter;
    private ImageView[] ivArrayDotsPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_ind);

        setUpViewPager();
    }

    public void setUpViewPager() {
        viewPager = findViewById(R.id.viewPager);
        llPagerDots = (LinearLayout) findViewById(R.id.pager_dots);

        viewPagerAdapter = new ViewPagerAdapterInd(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

        setupPagerIndidcatorDots();

        ivArrayDotsPager[0].setImageResource(R.drawable.selected);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < ivArrayDotsPager.length; i++) {
                    if(i!=position)
                        ivArrayDotsPager[i].setImageResource(R.drawable.unselected);
                    else
                        ivArrayDotsPager[i].setImageResource(R.drawable.selected);
                }
//                ivArrayDotsPager[position].setImageResource(R.drawable.selected);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setupPagerIndidcatorDots() {
        ivArrayDotsPager = new ImageView[NO_OF_ITEM];
        for (int i = 0; i < ivArrayDotsPager.length; i++) {
            ivArrayDotsPager[i] = new ImageView(getApplicationContext());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(10, 0, 10, 0);
            ivArrayDotsPager[i].setLayoutParams(params);
            ivArrayDotsPager[i].setImageResource(R.drawable.unselected);
            /*ivArrayDotsPager[i].setOnClickListener(view ->{
                view.setAlpha(1);
            });*/
            llPagerDots.addView(ivArrayDotsPager[i]);
            llPagerDots.bringToFront();
        }
    }

}