package com.example.drawview.view;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 否命题 on 2017/10/30.
 */

public class BaseDrawView extends View{
    public Paint paint=new Paint();
    public  String text = "Hello HenCoder";
    public BaseDrawView(Context context) {
        super(context);
    }

    public BaseDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
