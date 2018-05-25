package com.example.tim.pattayatour.airport;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.example.tim.pattayatour.R;

public class MainActivityAirport extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_airport);

        Toolbar toolbar = findViewById(R.id.airport_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = findViewById(R.id.airport_viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        PagerAdapter adapter = new AirportPageAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Find the tab layout that shows the tabs
        TabLayout tabLayout = findViewById(R.id.airport_sliding_tabs);

        // Connect the tab layout with the view pager. This will:
        // 1. Update the tab layout when the view pager is swiped
        // 2. Update the view pager when a tab is selected
        // 3. Set the tab layout's tab names with the view pager's adapter's titles
        // by calling onPageTitle()
        tabLayout.setupWithViewPager(viewPager);

    }
}
