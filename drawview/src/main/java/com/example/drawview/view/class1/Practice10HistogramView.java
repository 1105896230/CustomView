package com.example.drawview.view.class1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Practice10HistogramView extends View {
    private static final String NAME = "直方图";
    Paint paint = new Paint();
    private List<Data> mList;
    private float maxHeight;
    private float space;
    private float width;
    private float startX;
    public Practice10HistogramView(Context context) {
        super(context);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){
        mList = new ArrayList<>();
        mList.add(new Data("Froyo", 10.f, Color.GREEN));
        mList.add(new Data("ICS", 18.0f, Color.GREEN));
        mList.add(new Data("JB", 22.0f, Color.GREEN));
        mList.add(new Data("KK", 27.0f, Color.GREEN));
        mList.add(new Data("L", 40.0f, Color.GREEN));
        mList.add(new Data("M", 60.0f, Color.GREEN));
        mList.add(new Data("N", 33.5f, Color.GREEN));
        for (Data item : mList){
            maxHeight = Math.max(maxHeight, item.getNumber());
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.parseColor("#506E7A"));

        paint.setColor(Color.WHITE);
        paint.setTextSize(30);
        canvas.drawText(NAME,(canvas.getWidth()-paint.measureText(NAME)/2), canvas.getDensity()*0.9f, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        canvas.translate(canvas.getWidth()*0.1f,  canvas.getHeight()*0.75f);
        canvas.drawLine(0,0,0,-canvas.getHeight()*0.6f,paint);
        canvas.drawLine(0,0,canvas.getWidth()*0.8f,0,paint);
        width =  (canvas.getWidth()*0.8f-100)/(mList.size())*0.8f;
        space =  (canvas.getWidth()*0.8f-100)/(mList.size())*0.2f;
        startX = 0f;
        for (Data item:mList){
            paint.setColor(Color.WHITE);
            paint.setStyle(Paint.Style.FILL);
            paint.setTextSize(15);
            canvas.drawText(item.getName(), startX+space+(width-paint.measureText(item.getName()))/2, 30,  paint);
            paint.setColor(item.getColor());
            canvas.drawRect(startX+space, -item.getNumber()/maxHeight*canvas.getHeight()*0.6f, startX+space+width, 0, paint);
            startX = startX+space+width;
        }
//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
    }

    public class Data {
        private String name;
        private float number;
        private int color;



        public Data(String name, float number, int color){
            this.name = name;
            this.number = number;
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public float getNumber() {
            return number;
        }

        public void setNumber(float number) {
            this.number = number;
        }

        public int getColor() {
            return color;
        }

        public void setColor(int color) {
            this.color = color;
        }
    }
}
