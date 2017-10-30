package com.example.drawview.view.class4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.drawview.R;

/**
 * Created by 否命题 on 2017/10/30.
 */

public class Practice12CameraRotateFixedView extends View{
    Paint paint=new Paint();
    public Practice12CameraRotateFixedView(Context context) {
        super(context);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);

        canvas.drawBitmap(bitmap, 50, 50, paint);
        canvas.save();
        Camera camera=new Camera();
        canvas.translate(50,300);
        camera.rotateX(30);
        camera.applyToCanvas(canvas);
        canvas.translate(-50,-300);
        canvas.drawBitmap(bitmap, 50, 300, paint);
        canvas.restore();
    }
}
