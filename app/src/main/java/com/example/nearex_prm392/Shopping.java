package com.example.nearex_prm392;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class Shopping extends AppCompatActivity implements ShopAdapter.OnItemClickListener {

    ArrayList<ShopItem> shopItems;

    RecyclerView rcvShop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        rcvShop = (RecyclerView) findViewById(R.id.rcvCateItem);
        getData();


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