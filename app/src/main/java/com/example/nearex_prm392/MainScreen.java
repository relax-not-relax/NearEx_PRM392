package com.example.nearex_prm392;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainScreen extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private List<SliderMktItem> sliderMktItems;
    private Handler sliderHandler = new Handler();

    private RecyclerView rcvStore;
    private StoreContainerAdapter storeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        viewPager2 = (ViewPager2) findViewById(R.id.viewPagerImageSlider);
        getImages();

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);


        CompositePageTransformer conCompositePageTransformer = new CompositePageTransformer();
        conCompositePageTransformer.addTransformer(new MarginPageTransformer(40));
        conCompositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        viewPager2.setPageTransformer(conCompositePageTransformer);

        rcvStore = (RecyclerView) findViewById(R.id.listStore);
        storeAdapter = new StoreContainerAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvStore.setLayoutManager(linearLayoutManager);

        storeAdapter.setData(getStoreList());
        rcvStore.setAdapter(storeAdapter);

    }

    private List<StoreContainer> getStoreList() {
        List<StoreContainer> list = new ArrayList<>();
        List<StoreItem> storeItemList = new ArrayList<>();

        storeItemList.add(new StoreItem(R.drawable.store1 , "Circle K Lê Văn Việt"));
        storeItemList.add(new StoreItem(R.drawable.store2 , "Family Mart Lê Văn Việt"));
        storeItemList.add(new StoreItem(R.drawable.store3 , "GS25 Vinhomes Grand Park"));
        storeItemList.add(new StoreItem(R.drawable.store4 , "Ministop Kha Vạn Cân"));
        storeItemList.add(new StoreItem(R.drawable.store5 , "Bách Hóa Xanh Lê Văn Việt"));

        list.add(new StoreContainer(storeItemList));

        return list;
    }


    private void getImages() {
        sliderMktItems = new ArrayList<>();
        sliderMktItems.add(new SliderMktItem(R.drawable.mkt1));
        sliderMktItems.add(new SliderMktItem(R.drawable.mkt2));
        sliderMktItems.add(new SliderMktItem(R.drawable.mkt3));
        sliderMktItems.add(new SliderMktItem(R.drawable.mkt4));
        sliderMktItems.add(new SliderMktItem(R.drawable.mkt5));

        viewPager2.setAdapter(new SliderMktAdapter(sliderMktItems, viewPager2));

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000);
            }
        });
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, 3000);
    }
}