package com.example.nearex_prm392;

import java.util.List;

public class ProductContainer {

    private List<ProductItem> productItems;

    public ProductContainer(List<ProductItem> productItems) {
        this.productItems = productItems;
    }

    public List<ProductItem> getProductItems() {
        return productItems;
    }

    public void setProductItems(List<ProductItem> productItems) {
        this.productItems = productItems;
    }
}
