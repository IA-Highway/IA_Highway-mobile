package com.example.ia_highway.models;

public class Coords {
    public float x, y;

    public Coords(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Coords() {
    }

    @Override
    public String toString() {
        return x + ", " + y;
    }
}
