package com.example.drawview.view.class4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.drawview.R;

import static android.graphics.Path.Direction.CCW;
import static android.graphics.Path.Direction.CW;

/**
 * Created by 否命题 on 2017/10/30.
 */

public class Practice02ClipPathView extends View{
    Paint paint=new Paint();
    Path path=new Path();
    Path path2=new Path();
    {
        path.addCircle(300,300,50,CW);
        path2.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        path2.addCircle(300,600,50,CCW);

    }
    public Practice02ClipPathView(Context context) {
        super(context);
    }

    public Practice02ClipPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02ClipPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);

        canvas.save();
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap, 200, 200, paint);
        canvas.restore();

        canvas.save();
        canvas.clipPath(path2);
        canvas.drawBitmap(bitmap, 200, 500, paint);
        canvas.restore();
    }
}
