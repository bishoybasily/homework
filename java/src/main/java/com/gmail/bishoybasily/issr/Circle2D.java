package com.gmail.bishoybasily.issr;

public class Circle2D {

    private double radius;
    private double xc;
    private double yc;

    public Circle2D() {
        this(1, 0, 0);
    }

    public Circle2D(double radius, double xc, double yc) {
        this.radius = radius;
        this.xc = xc;
        this.yc = yc;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public boolean contains(double x, double y) {
        return Math.sqrt(Math.pow(x - xc, 2) + Math.pow(y - yc, 2)) <= radius;
    }

}
