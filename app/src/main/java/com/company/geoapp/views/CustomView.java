package com.company.geoapp.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.company.geoapp.handlers.Logger;

import java.util.ArrayList;

public class CustomView extends View {

    private Paint orangePaint = new Paint();
    private Paint blackPaint = new Paint();

    private ArrayList<Point> points;

    private static float maxX;
    private static float maxY;
    private static float scaleX;
    private static float scaleY;

    private static final int offsetTop = 32;
    private static final int offsetLeft = 20;

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        points = new ArrayList<>();
        points.add(new Point(0, 1));
        points.add(new Point(1, 2));
        points.add(new Point(2, 0));
        points.add(new Point(4, 3));
        points.add(new Point(6, 2));

        orangePaint.setColor(Color.parseColor("#fc9b14"));
        orangePaint.setStrokeWidth(3);

        blackPaint.setColor(Color.BLACK);
        blackPaint.setStrokeWidth(3);
        blackPaint.setTextSize(32);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //orangePaint.setColor(Color.parseColor("#fc9b14"));
        //orangePaint.setStrokeWidth(3);

        //draw borders
        canvas.drawLine(1, 1, getWidth(), 1 , blackPaint);
        canvas.drawLine(getWidth() - 1, 1, getWidth() - 1, getHeight() - 1 , blackPaint);
        canvas.drawLine(1, getHeight() - 1, getWidth(), getHeight() - 1, blackPaint);
        canvas.drawLine(1, 1, 1, getHeight() - 1 , blackPaint);

        //draw graph
        for (int i = 0; i < points.size() - 1; i++) {
            Point start = points.get(i);
            Point end = points.get(i + 1);
            canvas.drawLine(start.x * scaleX,
                    start.y * scaleY + offsetTop / 2,
                    end.x * scaleX,
                    end.y * scaleY + offsetTop / 2,
                    orangePaint);

            canvas.drawText("x:" + end.x + " y:" + end.y,
                    end.x * scaleX,
                    end.y * scaleY + 32, blackPaint);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        maxX = 6;
        maxY = 3;
        scaleX = getMeasuredWidth() / maxX;
        scaleY = getMeasuredHeight() / maxY - offsetTop / 2;
        Logger.infoLog(String.valueOf(getMeasuredWidth()));
        Logger.infoLog(String.valueOf(getMeasuredHeight()));
    }

    private static class Point {

        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }


    }
}
