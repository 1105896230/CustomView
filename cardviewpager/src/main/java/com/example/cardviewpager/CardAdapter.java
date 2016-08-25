package com.example.cardviewpager;

import android.support.v7.widget.CardView;

/**
 * Created by "林其望".
 * DATE: 2016:08:25:21:45
 * email:1105896230@qq.com
 */

public interface CardAdapter {
    int MAX_ELEVATION_FACTOR = 8;

    float getBaseElevation();

    //获取第几个cardView
    CardView getCardViewAt(int position);

    //总个数
    int getCount();
}
