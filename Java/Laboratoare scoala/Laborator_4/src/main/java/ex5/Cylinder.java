package ex5;

import ex1.Circle;

import static java.lang.Math.PI;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
        this.height = 1.0;
    }

    public Cylinder(double radius) {
        super(radius);
        this.height = 1.0;


    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return super.getArea() * this.height;
    }

@Override
    public double getArea(){

       return 2*super.getArea()+this.height*(2*PI*super.getRadius());


}

}
