package com.example.nearex_prm392;

public class ProductItem {

    private int resourceId;
    private String title;
    private String oldPrice;
    private String newPrice;

    public ProductItem(int resourceId, String title, String oldPrice, String newPrice) {
        this.resourceId = resourceId;
        this.title = title;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }
}
