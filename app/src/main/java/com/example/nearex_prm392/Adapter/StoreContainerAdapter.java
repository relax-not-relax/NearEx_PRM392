package com.example.nearex_prm392.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nearex_prm392.R;
import com.example.nearex_prm392.StoreContainer;
import com.example.nearex_prm392.StoreDetail;

import java.util.List;

public class StoreContainerAdapter extends RecyclerView.Adapter<StoreContainerAdapter.ViewHolder> {

    private Context context;
    private List<StoreContainer> storeContainers;

    public StoreContainerAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<StoreContainer> list) {
        this.storeContainers = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_container, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StoreContainer storeContainer = storeContainers.get(position);
        if (storeContainer == null) {
            return;
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        holder.rcvStore.setLayoutManager(linearLayoutManager);

        StoreAdapter storeAdapter = new StoreAdapter();
        storeAdapter.setData(storeContainer.getStoreItems());

        storeAdapter.setOnButtonClickListener(new StoreAdapter.OnButtonClickListener() {
            @Override
            public void onButtonClick(int position) {
                Intent intent = new Intent(context, StoreDetail.class);
                context.startActivity(intent);
            }
        });

        holder.rcvStore.setAdapter(storeAdapter);
    }

    @Override
    public int getItemCount() {
        if (storeContainers != null) {
            return storeContainers.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView rcvStore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rcvStore = itemView.findViewById(R.id.rcvContainer);
        }
    }

}
