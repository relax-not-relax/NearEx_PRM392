package com.example.nearex_prm392;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.nearex_prm392.Adapter.ViewPagerProductAdapter;
import com.google.android.material.tabs.TabLayout;

public class StoreDetail extends AppCompatActivity {

    private TabLayout cateTabLayout;
    private ViewPager cateView;

    private ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_detail);

        cateTabLayout = findViewById(R.id.tab_layout);
        cateView = findViewById(R.id.view_pager);

        ViewPagerProductAdapter viewPagerProductAdapter = new ViewPagerProductAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        cateView.setAdapter(viewPagerProductAdapter);

        cateTabLayout.setupWithViewPager(cateView);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}