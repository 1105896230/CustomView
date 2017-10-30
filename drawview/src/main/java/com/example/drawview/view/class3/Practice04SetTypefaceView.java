package com.example.drawview.view.class3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;

import com.example.drawview.view.BaseDrawView;

/**
 * Created by 否命题 on 2017/10/30.
 */

public class Practice04SetTypefaceView extends BaseDrawView {
    public Practice04SetTypefaceView(Context context) {
        super(context);
    }
    {
        paint.setTextSize(50);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setTypeface(Typeface.DEFAULT);
        canvas.drawText(text,50,100,paint);
        paint.setTypeface(Typeface.SERIF);
        canvas.drawText(text,50,200,paint);
        paint.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "Satisfy-Regular.ttf"));
        canvas.drawText(text,50,300,paint);
    }
}
