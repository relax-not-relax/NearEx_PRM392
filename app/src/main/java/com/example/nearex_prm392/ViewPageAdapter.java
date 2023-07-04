package com.example.nearex_prm392;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewPageAdapter extends RecyclerView.Adapter<ViewPageAdapter.ViewHolder> {

    ArrayList<ViewPageItem> viewPagerItems;

    public ViewPageAdapter(ArrayList<ViewPageItem> viewPagerItems) {
        this.viewPagerItems = viewPagerItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.slider_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewPageItem viewPagerItem = viewPagerItems.get(position);

        holder.imageView.setImageResource(viewPagerItem.imageId);
        holder.txtHeading.setText(viewPagerItem.heading);
        holder.txtDes.setText(viewPagerItem.description);
    }

    @Override
    public int getItemCount() {
        return viewPagerItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView txtHeading, txtDes;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageSlide);
            txtHeading = itemView.findViewById(R.id.textViewHeading);
            txtDes = itemView.findViewById(R.id.textViewDes);
        }
    }

}
