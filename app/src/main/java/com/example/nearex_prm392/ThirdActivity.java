package com.example.nearex_prm392;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    ViewPager2 viewPager2;
    ArrayList<ViewPageItem> viewPagerItems;
    AppCompatButton btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        viewPager2 = (ViewPager2) findViewById(R.id.viewPager);
        int[] images = {R.drawable.slide_1, R.drawable.slide_2, R.drawable.slide_3};
        String[] headings = {getString(R.string.heading_one), getString(R.string.heading_two), getString(R.string.heading_three)};
        String[] descriptions = {getString(R.string.desc_one), getString(R.string.desc_two), getString(R.string.desc_three)};

        viewPagerItems = new ArrayList<>();

        for (int i = 0; i < images.length; i++) {
            ViewPageItem viewPagerItem = new ViewPageItem(images[i], headings[i], descriptions[i]);
            viewPagerItems.add(viewPagerItem);
        }

        ViewPageAdapter vpAdapter = new ViewPageAdapter(viewPagerItems);

        viewPager2.setAdapter(vpAdapter);
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(2);
        viewPager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);

        btnNext = (AppCompatButton) findViewById(R.id.buttonNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getItem(0) < 2) {
                    viewPager2.setCurrentItem(getItem(1), true);
                } else {
                    startActivity(new Intent(ThirdActivity.this, LoginActivity.class ));
                }

            }
        });


    }

    private int getItem(int i) {
        return viewPager2.getCurrentItem() + i;
    }
}