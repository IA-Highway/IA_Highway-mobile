package com.example.ia_highway.models;

import java.util.List;

public class Shape {
    private List<Coords> coords;

    public Shape() {
    }

    public Shape(List<Coords> coords) {
        this.coords = coords;
    }

    public List<Coords> getCoords() {
        return coords;
    }

    public void setCoords(List<Coords> coords) {
        this.coords = coords;
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "pointList=" + coords.toString() +
                '}';
    }
}
