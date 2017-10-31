package com.example.drawview.activity.class4;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.drawview.R;
import com.example.drawview.view.class4.Practice03TranslateView;
import com.example.drawview.view.class4.*;

import java.util.ArrayList;
import java.util.List;

public class Class4Activity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager pager;
    public static List<PageModel> pageModels = new ArrayList<>();

    {
        pageModels.add(new PageModel(Sample01ClipRectView.class, R.string.title_clip_rect));
        pageModels.add(new PageModel(Practice02ClipPathView.class,R.string.title_clip_path));
        pageModels.add(new PageModel(Practice03TranslateView.class,R.string.title_translate));
        pageModels.add(new PageModel(Practice04ScaleView.class,R.string.title_scale));
        pageModels.add(new PageModel(Practice05RotateView.class,R.string.title_rotate));
        pageModels.add(new PageModel(Practice06SkewView.class,R.string.title_skew));
        pageModels.add(new PageModel(Practice07MatrixTranslateView.class,R.string.title_matrix_translate));
        pageModels.add(new PageModel(Practice08MatrixScaleView.class,R.string.title_matrix_scale));
        pageModels.add(new PageModel(Practice09MatrixRotateView.class,R.string.title_matrix_rotate));
        pageModels.add(new PageModel(Practice10MatrixSkewView.class,R.string.title_matrix_skew));
        pageModels.add(new PageModel(Practice11CameraRotateView.class,R.string.title_camera_rotate));
        pageModels.add(new PageModel(Practice12CameraRotateFixedView.class,R.string.title_camera_rotate_fixed));
        pageModels.add(new PageModel(Practice13CameraRotateHittingFaceView.class,R.string.title_camera_rotate_hitting_face));
        pageModels.add(new PageModel(Practice14FlipboardView.class,R.string.title_flipboard));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class1);
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                Class4Activity.PageModel pageModel = pageModels.get(position);
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
