package com.example.hungry.task;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class HomeAcitivity extends AppCompatActivity implements HomeFragment.DataShare{
ViewPager homeViewPager;
 Toolbar toolbar;
 TabLayout tabLayout;
    PagerTabStrip pagerTabStrip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_acitivity);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        homeViewPager=(ViewPager)findViewById(R.id.mainViewPager);
        homeViewPager.setCurrentItem(0);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        homeViewPager.setAdapter(new ShowTabPagesAdaptor(getSupportFragmentManager(), this));
        tabLayout.setupWithViewPager(homeViewPager);

    }

    @Override
    public void ShareData(int id) {
        Intent locDetailsIntent=new Intent(this,LocationDetailsActivity.class);
        locDetailsIntent.putExtra("position",id);
        startActivity(locDetailsIntent);
    }
}
