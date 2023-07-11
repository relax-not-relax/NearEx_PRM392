package com.example.nearex_prm392.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.nearex_prm392.R;
import com.example.nearex_prm392.SliderMktItem;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class SliderMktAdapter extends RecyclerView.Adapter<SliderMktAdapter.SliderViewHolder> {

    private List<SliderMktItem> sliderMktItems;
    private ViewPager2 viewPager2;

    public SliderMktAdapter(List<SliderMktItem> sliderMktItems, ViewPager2 viewPager2) {
        this.sliderMktItems = sliderMktItems;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.slide_image_container,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.setImage(sliderMktItems.get(position));
        if (position == sliderMktItems.size() - 2) {
            viewPager2.post(runnable);
        }
    }

    @Override
    public int getItemCount() {
        return sliderMktItems.size();
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            sliderMktItems.addAll(sliderMktItems);
            notifyDataSetChanged();
        }
    };

    class SliderViewHolder extends RecyclerView.ViewHolder {

        private RoundedImageView imageView;

        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageMktSlide);
        }

        void setImage(SliderMktItem sliderMktItem) {
            imageView.setImageResource(sliderMktItem.getImage());
        }

    }
}
