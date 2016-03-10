package custom.fmt.com.mycustomview.views;/**
 * Created by hasee-pc on 2016/3/10.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * User:FMT
 * Email:1105896230@qq.com
 * DATA:2016/3/10
 * Time:22:31
 *
 */
public class RevealLayout extends LinearLayout implements Runnable {

    private int INVALIDATE_DURATION = 40;

    private boolean mIsPressed = false;

    public RevealLayout(Context context) {
        this(context, null);
    }

    public RevealLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RevealLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void run() {

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int x = (int) ev.getRawX();
        int y = (int) ev.getRawY();
        int action = ev.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            View view = getTouchTarget(this, x, y);
            if (view.isClickable() && view.isEnabled()) {
                //获取到点击到的view
                View mTouchTarget = view;
            }
        } else if (action == MotionEvent.ACTION_UP) {

        } else if (action == MotionEvent.ACTION_CANCEL) {
            mIsPressed = false;
            postInvalidateDelayed(INVALIDATE_DURATION);
        }
        return super.dispatchTouchEvent(ev);
    }

    //获取可触碰到所以view
    private View getTouchTarget(View view, int x, int y) {
        View target = null;
        ArrayList<View> touchables = view.getTouchables();

        for (View chilid : touchables) {
            if (isTouchPointInView(chilid, x, y)) {
                target = chilid;
                break;
            }
        }
        return target;
    }

    //判断view是否被点击到
    private boolean isTouchPointInView(View view, int x, int y) {
        int[] location = new int[2];
        //view 位于整个屏幕的坐标
        view.getLocationOnScreen(location);
        int left = location[0];
        int top = location[1];
        int right = left + view.getMeasuredWidth();
        int bottom = top + view.getMeasuredHeight();
        if (view.isClickable() && y >= top && y <= bottom && x >= left && x <= right) {
            return true;
        }
        return false;
    }

    public void initParametersForChild(MotionEvent event, View view) {
        int x = (int) event.getX();
        int y = (int) event.getY();
    }
}
