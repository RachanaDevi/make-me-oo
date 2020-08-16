So Shivam had just learned about OOP. He had written a program before that did two things,
- Find distance between two points
- Find direction (angle) between two points in Radians.

He has this code in the `org.procedural.DistanceAndDirectionCalculator` It looks like this for the reference - 

```java
public class DistanceAndDirectionCalculator {
    public static double distance(double x1, double y1, double x2, double y2) {
        double xDistance = x1 - x2;
        double yDistance = y1 - y2;
        return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
    }

    public static double direction(double x1, double y1, double x2, double y2) {
        double xDistance = x2 - x1;
        double yDistance = y2 - y1;
        return Math.atan2(yDistance, xDistance);
    }
}
```
He thought it'll be a good idea to convert this to Object Oriented Programming. So he wrote a new implementation in package `org.oop`, he got 2 classes - 
- `org.oop.DistanceAndDirectionCalculator`
- `org.oop.Point`

However, his trainer told him that what he did is not Object Oriented programming and asked Shivam to try again. 
- Try to articulate problems with Shivam's OOP solution. (Write it somewhere and share it with your trainer)
- Fork the project and fix the design related problem with Shivam's OOP solution. Share that with your trainer too.

#### Articulation
- Shivam has created DistanceAndDirectionCalculator class which interacts with the calculation of a Point's direction and distance from another point. Hence Encapsulation is missing, as Point related info is not bundled together.
- Point class just has been used for initializing, getting and setting the Point's coordinates. There is no real behaviour mentioned in it.
- Even though x and y are private. They can be seen using getters, which doesn't implement Data-Hiding.

#### How I solved it
- I added distanceFrom and directionFrom Point methods in Point class because it justifies information related to Point.
- Removed DistanceAndDirectionCalculator class so as to encapsulate calculation related to Point in Point class itself.
- Removed getters and setters.

#### Where the 4 pillars are present
- Abstraction is present as the user doesn't know how a Point's distance, direction from another point is calculated.
- Encapsulation is present as data and behaviour related to Point are closely bundled together.
- Inheritance and Polymorphism are not present.

#### Doubts
- There is repetition of code in directionFrom and distanceFrom, i.e calculating x_diff and y_diff.
```
    public double distanceFrom(Point point){
        double x_diff = point.x - this.x; //repetition
        double y_diff = point.y - this.y; //repetition
        return Math.sqrt(Math.pow(x_diff,2)+Math.pow(y_diff,2));
    }

    public double directionFrom(Point point){
        double x_diff = point.x - this.x; //repetition
        double y_diff = point.y - this.y; //repetition
        return Math.atan2(y_diff,x_diff);
    }
```
- I felt if it was done the following way given below, repetition could have been avoided. But returning a Point from differenceInCoordinateValues didn't make sense to me in technicality as difference of two points doesn't return a point. 
```
package org.oop;

public class Point {
    .
    .
    .
    public double distanceFrom(Point point){
        Point diff = this.differenceInCoordinateValues(point);
        return Math.sqrt(Math.pow(diff.x,2)+Math.pow(diff.y,2));
    }

    public double directionFrom(Point point){
        Point diff = this.differenceInCoordinateValues(point);
        return Math.atan2(diff.y,diff.x);
    }
    // New method
    public Point differenceInCoordinateValues(Point point){
        double x_diff = point.x - this.x;
        double y_diff = point.y - this.y;
        return new Point(x_diff,y_diff);
    }

}
```
- I wanted to try Array, but would it become more complex or cause more memory to be used? Just wanted to know how to solve this.
