package com.example.drawview.view.class3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import java.nio.file.Path;

/**
 * Created by 否命题 on 2017/10/30.
 */

public class Practice02StaticLayoutView extends View {
    TextPaint paint = new TextPaint();
    private String STR1 = "Hello HenCoder";
    {
        paint.setTextSize(60);
    }
    public Practice02StaticLayoutView(Context context) {
        super(context);
    }

    public Practice02StaticLayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02StaticLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        StaticLayout staticLayout=new StaticLayout(STR1, (TextPaint) paint,100, Layout.Alignment.ALIGN_NORMAL,1,0,true);

        staticLayout.draw(canvas);
    }
}
