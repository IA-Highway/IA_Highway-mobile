package com.example.ia_highway.models;

public class Point {
    public float dy;
    public float dx;
    public float x, y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
    }

    @Override
    public String toString() {
        return x + ", " + y;
    }
}
