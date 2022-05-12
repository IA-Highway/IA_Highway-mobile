package com.example.ia_highway.models;

public class Image {
    String urlImage;
    String capturedDate;
    Location location;
    String width;
    String height;
    public Image(String urlImage, String capturedDate, Location location , String width , String height) {
        this.urlImage = urlImage;
        this.capturedDate = capturedDate;
        this.location = location;
        this.width = width;
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
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
