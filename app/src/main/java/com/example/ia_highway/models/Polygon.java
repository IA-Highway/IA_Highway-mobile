package com.example.ia_highway.models;

import java.util.List;

public class Polygon {
    private List<Point> pointList;

    public Polygon(){}

    public Polygon(List<Point> pointList) {
        this.pointList = pointList;
    }

    public List<Point> getPointList() {
        return pointList;
    }

    public void setPointList(List<Point> pointList) {
        this.pointList = pointList;
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "pointList=" + pointList.toString() +
                '}';
    }
}
