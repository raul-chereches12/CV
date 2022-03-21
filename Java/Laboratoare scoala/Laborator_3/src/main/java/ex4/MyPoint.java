package ex4;


import static java.lang.Math.sqrt;

public class MyPoint {

private
    int x,y;


    public MyPoint(){
        this.x=this.y=0;
    }

    public MyPoint(int pozx,int pozy){
        this.x=pozx;
        this.y=pozy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" +
                x +
                "," + y +
        ")";
    }

    public double distance(MyPoint prim,MyPoint doi){

        return sqrt(prim.x-doi.x+prim.y-doi.y);

    }
}
