package com.example.nearex_prm392;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductContainerAdapter extends RecyclerView.Adapter<ProductContainerAdapter.ViewHolder> {

    private Context context;
    private List<ProductContainer> productContainers;

    public ProductContainerAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<ProductContainer> list) {
        this.productContainers = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_container, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductContainer productContainer = productContainers.get(position);
        if (productContainer == null) {
            return;
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        holder.rcvProduct.setLayoutManager(linearLayoutManager);

        ProductAdapter productAdapter = new ProductAdapter();
        productAdapter.setData(productContainer.getProductItems());
        holder.rcvProduct.setAdapter(productAdapter);
    }

    @Override
    public int getItemCount() {
        if (productContainers != null) {
            return productContainers.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView rcvProduct;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rcvProduct = itemView.findViewById(R.id.rcvContainer);
        }
    }
}
