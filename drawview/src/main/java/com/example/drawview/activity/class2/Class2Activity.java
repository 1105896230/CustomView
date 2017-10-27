package com.example.drawview.activity.class2;

import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.drawview.R;
import com.example.drawview.view.class1.Practice10HistogramView;
import com.example.drawview.view.class1.Practice11PieChartView;
import com.example.drawview.view.class1.Practice4DrawPointView;
import com.example.drawview.view.class1.Practice5DrawOvalView;
import com.example.drawview.view.class1.Practice6DrawLineView;
import com.example.drawview.view.class1.Practice7DrawRoundRectView;
import com.example.drawview.view.class1.Practice8DrawArcView;
import com.example.drawview.view.class1.Practice9DrawPathView;
import com.example.drawview.view.class2.Practice01LinearGradientView;
import com.example.drawview.view.class2.Practice02RadialGradientView;
import com.example.drawview.view.class2.Practice03SweepGradientView;
import com.example.drawview.view.class2.Practice04BitmapShaderView;
import com.example.drawview.view.class2.Practice05ComposeShaderView;
import com.example.drawview.view.class2.Practice06LightingColorFilterView;
import com.example.drawview.view.class2.Practice07ColorMatrixColorFilterView;
import com.example.drawview.view.class2.Practice08XfermodeView;
import com.example.drawview.view.class2.Practice09StrokeCapView;
import com.example.drawview.view.class2.Practice10StrokeJoinView;
import com.example.drawview.view.class2.Practice11StrokeMiterView;
import com.example.drawview.view.class2.Practice12PathEffectView;
import com.example.drawview.view.class2.Practice13ShadowLayerView;
import com.example.drawview.view.class2.Practice14MaskFilterView;
import com.example.drawview.view.class2.Practice15FillPathView;
import com.example.drawview.view.class2.Practice16TextPathView;

import java.util.ArrayList;
import java.util.List;

public class Class2Activity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager pager;
    public static List<Class2Activity.PageModel> pageModels = new ArrayList<>();

    {
        pageModels.add(new Class2Activity.PageModel(Practice01LinearGradientView.class, R.string.title_linear_gradient));
        pageModels.add(new Class2Activity.PageModel(Practice02RadialGradientView.class, R.string.title_radial_gradient));
        pageModels.add(new Class2Activity.PageModel(Practice03SweepGradientView.class, R.string.title_sweep_gradient));
        pageModels.add(new Class2Activity.PageModel(Practice04BitmapShaderView.class, R.string.title_bitmap_shader));
        pageModels.add(new Class2Activity.PageModel(Practice05ComposeShaderView.class, R.string.title_compose_shader));
        pageModels.add(new Class2Activity.PageModel(Practice06LightingColorFilterView.class, R.string.title_lighting_color_filter));
        pageModels.add(new Class2Activity.PageModel(Practice07ColorMatrixColorFilterView.class, R.string.title_color_matrix_color_filter));
        pageModels.add(new Class2Activity.PageModel(Practice08XfermodeView.class, R.string.title_xfermode));
        pageModels.add(new Class2Activity.PageModel(Practice09StrokeCapView.class, R.string.title_stroke_cap));
        pageModels.add(new Class2Activity.PageModel(Practice10StrokeJoinView.class, R.string.title_stroke_join));
        pageModels.add(new Class2Activity.PageModel(Practice11StrokeMiterView.class, R.string.title_stroke_miter));
        pageModels.add(new Class2Activity.PageModel(Practice12PathEffectView.class, R.string.title_path_effect));
        pageModels.add(new Class2Activity.PageModel(Practice13ShadowLayerView.class, R.string.title_shader_layer));
        pageModels.add(new Class2Activity.PageModel(Practice14MaskFilterView.class, R.string.title_mask_filter));
        pageModels.add(new Class2Activity.PageModel(Practice15FillPathView.class, R.string.title_fill_path));
        pageModels.add(new Class2Activity.PageModel(Practice16TextPathView.class, R.string.title_text_path));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class1);
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                Class2Activity.PageModel pageModel = pageModels.get(position);
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