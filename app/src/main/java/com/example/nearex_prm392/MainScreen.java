package com.example.nearex_prm392;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nearex_prm392.Adapter.ProductContainerAdapter;
import com.example.nearex_prm392.Adapter.SliderMktAdapter;
import com.example.nearex_prm392.Adapter.StoreContainerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainScreen extends AppCompatActivity {

    private TextView txtHour, txtMin, txtSec,textViewLocation;

    private ImageView imgNoodles;

    private AppCompatButton btnNoti, btnStoreList;

    LinearLayout btnHome, btnActivity, btnAccount;

    private ViewPager2 viewPager2;
    private List<SliderMktItem> sliderMktItems;
    private Handler sliderHandler = new Handler();

    private RecyclerView rcvStore, rcvSale;
    private StoreContainerAdapter storeAdapter;
    private ProductContainerAdapter productAdapter;

    private int duration = 120;
    private boolean timerRunning = false;

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

        txtHour = (TextView) findViewById(R.id.hour);
        txtMin = (TextView) findViewById(R.id.min);
        txtSec = (TextView) findViewById(R.id.sec);

        if (!timerRunning) {
            timerRunning = true;
            new CountDownTimer(duration * 1000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String timer = String.format(Locale.getDefault(), "%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)-
                                            TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)-
                                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));

                            final String[] hourMinSec = timer.split(":");

                            txtHour.setText(hourMinSec[0]);
                            txtMin.setText(hourMinSec[1]);
                            txtSec.setText(hourMinSec[2]);
                        }
                    });
                }

                @Override
                public void onFinish() {
                    duration = 120;
                    timerRunning = false;
                }
            }.start();
        } else {
            Toast.makeText(MainScreen.this, "Timer is already running", Toast.LENGTH_SHORT).show();
        }

        rcvSale = (RecyclerView) findViewById(R.id.listSale);
        productAdapter = new ProductContainerAdapter(this);

        LinearLayoutManager linearLayoutProductManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvSale.setLayoutManager(linearLayoutProductManager);

        productAdapter.setData(getProductList());
        rcvSale.setAdapter(productAdapter);

        imgNoodles = (ImageView) findViewById(R.id.imageViewNoodles);
        imgNoodles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainScreen.this, Shopping.class));
            }
        });


        btnNoti = findViewById(R.id.buttonNoti);
        btnNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainScreen.this, Notification.class));
            }
        });

        btnHome = findViewById(R.id.buttonHome);
        btnActivity = findViewById(R.id.buttonActivity);
        btnAccount = findViewById(R.id.buttonAccount);
        btnStoreList = findViewById(R.id.btnStoreList);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainScreen.this, MainScreen.class));
            }
        });

        btnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainScreen.this, Notification.class));
            }
        });

        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainScreen.this, AccountActivity.class));
            }
        });

        btnStoreList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainScreen.this, NearStore.class));
            }
        });

        textViewLocation = findViewById(R.id.textViewLocation);
        textViewLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainScreen.this, YourLocation.class));
            }
        });

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

    private List<ProductContainer> getProductList() {
        List<ProductContainer> list = new ArrayList<>();
        List<ProductItem> productItemList = new ArrayList<>();

        productItemList.add(new ProductItem(R.drawable.mihaohao, "Mì gói Hảo Hảo", "330000", "233000"));
        productItemList.add(new ProductItem(R.drawable.mihaohao, "Mì gói Hảo Hảo", "330000", "233000"));
        productItemList.add(new ProductItem(R.drawable.mihaohao, "Mì gói Hảo Hảo", "330000", "233000"));
        productItemList.add(new ProductItem(R.drawable.mihaohao, "Mì gói Hảo Hảo", "330000", "233000"));
        productItemList.add(new ProductItem(R.drawable.mihaohao, "Mì gói Hảo Hảo", "330000", "233000"));
        productItemList.add(new ProductItem(R.drawable.mihaohao, "Mì gói Hảo Hảo", "330000", "233000"));



        list.add(new ProductContainer(productItemList));
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