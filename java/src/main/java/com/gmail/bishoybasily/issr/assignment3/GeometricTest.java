package com.gmail.bishoybasily.issr.assignment3;

public class GeometricTest {

    public static void main(String[] args) {

        int length = 5;
        GeometricObject[] geometricObjects = new GeometricObject[length];
        for (int i = 0; i < length; i++) {
            geometricObjects[i] = new Square("Color_" + i, i % 2 == 0, i + 2.0, i + 2.0);
        }

        for (int i = 0; i < length; i++) {
            GeometricObject g = geometricObjects[i];

            System.out.printf("------------------ Start Object %d ------------------\n", i);

            System.out.printf("Area: %.1f\n", g.getArea());
            System.out.printf("Perimeter: %.1f\n", g.getPerimeter());

            if (g instanceof Colorable)
                ((Colorable) g).howToColor();

            System.out.printf("------------------ End Object %d ------------------\n\n", i);

        }


    }

}
