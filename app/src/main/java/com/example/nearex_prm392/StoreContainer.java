package com.example.nearex_prm392;

import java.util.List;

public class StoreContainer {

    private List<StoreItem> storeItems;

    public StoreContainer(List<StoreItem> storeItems) {
        this.storeItems = storeItems;
    }

    public List<StoreItem> getStoreItems() {
        return storeItems;
    }

    public void setStoreItems(List<StoreItem> storeItems) {
        this.storeItems = storeItems;
    }
}
