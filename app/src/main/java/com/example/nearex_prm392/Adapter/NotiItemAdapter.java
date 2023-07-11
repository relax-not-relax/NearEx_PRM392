package com.example.nearex_prm392.Adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nearex_prm392.NotificationItem;
import com.example.nearex_prm392.R;

import java.util.ArrayList;

public class NotiItemAdapter extends RecyclerView.Adapter<NotiItemAdapter.ViewHolder> {

    ArrayList<NotificationItem> notificationItems;

    public NotiItemAdapter(ArrayList<NotificationItem> notificationItems) {
        this.notificationItems = notificationItems;
    }

    public interface OnButtonClickListener {
        void onButtonClick(int position);
    }


    private OnButtonClickListener listener;

    public void setOnButtonClickListener(OnButtonClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.noti_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        NotificationItem notificationItem = notificationItems.get(position);

        holder.imgItem.setImageResource(notificationItem.getImage());
        holder.txtItem.setText(notificationItem.getName());
        holder.txtOldPrice.setText(notificationItem.getOldPrice());
        holder.txtNewPrice.setText(notificationItem.getNewPrice());
        holder.txtExp.setText(notificationItem.getExpDate());
        holder.txtStore.setText(notificationItem.getStoreName());
        holder.txtLocation.setText(notificationItem.getLocation());
        holder.txtAmount.setText(notificationItem.getAmount());
        holder.txtTotal.setText(notificationItem.getTotal());

    }

    @Override
    public int getItemCount() {
        return notificationItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgItem;
        TextView txtItem, txtOldPrice, txtNewPrice, txtStore, txtExp, txtLocation, txtAmount, txtTotal;

        AppCompatButton btnBuy;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.imageItem);
            txtItem = itemView.findViewById(R.id.txtItem);
            txtOldPrice = itemView.findViewById(R.id.oldPrice);
            txtOldPrice.setPaintFlags(txtOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            txtNewPrice = itemView.findViewById(R.id.newPrice);
            txtExp = itemView.findViewById(R.id.expDate);
            txtStore = itemView.findViewById(R.id.txtStoreItem);
            txtLocation = itemView.findViewById(R.id.txtLocation);
            txtAmount = itemView.findViewById(R.id.txtAmount);
            txtTotal = itemView.findViewById(R.id.txtTotal);
            btnBuy = itemView.findViewById(R.id.btnBuy);

            btnBuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onButtonClick(position);
                    }
                }
            });
        }
    }

}
