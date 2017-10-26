package com.example.drawview.activity.class1;

import android.app.Application;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.drawview.R;
import com.example.drawview.view.class1.Practice1DrawColorView;

import java.util.ArrayList;
import java.util.List;

public class Class1Activity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager pager;
    public static List<PageModel> pageModels = new ArrayList<>();

    {
        pageModels.add(new PageModel(Practice1DrawColorView.class, R.string.title_draw_color));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class1);
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                PageModel pageModel = pageModels.get(position);
                return PageFragment.newInstance(position);
            }

            @Override
            public int getCount() {
                return pageModels.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(pageModels.get(position).titleRes);
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager);
    }

    public class PageModel {
        public   Class view;
        public @StringRes int titleRes;

        PageModel(Class view, @StringRes int titleRes) {
            this.view=view;
            this.titleRes = titleRes;
        }
    }
}
