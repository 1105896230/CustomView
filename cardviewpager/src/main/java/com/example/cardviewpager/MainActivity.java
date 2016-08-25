package com.example.cardviewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private CardViewPagerAdapter mCardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mCardAdapter = new CardViewPagerAdapter();
        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setOffscreenPageLimit(3);
    }
}
