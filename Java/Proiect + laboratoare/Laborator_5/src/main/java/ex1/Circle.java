package ex1;

import static java.lang.Math.PI;

public class Circle extends Shape {

    protected double radius;

    public Circle() {
        this.radius = 1.0;

    }

    public Circle(double radius) {
        this.radius = radius;

    }

    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        this.setColor(color);
        this.setFilled(filled);

    }

    public double getRadius() {
        return radius;
    }


    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + this.getColor() + '\'' +
                ", filled=" + this.isFilled() +
                '}';
    }

    @Override
    public double getPerimeter() {
        return 2 * PI * this.radius;
    }

    public double getArea() {
        return PI * this.radius * this.radius;
    }


}
