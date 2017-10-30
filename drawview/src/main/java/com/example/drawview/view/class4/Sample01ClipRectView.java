package com.example.drawview.view.class4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.drawview.R;

/**
 * Created by 否命题 on 2017/10/30.
 */

public class Sample01ClipRectView extends View {

    private Paint paint=new Paint();
    public Sample01ClipRectView(Context context) {
        super(context);
    }

    public Sample01ClipRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample01ClipRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        int left = (getWidth() - bitmap.getWidth()) / 2;
        int top = (getHeight() - bitmap.getHeight()) / 2;

        canvas.save();
        canvas.clipRect(left + 50, top + 50, left + 250, top + 210);
        canvas.drawBitmap(bitmap, left, top, paint);
        canvas.restore();
    }
}
