package com.gmail.bishoybasily.issr;

public class Square extends GeometricObject implements Colorable {

    private Double height;
    private Double width;

    public Square(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public Square(String color, boolean filled, Double height, Double width) {
        super(color, filled);
        this.height = height;
        this.width = width;
    }

    public void howToColor() {
        System.out.println("Color all four sides");
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return (width + height) * 2;
    }

}
