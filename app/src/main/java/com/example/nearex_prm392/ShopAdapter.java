package com.example.nearex_prm392;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {

    private ArrayList<ShopItem> shopItems;

    public ShopAdapter(ArrayList<ShopItem> shopItems) {
        this.shopItems = shopItems;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }


    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.shop_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ShopItem shopItem = shopItems.get(position);

        holder.imgItem.setImageResource(shopItem.getImage());
        holder.txtItem.setText(shopItem.getName());
        holder.txtOldPrice.setText(shopItem.getOldPrice());
        holder.txtNewPrice.setText(shopItem.getNewPrice());
        holder.txtExp.setText(shopItem.getExpDate());
        holder.txtStore.setText(shopItem.getStoreName());
    }

    @Override
    public int getItemCount() {
        return shopItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgItem;
        TextView txtItem, txtOldPrice, txtNewPrice, txtStore, txtExp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.imageItem);
            txtItem = itemView.findViewById(R.id.txtItem);
            txtOldPrice = itemView.findViewById(R.id.oldPrice);
            txtOldPrice.setPaintFlags(txtOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            txtNewPrice = itemView.findViewById(R.id.newPrice);
            txtExp = itemView.findViewById(R.id.expDate);
            txtStore = itemView.findViewById(R.id.txtStoreItem);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            });
        }
    }

}
