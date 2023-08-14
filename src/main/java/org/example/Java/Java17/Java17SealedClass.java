package org.example.Java.Java17;

public class Java17SealedClass {
    public static sealed class Shape permits Circle, Rectangle {
        private Point center;
    }
    public non-sealed static class Circle extends Shape {}
    public static class CircleColored extends Circle {}

    public static sealed class Rectangle extends Shape {}
    public static final class RectangleColored extends Rectangle {}
    public static class Point {
        int x, y;
    }

}
