package com.example.ia_highway.helpers;

import android.graphics.Bitmap;

import com.example.ia_highway.models.Point;

import java.util.List;

public class PointListHelper {

    private static List<Point> listPoints;
    private static final PointListHelper instance = new PointListHelper();

    public PointListHelper() {
    }

    public static List<Point> getListPoints() {
        return listPoints;
    }

    public static void setListPoints(List<Point> listPoints) {
        PointListHelper.listPoints = listPoints;
    }


    public static PointListHelper getInstance() {
        return instance;
    }

}
