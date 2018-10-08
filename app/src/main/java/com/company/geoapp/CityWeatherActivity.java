package com.company.geoapp;

import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.company.geoapp.handlers.Logger;
import com.hannesdorfmann.mosby.mvp.MvpActivity;

import butterknife.OnClick;


public class CityWeatherActivity extends MvpActivity<CityWeatherView, CityWeatherPresenter> implements CityWeatherView {

    private DrawerLayout drawer;
    private TextView locationTextView;
    private TextView descriptionTextView;
    private TextView temperatureTextView;
    private EditText textInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_weather);
        initializeViews();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.city_weather, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @NonNull
    @Override
    public CityWeatherPresenter createPresenter() {
        return new CityWeatherPresenter();
    }

    @OnClick(R.id.showWeatherBtn)
    public void submit() {
        presenter.handleUserInput(textInput.getText().toString());
    }

    @Override
    public void showWeatherInfo(String location, String description, String temperature) {

    }

    private void initializeViews() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        locationTextView = findViewById(R.id.locationTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);
        temperatureTextView = findViewById(R.id.temperatureTextView);
        textInput = findViewById(R.id.textInput);

        //NavigationView navigationView = findViewById(R.id.nav_view);
        //navigationView.setNavigationItemSelectedListener(this);
    }
}
