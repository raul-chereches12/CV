package ex1;

public abstract class Shape {

    protected String color;
    protected boolean filled;

    public Shape(){
        this.color="red";
        this.filled=true;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public boolean isFilled(){

        return filled;

    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }

     abstract double getArea();
    abstract double getPerimeter();
}
