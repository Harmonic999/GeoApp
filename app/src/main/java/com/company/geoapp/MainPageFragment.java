package com.company.geoapp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hannesdorfmann.mosby.mvp.MvpFragment;

public class MainPageFragment extends MvpFragment<MainPageView, MainPagePresenter> implements MainPageView {

    private ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_page, container, false);
    }

    @Override
    public MainPagePresenter createPresenter() {
        return new MainPagePresenter(getContext());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        presenter.setRandomIcon();
    }

    private void initViews(View view) {
        imageView = view.findViewById(R.id.hello_image);
    }

    @Override
    public void showRandomIcon(Bitmap imageBitmap) {
        imageView.setImageBitmap(imageBitmap);
    }
}
