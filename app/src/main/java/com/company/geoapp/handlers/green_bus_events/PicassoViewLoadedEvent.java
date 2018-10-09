package com.company.geoapp.handlers.green_bus_events;

import android.graphics.Bitmap;

public class PicassoViewLoadedEvent {

    private final Bitmap bitmap;

    public PicassoViewLoadedEvent(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }
}
