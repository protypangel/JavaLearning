package org.example.Java.Java17;

import java.util.List;

// Un record permet de definir tout les elements comme final
// C'est donc une class Immutable
public class Java17Record {
    public static record Point(double x, double y) {}
    public static record Rectangle(Point a, Point b) {}

    public static void main(String[] args) {
        List<Point> points = List.of(
            new Point(0, 0),
            new Point(10,10)
        );
        Rectangle r = new Rectangle(new Point(0,0), new Point(1, 1));
        if (points.get(0) instanceof Point(double x, double y)) {}
        if (r instanceof Rectangle(Point(double x1, double y1), Point(double x2, double y2))) {}
        //for(Point(double x, double y): points) {}
    }
}
