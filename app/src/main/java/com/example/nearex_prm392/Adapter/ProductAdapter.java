package com.example.nearex_prm392.Adapter;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nearex_prm392.ProductItem;
import com.example.nearex_prm392.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<ProductItem> productItems;

    public interface OnButtonClickListener {
        void onButtonClick(int position);
    }

    private OnButtonClickListener listener;

    public void setOnButtonClickListener(OnButtonClickListener listener) {
        this.listener = listener;
    }


    public void setData(List<ProductItem> list) {
        this.productItems = list;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ProductItem product = productItems.get(position);
        if (product == null) {
            return;
        }

        holder.imgProduct.setImageResource(product.getResourceId());
        holder.txtProduct.setText(product.getTitle());
        holder.txtOldPrice.setText(product.getOldPrice());
        holder.txtNewPrice.setText(product.getNewPrice());

        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onButtonClick(position);
                }
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onButtonClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
       if (productItems != null) {
           return productItems.size();
       }
       return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgProduct;
        private TextView txtProduct;
        private TextView txtOldPrice;
        private TextView txtNewPrice;
        private AppCompatButton btnAdd;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgProduct = itemView.findViewById(R.id.imageProduct);
            txtProduct = itemView.findViewById(R.id.textProduct);
            txtOldPrice = itemView.findViewById(R.id.oldPrice);
            txtNewPrice = itemView.findViewById(R.id.newPrice);
            txtOldPrice.setPaintFlags(txtOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            btnAdd = itemView.findViewById(R.id.buttonAdd);

        }



    }

}
