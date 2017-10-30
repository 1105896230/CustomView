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

public class Practice05RotateView extends View {
    private Paint paint=new Paint();
    public Practice05RotateView(Context context) {
        super(context);
    }

    public Practice05RotateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice05RotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);

        canvas.drawBitmap(bitmap, 50, 50, paint);
        canvas.save();
        canvas.rotate(45,50+bitmap.getWidth()/2,300+bitmap.getHeight()/2);
        canvas.drawBitmap(bitmap, 50, 300, paint);
        canvas.restore();
    }
}
