package com.company.geoapp.fragments;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.company.geoapp.handlers.Logger;
import com.company.geoapp.handlers.green_bus_events.PicassoViewLoadedEvent;
import com.company.geoapp.interfaces.MainPageView;
import com.company.geoapp.R;
import com.company.geoapp.presenters.MainPagePresenter;
import com.hannesdorfmann.mosby.mvp.MvpFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainPageFragment extends MvpFragment<MainPageView, MainPagePresenter> implements MainPageView {

    private ImageView glideImage;
    private ImageView picassoImage;

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
        EventBus.getDefault().register(this);
        initViews(view);
        presenter.setRandomIcon();
        presenter.setRandomIconPicasso();


        //Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(picassoImage);

        /*try {
            Picasso.get().load("http://i.imgur.com/DvpvklR.png").get();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }

    private void initViews(View view) {
        glideImage = view.findViewById(R.id.glide_image);
        picassoImage = view.findViewById(R.id.picasso_image);
    }

    @Override
    public void showRandomIcon(Bitmap imageBitmap) {
        glideImage.setImageBitmap(imageBitmap);
    }

    @Override
    public void showPicassoIcon(Bitmap imageBitmap) {
        //picassoImage.setImageBitmap(imageBitmap);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe
    public void onPicassoViewLoadedEvent(PicassoViewLoadedEvent event) {
        Logger.infoLog("event received");
        picassoImage.setImageBitmap(event.getBitmap());
    }
}
