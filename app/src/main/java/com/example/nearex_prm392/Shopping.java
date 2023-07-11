package com.example.nearex_prm392;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.nearex_prm392.Adapter.ShopAdapter;

import java.util.ArrayList;

public class Shopping extends AppCompatActivity implements ShopAdapter.OnItemClickListener {

    ArrayList<ShopItem> shopItems;

    RecyclerView rcvShop;

    ImageView btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        rcvShop = (RecyclerView) findViewById(R.id.rcvNotiItem);
        getData();

        btnBack = (ImageView) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Shopping.this, MainScreen.class));
            }
        });

    }

    private void getData() {
        shopItems = new ArrayList<>();

        shopItems.add(new ShopItem(R.drawable.mihaohao, "Mì tôm chua cay Hảo Hảo", "330000", "230000", "10/8/2023", "CircleK"));
        shopItems.add(new ShopItem(R.drawable.mihaohao, "Mì tôm chua cay Hảo Hảo", "330000", "230000", "10/8/2023", "CircleK"));
        shopItems.add(new ShopItem(R.drawable.mihaohao, "Mì tôm chua cay Hảo Hảo", "330000", "230000", "10/8/2023", "CircleK"));
        shopItems.add(new ShopItem(R.drawable.mihaohao, "Mì tôm chua cay Hảo Hảo", "330000", "230000", "10/8/2023", "CircleK"));
        shopItems.add(new ShopItem(R.drawable.mihaohao, "Mì tôm chua cay Hảo Hảo", "330000", "230000", "10/8/2023", "CircleK"));
        shopItems.add(new ShopItem(R.drawable.mihaohao, "Mì tôm chua cay Hảo Hảo", "330000", "230000", "10/8/2023", "CircleK"));
        shopItems.add(new ShopItem(R.drawable.mihaohao, "Mì tôm chua cay Hảo Hảo", "330000", "230000", "10/8/2023", "CircleK"));
        shopItems.add(new ShopItem(R.drawable.mihaohao, "Mì tôm chua cay Hảo Hảo", "330000", "230000", "10/8/2023", "CircleK"));
        shopItems.add(new ShopItem(R.drawable.mihaohao, "Mì tôm chua cay Hảo Hảo", "330000", "230000", "10/8/2023", "CircleK"));
        shopItems.add(new ShopItem(R.drawable.mihaohao, "Mì tôm chua cay Hảo Hảo", "330000", "230000", "10/8/2023", "CircleK"));

        ShopAdapter adapter = new ShopAdapter(shopItems);
        adapter.setOnItemClickListener((ShopAdapter.OnItemClickListener) this);
        rcvShop.setAdapter(adapter);
        rcvShop.setLayoutManager(new LinearLayoutManager(this));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {
        startActivity(new Intent(Shopping.this, ProductDetail.class));
    }
}