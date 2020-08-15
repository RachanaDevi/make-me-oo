package org.oop;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceFrom(Point point){
        double x_diff = point.x - this.x;
        double y_diff = point.y - this.y;
        return Math.sqrt(Math.pow(x_diff,2)+Math.pow(y_diff,2));
    }

    public double directionFrom(Point point){
        double x_diff = point.x - this.x;
        double y_diff = point.y - this.y;
        return Math.atan2(y_diff,x_diff);
    }

}
