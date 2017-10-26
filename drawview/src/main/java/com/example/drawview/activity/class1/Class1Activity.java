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
import com.example.drawview.view.class1.*;

import java.util.ArrayList;
import java.util.List;

public class Class1Activity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager pager;
    public static List<PageModel> pageModels = new ArrayList<>();

    {
        pageModels.add(new PageModel(Practice1DrawColorView.class, R.string.title_draw_color));
        pageModels.add(new PageModel(Practice2DrawCircleView.class, R.string.title_draw_circle));
        pageModels.add(new PageModel(Practice3DrawRectView.class, R.string.title_draw_rect));
        pageModels.add(new PageModel(Practice4DrawPointView.class, R.string.title_draw_point));
        pageModels.add(new PageModel(Practice5DrawOvalView.class, R.string.title_draw_oval));
        pageModels.add(new PageModel(Practice6DrawLineView.class, R.string.title_draw_line));
        pageModels.add(new PageModel(Practice7DrawRoundRectView.class, R.string.title_draw_round_rect));
        pageModels.add(new PageModel(Practice8DrawArcView.class, R.string.title_draw_arc));
        pageModels.add(new PageModel(Practice9DrawPathView.class, R.string.title_draw_path));
        pageModels.add(new PageModel(Practice10HistogramView.class, R.string.title_draw_histogram));
        pageModels.add(new PageModel(Practice11PieChartView.class, R.string.title_draw_pie_chart));
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
