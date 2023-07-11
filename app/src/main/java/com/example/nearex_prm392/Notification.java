package com.example.nearex_prm392;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

public class Notification extends AppCompatActivity {

    private TabLayout notiTabLayout;
    private ViewPager notiView;

    private ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        notiTabLayout = findViewById(R.id.tab_layout);
        notiView = findViewById(R.id.view_pager);

        NotificationAdapter notificationAdapter = new NotificationAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        notiView.setAdapter(notificationAdapter);

        notiTabLayout.setupWithViewPager(notiView);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}