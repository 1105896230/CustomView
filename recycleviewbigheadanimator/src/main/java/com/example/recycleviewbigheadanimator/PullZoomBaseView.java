package com.example.recycleviewbigheadanimator;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by "林其望".
 * DATE: 2016:08:07:21:06
 * email:1105896230@qq.com
 */

public abstract class PullZoomBaseView<T extends View> extends LinearLayout {

    //    缩放时间
    protected static final Long ZOOM_BACK_DURATION = 300L;
    //    摩擦系数
    private static final float FRICTION = 2.5f;
    public static final int ZOOM_HEADER = 0;
    public static final int ZOOM_FOOTER = 1;

    protected T mWrapperView;
    protected ViewGroup mHeaderContainer;
    protected View mZoomView;
    private float mInitTouchY;
    private float mInitTouchX;
    private float mLastTouchX;
    private float mLastTouchY;


    //    是否允许缩放
    private boolean isZoomEnable;
    //缩放中
    private boolean isZooming;
    //下拉的开始
    private boolean isPullStart;

    protected int mMode;
    //    双击的参数，通过系统默认设置的数值
    private int mTouchSlop;

    private OnPullZoomListener mOnPullZoomListener;

    public PullZoomBaseView(Context context) {
        this(context, null);
    }

    public PullZoomBaseView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PullZoomBaseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    //初始化
    private void init(Context context, AttributeSet attrs) {
        mTouchSlop = ViewConfiguration.get(context).getScaledDoubleTapSlop();
        mMode = createDefaultPullZoomModel();
        isZoomEnable = true;
        isPullStart = false;
        isZoomEnable = false;
        mWrapperView = createWrapperView(context, attrs);
        addView(mWrapperView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        不允许缩放
        if (!isZoomEnable) {
            return false;
        }
//        手指按下
        if (event.getEdgeFlags() != 0 && event.getAction() == MotionEvent.ACTION_DOWN) {
            return false;
        }
        return performTouchAction(event);
    }

    private boolean performTouchAction(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                if (isPullStart) {
                    return onPullStartActionMove(event);
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                if (isPullStart) {
                    return onPullStartActionCancel();
                }
                break;
            default:
                break;
        }
        return false;
    }

//   手指抬起出发 将参数复原，将试图复原，毁掉结束的方法
    private boolean onPullStartActionCancel() {
        isPullStart = false;
        if (isZooming) {
            isZooming = false;
            smoothScrollToTop();

            if (mOnPullZoomListener != null) {
                final float scrollValue = mMode == ZOOM_HEADER ?
                        Math.round(Math.min(mInitTouchY - mLastTouchY, 0) / FRICTION)
                        : Math.round(Math.max(mInitTouchY - mLastTouchY, 0) / FRICTION);

                mOnPullZoomListener.onPullZoomEnd(scrollValue);
            }
        }
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (!isZoomEnable){
            return false;
        }

        if (event.getAction() == MotionEvent.ACTION_MOVE && isPullStart){
            return true;
        }
        performInterceptAction(event);
        return isPullStart;
    }

    private void onZoomReadyActionDown(MotionEvent event) {
        mInitTouchY = mLastTouchY = event.getY();
        mInitTouchX = mLastTouchX = event.getX();
        isPullStart = false;
    }

    private void onZoomReadyActionMove(MotionEvent event) {
        float mCurrentX = event.getX();
        float mCurrentY = event.getY();

        float xDistance = mCurrentX - mLastTouchX;
        float yDistance = mCurrentY - mLastTouchY;

        Log.i("debug", "mMode" + mMode + "yDistance " + yDistance + "xDistance " + xDistance);
        if (mMode == ZOOM_HEADER && yDistance > mTouchSlop && yDistance > Math.abs(xDistance)
                || mMode == ZOOM_FOOTER && -yDistance > mTouchSlop && -yDistance > Math.abs(xDistance)){
            mLastTouchY = mCurrentY;
            mLastTouchX = mCurrentX;

            if (mOnPullZoomListener != null){
                mOnPullZoomListener.onPullStart();
            }
            isPullStart = true;
        }
    }
    private void performInterceptAction(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (isReadyZoom()){
                    onZoomReadyActionDown(event);
                }
                break;

            case MotionEvent.ACTION_MOVE:
                if (isReadyZoom()) {
                    onZoomReadyActionMove(event);
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                // do nothing
                // the reset action will be done in the function onTouchEvent
                break;
            default:
                break;
        }
    }

    private boolean onPullStartActionMove(MotionEvent event) {
        isZooming = true;
        mLastTouchY = event.getY();
        mLastTouchX = event.getX();

        float scrollValue = mMode == ZOOM_HEADER ?
                Math.round(Math.min(mInitTouchY - mLastTouchY, 0) / FRICTION)
                : Math.round(Math.max(mInitTouchY - mLastTouchY, 0) / FRICTION);
        pullZoomEvent(scrollValue);

        if (mOnPullZoomListener != null) {
            mOnPullZoomListener.onPullZooming(scrollValue);
        }

        return true;
    }

    protected abstract int createDefaultPullZoomModel();

    protected abstract T createWrapperView(Context context, AttributeSet attrs);

    protected abstract void pullZoomEvent(float scrollValue);

    protected abstract void smoothScrollToTop();
    protected abstract boolean isReadyZoom();
    //   缩放的会掉接口
    public interface OnPullZoomListener {
        void onPullZooming(float newScrollValue);

        void onPullStart();

        void onPullZoomEnd(float newScrollValue);
    }
}
