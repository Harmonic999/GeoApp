package com.company.geoapp.handlers;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;

public class ImageViewUtils {

    private ImageViewUtils() {

    }

    public static Bitmap cropCircle(Bitmap src) {

        Bitmap output = Bitmap.createBitmap(src.getWidth(), src.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(0XFF000000);

        int x = src.getWidth() / 2;
        int y = src.getHeight() / 2;
        int radius = src.getWidth() / 2;

        Path path = new Path();
        path.addCircle(x, y, radius, Path.Direction.CW);

        canvas.drawPath(path, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(src, 0, 0, paint);

        return output;
    }


}
