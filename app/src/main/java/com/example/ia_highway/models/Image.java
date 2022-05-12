package com.example.ia_highway.models;

public class Image {
    String file_url;
    String date_captured;
    gps_location gps_location;
    double width, height;

    public Image(String file_url, String date_captured, com.example.ia_highway.models.gps_location gps_location, double width, double height) {
        this.file_url = file_url;
        this.date_captured = date_captured;
        this.gps_location = gps_location;
        this.width = width;
        this.height = height;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public String getDate_captured() {
        return date_captured;
    }

    public void setDate_captured(String date_captured) {
        this.date_captured = date_captured;
    }

    public com.example.ia_highway.models.gps_location getGps_location() {
        return gps_location;
    }

    public void setGps_location(com.example.ia_highway.models.gps_location gps_location) {
        this.gps_location = gps_location;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Image() {
    }
}
