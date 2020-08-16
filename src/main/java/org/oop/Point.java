package org.oop;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceFrom(Point point){
        Point diff = this.delta(point);
        return Math.sqrt(Math.pow(diff.x,2)+Math.pow(diff.y,2));
    }

    public double directionFrom(Point point){
        Point diff = this.delta(point);
        return Math.atan2(diff.y,diff.x);
    }

    private Point delta(Point point){
        double xDiff = point.x - this.x;
        double yDiff = point.y - this.y;
        return new Point(xDiff,yDiff);
    }

}
