package com.example.dripintoariver;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by "林其望".
 * DATE: 2016:09:26:20:39
 * email:1105896230@qq.com
 */

public class SmallCirView extends View {
    public SmallCirView(Context context) {
        this(context, null);
    }

    public SmallCirView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SmallCirView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
    }

    int width = 20, height = 20;

    private Paint mPaint;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(width / 2, height / 2, 100, mPaint);
    }
}
