package ex1;

import static java.lang.Math.PI;

public class Circle {

    private double radius;
    private String color;

public Circle(){
    this.radius=1.0;
    this.color="red";
}
    public Circle(double radius){
        this.radius=radius;

    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return PI*this.radius*this.radius;
    }


}
