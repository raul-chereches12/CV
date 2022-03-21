package ex4;

import java.util.ArrayList;

public class Collision extends Thread{
    public ArrayList<Robot> roboti;
    public ArrayList<Robot> robotiToBeDeleted=new ArrayList<Robot>();

    private final int RADIUS=5;
    private boolean exit=false;
Collision(ArrayList<Robot> roboti){

    this.roboti=roboti;

}
    public void run(){
while(true)
        if(roboti.size()>1)
            collision();
    }

    public void collision() {
    int flag=0;
        System.out.println("verificare collision");
        int i_index=0;
        int j_index=0;
        for (Robot i : roboti) {
            System.out.println(i.getNumele());
            for (Robot j : roboti) {
                System.out.println(j.getNumele());
                System.out.println();
                if (i != j) {

                    if (distance(i.getX(), j.getX(), i.getY(), j.getY()) <= RADIUS * 2) {


flag=1;
                        i.destroy();//se sterge de pe arena butonul
                        j.destroy();//se sterge de pe arena butonul
                        roboti.remove(i);
                        roboti.remove(j);
                        System.out.println("S-a ciocnit: "+i.getNumele()+" cu "+j.getNumele());

                    }

                }

                if(flag==1)
                    break;
            }
            if(flag==1)
                break;
        }


    }
    public float distance(int x1,int x2,int y1,int y2){

        return (float)Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2));
    }
}
