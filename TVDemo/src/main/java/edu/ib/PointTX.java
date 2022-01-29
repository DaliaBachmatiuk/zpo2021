package edu.ib;

import java.util.ArrayList;

public class PointTX {
    private double time;
    double x;

    public PointTX(double time, double x) {
        this.time = time;
        this.x = x;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public static ArrayList<PointTX> getPoints(ArrayList<Double> t, ArrayList<Double> x) {
        ArrayList<PointTX> points = new ArrayList<>();
        for (int i = 0; i < t.size(); i++) points.add(new PointTX(t.get(i), x.get(i)));
        return points;
    }
}
