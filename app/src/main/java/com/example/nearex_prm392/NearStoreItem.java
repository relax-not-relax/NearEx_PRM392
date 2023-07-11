package com.example.nearex_prm392;

public class NearStoreItem {

    private int image;
    private String name;
    private String distance;
    private String location;

    public NearStoreItem(int image, String name, String distance, String location) {
        this.image = image;
        this.name = name;
        this.distance = distance;
        this.location = location;
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

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
