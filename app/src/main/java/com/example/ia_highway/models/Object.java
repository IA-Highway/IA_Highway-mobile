package com.example.ia_highway.models;

import java.util.List;

public class Object {
    private String description;
    private List<Polygon> polygons;
    Float ymin;
    Float xmin;
    Float ymax;
    Float xmax;

    public Object(){}
    public Object(String description, List<Polygon> polygons, Float ymin, Float xmin, Float ymax, Float xmax) {
        this.description = description;
        this.polygons = polygons;
        this.ymin = ymin;
        this.xmin = xmin;
        this.ymax = ymax;
        this.xmax = xmax;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Polygon> getPolygons() {
        return polygons;
    }

    public void setPolygons(List<Polygon> polygons) {
        this.polygons = polygons;
    }

    public Float getYmin() {
        return ymin;
    }

    public void setYmin(Float ymin) {
        this.ymin = ymin;
    }

    public Float getXmin() {
        return xmin;
    }

    public void setXmin(Float xmin) {
        this.xmin = xmin;
    }

    public Float getYmax() {
        return ymax;
    }

    public void setYmax(Float ymax) {
        this.ymax = ymax;
    }

    public Float getXmax() {
        return xmax;
    }

    public void setXmax(Float xmax) {
        this.xmax = xmax;
    }

    @Override
    public String toString() {
        return "Object{" +
                "description='" + description + '\'' +
                ", polygons=" + polygons +
                ", ymin=" + ymin +
                ", xmin=" + xmin +
                ", ymax=" + ymax +
                ", xmax=" + xmax +
                '}';
    }
}
