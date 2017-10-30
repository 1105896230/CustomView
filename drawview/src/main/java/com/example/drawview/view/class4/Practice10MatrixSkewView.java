package com.example.drawview.view.class4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.drawview.R;

/**
 * Created by 否命题 on 2017/10/30.
 */

public class Practice10MatrixSkewView extends View {
    Paint paint=new Paint();
    public Practice10MatrixSkewView(Context context) {
        super(context);
    }

    public Practice10MatrixSkewView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10MatrixSkewView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);

        canvas.drawBitmap(bitmap, 50, 50, paint);
        canvas.save();
        Matrix matrix = new Matrix();
        matrix.postSkew(1.3f,1);
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, 50, 300, paint);
        canvas.restore();
    }
}
