package com.example.ia_highway.models;

public class Image {
    String urlImage;
    String capturedDate;
    Location location;

    public Image(String urlImage, String capturedDate, Location location) {
        this.urlImage = urlImage;
        this.capturedDate = capturedDate;
        this.location = location;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getCapturedDate() {
        return capturedDate;
    }

    public void setCapturedDate(String capturedDate) {
        this.capturedDate = capturedDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Image() {
    }
}
