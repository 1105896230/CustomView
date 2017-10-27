package com.example.drawview.view.class2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.drawview.R;


public class Practice06LightingColorFilterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);


    public Practice06LightingColorFilterView(Context context) {
        super(context);
    }

    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap=BitmapFactory.decodeResource(getResources(), R.mipmap.batman);
        ColorFilter lightingColorFilter = new LightingColorFilter(0x00ffff, 0x000000);
        paint.setColorFilter(lightingColorFilter);

        canvas.drawBitmap(bitmap,0,0,paint);


        paint.setColorFilter( new LightingColorFilter(0x00ffff, 0x003000));
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 100, 0, paint);
    }
}
