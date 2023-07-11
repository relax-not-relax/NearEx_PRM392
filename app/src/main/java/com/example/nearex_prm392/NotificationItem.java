package com.example.nearex_prm392;

public class NotificationItem {

    private int image;
    private String name;
    private String oldPrice;
    private String newPrice;
    private String expDate;
    private String storeName;
    private String location;
    private String amount;
    private String total;

    public NotificationItem(int image, String name, String oldPrice, String newPrice, String expDate, String storeName, String location, String amount, String total) {
        this.image = image;
        this.name = name;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.expDate = expDate;
        this.storeName = storeName;
        this.location = location;
        this.amount = amount;
        this.total = total;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
