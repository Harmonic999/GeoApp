package com.company.geoapp;

import android.os.Bundle;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import com.company.geoapp.fragments.CustomViewFragment;
import com.company.geoapp.fragments.MainPageFragment;
import com.company.geoapp.fragments.WeatherFragment;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

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

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();

        switch (action) {

        }

        return super.onTouchEvent(event);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment fragment = null;
        Bundle arguments = new Bundle();

        switch (id) {
            case R.id.nav_main:
                fragment = new MainPageFragment();
                break;

            case R.id.nav_kiev:
                fragment = new WeatherFragment();
                arguments.putString("cityName", "kiev");
                break;

            case R.id.nav_dublin:
                fragment = new WeatherFragment();
                arguments.putString("cityName", "dublin");
                break;

            case R.id.nav_paris:
                fragment = new WeatherFragment();
                arguments.putString("cityName", "paris");
                break;

            case R.id.nav_london:
                //fragment = new WeatherFragment();
                fragment = new CustomViewFragment();
                //arguments.putString("cityName", "london");
                break;
        }

        if (fragment != null) {
            fragment.setArguments(arguments);
            ft.replace(R.id.fragments_container, fragment);
            ft.addToBackStack(null);
            ft.commit();
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initializeViews() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        FrameLayout frameLayout = findViewById(R.id.fragments_container);
        frameLayout.setOnTouchListener(new OnSwipeTouchListener(this));


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


}
