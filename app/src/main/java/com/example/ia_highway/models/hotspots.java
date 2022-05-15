package com.example.ia_highway.models;

import java.util.List;

public class hotspots {
    private String name;
    private List<Shape> shape;
    Float ymin;
    Float xmin;
    Float ymax;
    Float xmax;

    public hotspots() {
    }

    public hotspots(String name, List<Shape> shape, Float ymin, Float xmin, Float ymax, Float xmax) {
        this.name = name;
        this.shape = shape;
        this.ymin = ymin;
        this.xmin = xmin;
        this.ymax = ymax;
        this.xmax = xmax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Shape> getShape() {
        return shape;
    }

    public void setShape(List<Shape> shape) {
        this.shape = shape;
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
                "description='" + name + '\'' +
                ", polygons=" + shape +
                ", ymin=" + ymin +
                ", xmin=" + xmin +
                ", ymax=" + ymax +
                ", xmax=" + xmax +
                '}';
    }
}
