package com.example.drawview.activity.class3;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.drawview.R;
import com.example.drawview.view.class3.Practice01DrawTextView;
import com.example.drawview.view.class3.Practice02StaticLayoutView;
import com.example.drawview.view.class3.Practice03SetTextSizeView;
import com.example.drawview.view.class3.*;

import java.util.ArrayList;
import java.util.List;

public class Class3Activity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager pager;
    public static List<PageModel> pageModels = new ArrayList<>();

    {
        pageModels.add(new Class3Activity.PageModel(Practice01DrawTextView.class, R.string.title_draw_text));
        pageModels.add(new Class3Activity.PageModel(Practice02StaticLayoutView.class,R.string.title_static_layout));
        pageModels.add(new Class3Activity.PageModel(Practice03SetTextSizeView.class,R.string.title_set_text_size));
        pageModels.add(new Class3Activity.PageModel(Practice04SetTypefaceView.class,R.string.title_set_typeface));
        pageModels.add(new PageModel(Practice05SetFakeBoldTextView.class, R.string.title_set_fake_bold_text));
        pageModels.add(new PageModel(Practice06SetStrikeThruTextView.class, R.string.title_set_strike_thru_text));
        pageModels.add(new PageModel(Practice07SetUnderlineTextView.class, R.string.title_set_underline_text));
        pageModels.add(new PageModel(Practice08SetTextSkewXView.class, R.string.title_set_text_skew_x));
        pageModels.add(new PageModel(Practice09SetTextScaleXView.class, R.string.title_set_text_scale_x));
        pageModels.add(new PageModel(Practice10SetTextAlignView.class, R.string.title_set_text_align));
        pageModels.add(new PageModel(Practice11GetFontSpacingView.class, R.string.title_get_font_spacing));
        pageModels.add(new PageModel(Practice12MeasureTextView.class, R.string.title_measure_text));
        pageModels.add(new PageModel(Practice13GetTextBoundsView.class, R.string.title_get_text_bounds));
        pageModels.add(new PageModel(Practice14GetFontMetricsView.class, R.string.title_get_font_metrics));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class1);
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                Class3Activity.PageModel pageModel = pageModels.get(position);
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
