package com.example.nearex_prm392;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.example.nearex_prm392.Adapter.NearStoreAdapter;

import java.util.ArrayList;

public class NearStore extends AppCompatActivity implements NearStoreAdapter.OnItemClickListener {

    ArrayList<NearStoreItem> nearStoreItems;
    RecyclerView rcvStore;
    ImageView btnBack, btnFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_store);

        rcvStore = findViewById(R.id.rcvStore);
        getData();

        btnFilter = (ImageView) findViewById(R.id.btnFilter);
        btnBack = (ImageView) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

    }

    private void showDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom_sheet_layout);

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    private void getData() {
        nearStoreItems = new ArrayList<>();

        nearStoreItems.add(new NearStoreItem(R.drawable.store1, "Circle K Lê Văn Việt", "1.5km", "143 Lê Văn Việt, Phường 3, Tp.Thủ Đức"));
        nearStoreItems.add(new NearStoreItem(R.drawable.store2 , "Family Mart Lê Văn Việt", "1.5km", "143 Lê Văn Việt, Phường 3, Tp.Thủ Đức"));
        nearStoreItems.add(new NearStoreItem(R.drawable.store3 , "GS25 Vinhomes Grand Park", "1.5km", "143 Lê Văn Việt, Phường 3, Tp.Thủ Đức"));
        nearStoreItems.add(new NearStoreItem(R.drawable.store4 , "Ministop Kha Vạn Cân", "1.5km", "143 Lê Văn Việt, Phường 3, Tp.Thủ Đức"));
        nearStoreItems.add(new NearStoreItem(R.drawable.store5 , "Bách Hóa Xanh Lê Văn Việt", "1.5km", "143 Lê Văn Việt, Phường 3, Tp.Thủ Đức"));
        nearStoreItems.add(new NearStoreItem(R.drawable.store1, "Circle K Lê Văn Việt", "1.5km", "143 Lê Văn Việt, Phường 3, Tp.Thủ Đức"));
        nearStoreItems.add(new NearStoreItem(R.drawable.store2 , "Family Mart Lê Văn Việt", "1.5km", "143 Lê Văn Việt, Phường 3, Tp.Thủ Đức"));
        nearStoreItems.add(new NearStoreItem(R.drawable.store3 , "GS25 Vinhomes Grand Park", "1.5km", "143 Lê Văn Việt, Phường 3, Tp.Thủ Đức"));
        nearStoreItems.add(new NearStoreItem(R.drawable.store4 , "Ministop Kha Vạn Cân", "1.5km", "143 Lê Văn Việt, Phường 3, Tp.Thủ Đức"));
        nearStoreItems.add(new NearStoreItem(R.drawable.store5 , "Bách Hóa Xanh Lê Văn Việt", "1.5km", "143 Lê Văn Việt, Phường 3, Tp.Thủ Đức"));

        NearStoreAdapter adapter = new NearStoreAdapter(nearStoreItems);
        adapter.setOnItemClickListener((NearStoreAdapter.OnItemClickListener) this);
        rcvStore.setAdapter(adapter);
        rcvStore.setLayoutManager(new LinearLayoutManager(this));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {
        startActivity(new Intent(NearStore.this, StoreDetail.class));
    }
}