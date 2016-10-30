package com.example.dripintoariver;


import android.graphics.Point;

/**
 * Created by "林其望".
 * DATE: 2016:09:26:20:25
 * email:1105896230@qq.com
 */

public class DGDownloaderMath {
    public static Point calcControlPoint(Point p1, Point p2, boolean isRandom) {
        Point center = new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
        float d = calcDistance(p1, p2);
        int k = (int) (d / 40.f);
        if (isRandom) {
            int isRandom_int = (int) (Math.random() % 2);
            if (isRandom) k = -k;
        }
        int new_x = (p1.y - p2.y) / 2 / k + (p1.x + p2.x) / 2;
        int new_y = -((p1.x - p2.x) / 2 / k - (p1.y + p2.y) / 2);

        return new Point(new_x, new_y);
    }

    public static Point calcControlPoint(Point p1, Point p2) {
        return calcControlPoint(p1, p2, false);
    }

    public static float calcDistance(Point p1, Point p2) {
        float x = p1.x - p2.x;
        float y = p1.y - p2.y;
        return (float) Math.sqrt((x * x + y * y));
    }
}
