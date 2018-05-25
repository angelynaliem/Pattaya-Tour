package com.example.tim.pattayatour;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import com.example.tim.pattayatour.adult.MainActivityAdult;
import com.example.tim.pattayatour.airport.MainActivityAirport;
import com.example.tim.pattayatour.family.MainActivityFamily;
import com.example.tim.pattayatour.lodging.MainActivityLodging;
import com.example.tim.pattayatour.shopping.MainActivityShopping;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {

                switch (menuitem.getItemId()) {
                    case R.id.nav_getting_here:
                        Intent navGetHere = new Intent(MainActivity.this, MainActivityAirport.class);
                        startActivity(navGetHere);
                        break;
                    case R.id.nav_shopping:
                        Intent navShopping = new Intent(MainActivity.this, MainActivityShopping.class);
                        startActivity(navShopping);
                        break;
                    case R.id.nav_lodging:
                        Intent navLodging = new Intent(MainActivity.this, MainActivityLodging.class);
                        startActivity(navLodging);
                        break;
                    case R.id.nav_family_activities:
                        Intent navFamily = new Intent(MainActivity.this, MainActivityFamily.class);
                        startActivity(navFamily);
                        break;
                    case R.id.nav_adult_activities:
                        Intent navAdult = new Intent(MainActivity.this, MainActivityAdult.class);
                        startActivity(navAdult);
                }

                menuitem.setChecked(true);

                mDrawerLayout.closeDrawers();


                return false;
            }
        });
    }
}
