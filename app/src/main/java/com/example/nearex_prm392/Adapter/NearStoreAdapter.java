package com.example.nearex_prm392.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nearex_prm392.NearStoreItem;
import com.example.nearex_prm392.R;

import java.util.ArrayList;

public class NearStoreAdapter extends RecyclerView.Adapter<NearStoreAdapter.ViewHolder> {

    private ArrayList<NearStoreItem> nearStoreItems;

    public NearStoreAdapter(ArrayList<NearStoreItem> nearStoreItems) {
        this.nearStoreItems = nearStoreItems;
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

        View view = layoutInflater.inflate(R.layout.list_store_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        NearStoreItem nearStoreItem = nearStoreItems.get(position);

        holder.imgStore.setImageResource(nearStoreItem.getImage());
        holder.txtName.setText(nearStoreItem.getName());
        holder.txtDistance.setText(nearStoreItem.getDistance());
        holder.txtLocation.setText(nearStoreItem.getLocation());

    }

    @Override
    public int getItemCount() {
        return nearStoreItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgStore;
        TextView txtName, txtDistance, txtLocation;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgStore = itemView.findViewById(R.id.imageStore);
            txtName = itemView.findViewById(R.id.txtName);
            txtDistance = itemView.findViewById(R.id.txtDistance);
            txtLocation = itemView.findViewById(R.id.txtLocation);


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
