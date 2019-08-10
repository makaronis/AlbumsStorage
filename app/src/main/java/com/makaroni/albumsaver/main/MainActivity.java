package com.makaroni.albumsaver.main;

import android.os.Bundle;

import androidx.viewpager.widget.ViewPager;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.makaroni.albumsaver.R;
import com.makaroni.albumsaver.utility.FragmentAdapter;

public class MainActivity extends MvpAppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabs);
        // Create an adapter that knows which fragment should be shown on each page
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(),0,MainActivity.this);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }


}
