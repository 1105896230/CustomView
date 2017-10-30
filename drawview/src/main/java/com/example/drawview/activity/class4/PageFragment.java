package com.example.drawview.activity.class4;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static com.example.drawview.activity.class4.Class4Activity.pageModels;


public class PageFragment extends Fragment {
    private View view;

    private int postion;
    public static PageFragment newInstance(int i) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt("position", i);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Class view = pageModels.get(postion).view;
        View v=null;
        try {
            Constructor c1 = view.getDeclaredConstructor(Context.class);
            try {
                v= (View) c1.newInstance(getActivity());
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        v.setLayoutParams(new RelativeLayout.LayoutParams(200,200));
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            postion = args.getInt("position");
        }
    }
}
