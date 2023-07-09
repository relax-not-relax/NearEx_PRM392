package com.example.nearex_prm392;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {

    private List<StoreItem> storeItems;

    public void setData(List<StoreItem> list) {
        this.storeItems = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StoreItem store = storeItems.get(position);
        if (store == null) {
            return;
        }

        holder.imgStore.setImageResource(store.getResourceId());
        holder.txtStore.setText(store.getTitle());
    }

    @Override
    public int getItemCount() {
        if (storeItems != null) {
            return storeItems.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgStore;
        private TextView txtStore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgStore = itemView.findViewById(R.id.imageStore);
            txtStore = itemView.findViewById(R.id.textStore);
        }
    }
}
