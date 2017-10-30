package com.example.drawview.view.class4;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.drawview.R;

/**
 * Created by 否命题 on 2017/10/30.
 */

public class Practice13CameraRotateHittingFaceView extends View {
    Paint paint=new Paint();
    int degree;
    private ValueAnimator mAnimator;
    private Camera camera;

    public Practice13CameraRotateHittingFaceView(Context context) {
        super(context);
    }

    public Practice13CameraRotateHittingFaceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice13CameraRotateHittingFaceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    {
        mAnimator = ValueAnimator.ofInt(0,360);
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // 3.为目标对象的属性设置计算好的属性值
                int animatorValue = (int)animation.getAnimatedValue();
               degree=animatorValue;
               invalidate();
            }
        });
        mAnimator.setDuration(5000);
        mAnimator.setRepeatCount(-1);
        mAnimator.start();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mAnimator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mAnimator.end();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e("test",degree+"");
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);

        canvas.drawBitmap(bitmap, 50, 50, paint);
        canvas.save();
        camera = new Camera();
        canvas.translate(50+bitmap.getWidth()/2,300+bitmap.getHeight()/2);
        camera.rotateX(degree);

        camera.applyToCanvas(canvas);
        canvas.translate(-50-bitmap.getWidth()/2,-300-bitmap.getHeight()/2);
        canvas.drawBitmap(bitmap, 50, 300, paint);
        canvas.restore();
    }
}
