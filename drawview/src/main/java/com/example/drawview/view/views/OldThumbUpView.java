package com.example.drawview.view.views;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.drawview.R;

/**
 * Created by 林其望 on 2017/11/1.
 * email 1105896230@qq.com
 * blog
 */

public class OldThumbUpView extends View implements View.OnClickListener {
    private boolean isSelect=false;
    private Paint paint=new Paint();
    private Paint textPaint=new Paint();

    private String content="101";

    public float textMaxProgress=60;
    Bitmap like_selected;
    Bitmap like_unselected;
    Bitmap like_selected_shining;
    public  float textProgress;
    private AnimatorSet set;

    {
        like_selected= BitmapFactory.decodeResource(getResources(), R.drawable.ic_messages_like_selected);
        like_unselected= BitmapFactory.decodeResource(getResources(), R.drawable.ic_messages_like_unselected);
        like_selected_shining= BitmapFactory.decodeResource(getResources(), R.drawable.ic_messages_like_selected_shining);

        textPaint.setTextSize(30);
        setOnClickListener(this);
    }

    public OldThumbUpView(Context context) {
        super(context);
    }

    public OldThumbUpView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public OldThumbUpView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        onDrawIcon(canvas);
        onDrawText(canvas);
    }


    private void onDrawText(Canvas canvas) {
        char c = content.charAt(content.length() - 1);
        String substring = content.substring(0, content.length() - 1);
        canvas.drawText(substring,getWidth()/2+like_selected.getWidth()/2+10,getHeight()/2+like_selected.getHeight()/2,textPaint);
        canvas.drawText(c+"",getWidth()/2+like_selected.getWidth()/2+10+textPaint.measureText(substring),getHeight()/2+like_selected.getHeight()/2+textProgress,textPaint);
    }

    private void onDrawIcon(Canvas canvas) {
        if (isSelect){
            canvas.drawBitmap(like_selected,getWidth()/2-like_selected.getWidth()/2,getHeight()/2-like_selected.getHeight()/2,paint);
        }else {
            canvas.drawBitmap(like_unselected,getWidth()/2-like_unselected.getWidth()/2,getHeight()/2-like_unselected.getHeight()/2,paint);
        }
    }



    public void setTextProgress(float textProgress) {
        this.textProgress = textProgress;
        Log.i("old",textProgress+"");
        invalidate();
    }
    @Override
    public void onClick(View view) {
        animatorStart();
        isSelect=!isSelect;
        invalidate();
    }
    private void animatorStart(){
        if (set!=null&&set.isRunning())
        set.cancel();
        ObjectAnimator textOffsetY;
        if (isSelect){
            textOffsetY=ObjectAnimator.ofFloat(this,"textProgress",0,textMaxProgress);
        }else {
            textOffsetY=ObjectAnimator.ofFloat(this,"textProgress",0,-textMaxProgress);
        }
        textOffsetY.setDuration(500);
        set = new AnimatorSet();
        set.play(textOffsetY);
        set.start();
    }
}
