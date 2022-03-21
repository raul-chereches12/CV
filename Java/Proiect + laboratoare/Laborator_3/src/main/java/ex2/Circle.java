package ex2;

public class Circle{

    private
    double radius=1.0;
    private
    String color="red";

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI*radius*radius;
    }
    public Circle(double raza){
        radius=raza;
    }

    public Circle(String culoarea){
        color=culoarea;
    }

    public Circle(double raza,String culoarea){
        radius=raza;
        color=culoarea;
    }

}