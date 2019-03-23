package com.gmail.bishoybasily.issr;

import org.junit.Assert;
import org.junit.Test;

public class Circle2DTest {

    @Test
    public void getArea() {
        Circle2D circle2D;

        circle2D = new Circle2D(1, 0, 0);
        Assert.assertEquals(3.14159, circle2D.getArea(), 0.1);

        circle2D = new Circle2D(13, 0, 0);
        Assert.assertEquals(530.929, circle2D.getArea(), 0.1);

    }

    @Test
    public void getPerimeter() {
        Circle2D circle2D;

        circle2D = new Circle2D(1, 0, 0);
        Assert.assertEquals(6.28319, circle2D.getPerimeter(), 0.1);

        circle2D = new Circle2D(13, 0, 0);
        Assert.assertEquals(81.6814, circle2D.getPerimeter(), 0.1);

    }

    @Test
    public void contains() {

        Circle2D circle2D;

        circle2D = new Circle2D(1, 0, 0);
        Assert.assertFalse(circle2D.contains(1, 1));
        Assert.assertTrue(circle2D.contains(.5, .5));


    }
}
