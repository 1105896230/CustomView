package com.example.dripintoariver;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by "林其望".
 * DATE: 2016:09:26:20:13
 * email:1105896230@qq.com
 */

public class DGDownloaderButtonProgressView extends ViewGroup {
    private int width;
    private int height;

    public DGDownloaderButtonProgressView(Context context) {
        this(context, null);
    }

    public DGDownloaderButtonProgressView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DGDownloaderButtonProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        startAnimation();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
    }


    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
    }

    private Paint mPaint;

    @Override
    protected void onDraw(Canvas canvas) {
        drawCircleBorder(canvas);
    }

    //画圆形边界
    private void drawCircleBorder(Canvas canvas) {
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(width / 2, height / 2, 100, mPaint);
    }

    private void startAnimation() {
        float pointRadius = 8.f;
        SmallCirView view = new SmallCirView(getContext());
        addView(view);
    }
}
