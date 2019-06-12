package com.example.user.android_project2;

public class MarkerItem {
    String name;
    double lat;
    double lon;


    public MarkerItem(String name, double lat, double lon) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }


}
