package com.example.ia_highway.models;

import java.util.List;

public class ListHelper {

    private static List<Point> listPoints;
    private static final ListHelper instance = new ListHelper();

    public ListHelper() {
    }

    public static List<Point> getListPoints() {
        return listPoints;
    }

    public static void setListPoints(List<Point> listPoints) {
        ListHelper.listPoints = listPoints;
    }


    public static ListHelper getInstance() {
        return instance;
    }

}
