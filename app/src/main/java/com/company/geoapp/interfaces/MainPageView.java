package com.company.geoapp.interfaces;

import android.graphics.Bitmap;

import com.hannesdorfmann.mosby.mvp.MvpView;

public interface MainPageView extends MvpView {

    void showRandomIcon(Bitmap imageBitmap);

}
