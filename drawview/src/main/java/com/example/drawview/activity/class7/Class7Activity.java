package com.example.drawview.activity.class7;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.drawview.R;
import com.example.drawview.view.class6.Practice01Translation;
import com.example.drawview.view.class6.Sample02Rotation;
import com.example.drawview.view.class6.Sample03Scale;
import com.example.drawview.view.class6.Sample04Alpha;
import com.example.drawview.view.class6.Sample05MultiProperties;
import com.example.drawview.view.class6.sample08.Sample08ObjectAnimatorLayout;

import java.util.ArrayList;
import java.util.List;

public class Class7Activity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager pager;
    public static List<PageModel> pageModels = new ArrayList<>();

    {

        pageModels.add(new PageModel(Practice01Translation.class,R.string.title_translation));

        pageModels.add(new PageModel(Sample02Rotation.class,R.string.title_rotation));
        pageModels.add(new PageModel(Sample03Scale.class,R.string.title_scale));
        pageModels.add(new PageModel(Sample04Alpha.class,R.string.title_alpha));
        pageModels.add(new PageModel(Sample05MultiProperties.class,R.string.title_multi_properties));
        pageModels.add(new PageModel(Sample08ObjectAnimatorLayout.class,R.string.animate));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class1);
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                Class7Activity.PageModel pageModel = pageModels.get(position);
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
