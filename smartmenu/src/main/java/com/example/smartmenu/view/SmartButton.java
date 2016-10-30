package com.example.smartmenu.view;
//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                            O\ = /O
//                        ____/`---'\____
//                      .   ' \\| |// `.
//                       / \\||| : |||// \
//                     / _||||| -:- |||||- \
//                       | | \\\ - /// | |
//                     | \_| ''\---/'' | |
//                      \ .-\__ `-` ___/-. /
//                   ___`. .' /--.--\ `. . __
//                ."" '< `.___\_<|>_/___.' >'"".
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |
//                 \ \ `-. \_ __\ /__ _/ .-` / /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//
//         .............................................
//                  佛祖镇楼                  BUG辟易
//          佛曰:
//                  写字楼里写字间，写字间里程序员；
//                  程序人员写程序，又拿程序换酒钱。
//                  酒醒只在网上坐，酒醉还来网下眠；
//                  酒醉酒醒日复日，网上网下年复年。
//                  但愿老死电脑间，不愿鞠躬老板前；
//                  奔驰宝马贵者趣，公交自行程序员。
//                  别人笑我忒疯癫，我笑自己命太贱；
//                  不见满街漂亮妹，哪个归得程序员？

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by "林其望".
 * DATE: 2016:09:19:11:52
 * email:1105896230@qq.com
 */

/**
 * 中心的按钮
 */
public class SmartButton extends View implements ValueAnimator.AnimatorUpdateListener {

    private float mPercent;
    /**
     * the max length of X
     */
    private int mLength;

    private float mMinRadius = 6;


    private float mCenterX;

    private float mCenterY;

    private Paint mPaint;

    private Paint mBackgroundPaint;

    private RectF mLeftRectF = new RectF();

    private RectF mRightRectF = new RectF();

    private int mBackgroundColor = Color.parseColor("#b4282d");

    private int mShadowColor = Color.parseColor("#40000000");

    private int mDotColor = Color.WHITE;

    public SmartButton(Context context) {
        super(context);
        init();
    }

    public SmartButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(mDotColor);
        mBackgroundPaint = new Paint();
        mBackgroundPaint.setAntiAlias(true);
        mBackgroundPaint.setDither(true);
        mBackgroundPaint.setColor(mBackgroundColor);
        mBackgroundPaint.setShadowLayer(15, 0, 0, mShadowColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawBackground(canvas);
        drawCenter(canvas);
        drawContent(canvas);
    }

    private void drawCenter(Canvas canvas) {
        canvas.drawCircle(mCenterX, mCenterY, mMinRadius, mPaint);
    }

    private void adjustCanvas(Canvas canvas, float angle) {
        canvas.save();
        canvas.translate(mCenterX, mCenterY);
        canvas.rotate(angle);
        canvas.translate(-mCenterX, -mCenterY);
    }

    private void drawContent(Canvas canvas) {
        int length = (int) ((mLength - 2 * mMinRadius) * mPercent);
        drawLeft(canvas, mMinRadius, length);
        drawRight(canvas, mMinRadius, length);
    }

    private void drawLeft(Canvas canvas, float radius, int length) {
        adjustCanvas(canvas, 45 * mPercent);
        float start = mCenterX - mLength / 2;
        mLeftRectF.set(start, mCenterY - radius, start + length + 2 * mMinRadius, mCenterY + radius);
        canvas.drawRoundRect(mLeftRectF, radius, radius, mPaint);
        canvas.restore();

    }


    private void drawRight(Canvas canvas, float radius, int length) {
        adjustCanvas(canvas, -45 * mPercent);
        float start = mCenterX + mLength / 2;
        mRightRectF.set(start - length - 2 * mMinRadius, mCenterY - radius, start, mCenterY + radius);
        canvas.drawRoundRect(mRightRectF, radius, radius, mPaint);
        canvas.restore();
    }

    private void drawBackground(Canvas canvas) {

        canvas.drawCircle(mCenterX, mCenterY, getMeasuredWidth() / 2 - 10, mBackgroundPaint);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(size, size);
        mCenterX = getMeasuredWidth() / 2.f;
        mCenterY = getMeasuredHeight() / 2.f;
    }

    @Override
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        mPercent = (float) valueAnimator.getAnimatedValue() / 100.f;
        invalidate();
    }

    void setRadius(float radius) {
        mMinRadius = radius;
    }

    void setLength(int length) {
        mLength = length;
    }

    Paint getBackgroundPaint() {
        return mBackgroundPaint;
    }

    void setDotColor(int color) {
        this.mDotColor = color;
        mPaint.setColor(mDotColor);
        invalidate();
    }

    @Override
    public void setBackgroundColor(int color) {
        mBackgroundColor = color;
        mBackgroundPaint.setColor(color);
        invalidate();
    }

    public void setShadowColor(int color) {
        mShadowColor = color;
        mBackgroundPaint.setShadowLayer(15, 0, 0, color);
        invalidate();
    }
}
