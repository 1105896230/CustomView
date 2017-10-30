package com.example.drawview.view.class3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice13GetTextBoundsView extends View {
    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text1 = "A";
    String text2 = "a";
    String text3 = "J";
    String text4 = "j";
    String text5 = "Â";
    String text6 = "â";
    int top = 200;
    int bottom = 400;

    public Practice13GetTextBoundsView(Context context) {
        super(context);
    }

    public Practice13GetTextBoundsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice13GetTextBoundsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(20);
        paint1.setColor(Color.parseColor("#E91E63"));
        paint2.setTextSize(160);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //paint1用来画框，即最外边的红框
        //paint2用来写字，即框内部的字
        canvas.drawRect(50, top, getWidth() - 50, bottom, paint1);

        // 使用 Paint.getTextBounds() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让文字精准地居中，分毫不差

        //先计算出一个初始的中间的基数，再在这个基数的基础之上增加偏移量
        int middle = (top + bottom) / 2;

        @SuppressLint("DrawAllocation")
        Rect rect = new Rect();
        paint2.getTextBounds(text1, 0, text1.length(), rect);
        int offset1 = -(rect.top + rect.bottom) / 2;

        paint2.getTextBounds(text2, 0, text2.length(), rect);
        int offset2 = -(rect.top + rect.bottom) / 2;

        paint2.getTextBounds(text3, 0, text3.length(), rect);
        int offset3 = -(rect.top + rect.bottom) / 2;

        paint2.getTextBounds(text4, 0, text4.length(), rect);
        int offset4 = -(rect.top + rect.bottom) / 2;

        paint2.getTextBounds(text5, 0, text5.length(), rect);
        int offset5 = -(rect.top + rect.bottom) / 2;

        paint2.getTextBounds(text6, 0, text6.length(), rect);
        int offset6 = -(rect.top + rect.bottom) / 2;

        canvas.drawText(text1, 100, middle + offset1, paint2);
        canvas.drawText(text2, 200, middle + offset2, paint2);
        canvas.drawText(text3, 300, middle + offset3, paint2);
        canvas.drawText(text4, 400, middle + offset4, paint2);
        canvas.drawText(text5, 500, middle + offset5, paint2);
        canvas.drawText(text6, 600, middle + offset6, paint2);
    }
}