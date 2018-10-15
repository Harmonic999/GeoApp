package com.company.geoapp.fragments;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.company.geoapp.R;
import com.company.geoapp.handlers.green_bus_events.SwipeLeftEvent;
import com.company.geoapp.handlers.green_bus_events.SwipeRightEvent;
import com.company.geoapp.views.CustomView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class CustomViewFragment extends Fragment {

    private CustomView customView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_custom_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        customView = view.findViewById(R.id.graph);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void handleSwipeRight(SwipeRightEvent event) {
        ObjectAnimator animation = ObjectAnimator.ofFloat(customView, "translationX", 0);
        animation.setDuration(500);
        animation.start();
    }

    @Subscribe
    public void handleSwipeLeft(SwipeLeftEvent event) {
        Resources r = getResources();
        float px = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                8,
                r.getDisplayMetrics()
        );

        ObjectAnimator animation = ObjectAnimator.ofFloat(customView, "translationX", -customView.getWidth() - px);
        animation.setDuration(500);
        animation.start();
    }
}
