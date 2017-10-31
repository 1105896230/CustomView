package com.example.drawview.activity.class5;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.drawview.R;
import com.example.drawview.view.class5.*;
import java.util.ArrayList;
import java.util.List;

public class Class5Activity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager pager;
    public static List<PageModel> pageModels = new ArrayList<>();

    {

        pageModels.add(new PageModel(Sample01AfterOnDrawView.class,R.string.title_after_on_draw));
        pageModels.add(new PageModel(Sample02BeforeOnDrawView.class,R.string.title_before_on_draw));
        pageModels.add(new PageModel(Sample03OnDrawLayout.class,R.string.title_on_draw_layout));
        pageModels.add(new PageModel(Sample04DispatchDrawLayout.class,R.string.title_dispatch_draw));
        pageModels.add(new PageModel(Sample05AfterOnDrawForegroundView.class,R.string.title_after_on_draw_foreground));
        pageModels.add(new PageModel(Sample06BeforeOnDrawForegroundView.class,R.string.title_before_on_draw_foreground));
        pageModels.add(new PageModel(Sample07AfterDrawView.class,R.string.title_after_draw));
        pageModels.add(new PageModel(Sample08BeforeDrawView.class,R.string.title_before_draw));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class1);
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                Class5Activity.PageModel pageModel = pageModels.get(position);
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
        public Class view;
        public @StringRes
        int titleRes;

        PageModel(Class view, @StringRes int titleRes) {
            this.view = view;
            this.titleRes = titleRes;
        }
    }

}
