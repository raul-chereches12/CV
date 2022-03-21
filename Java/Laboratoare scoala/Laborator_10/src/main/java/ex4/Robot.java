package ex4;

import javax.swing.*;
import java.util.Random;

public class Robot extends Thread{
    private JButton body=new JButton();
    private int x;
    private int y;
    private int targetX;
    private int targetY;
    private boolean dead=false;
    private Arena attachedArena;
    private int speed;

    private final String name;


    Robot(String name,int x,int y,Arena a,int speed){
        this.name=name;
        this.x=x;
        this.y=y;
        this.speed=speed;
this.attachedArena=a;
        //init body
        body.setBounds(x,y,10,10);
        body.setText(name);
        body.setBorderPainted(false);
        attachedArena.add(body);
        attachedArena.repaint();




    }




    public void run(){
        Random rand = new Random();
int max;
int min;

int dx;
int dy;

        targetX=rand.nextInt(500-50)+25;
        targetY=rand.nextInt(500-50)+25;


        //draw on screen

       while(!dead){

            if((targetX==this.x)&&(targetY==this.y)){
                //new random target on the map
                targetX=rand.nextInt(500-50)+25;
                targetY=rand.nextInt(500-50)+25;
            }
            dx=(targetX-this.x);
            dy=(targetY-this.y);

//            if(dx>dy){
//                max=dx;
//                min=dy;
//            }else {
//                max = dy;
//                min= dx;
//            }
//           System.out.println("dx/dy: "+dx+" "+dy);
            //normalizam coordonatele

            if(dy!=0)
            this.y+=dy/Math.abs(dy);
            if(dx!=0)
            this.x+=dx/Math.abs(dx);

           // System.out.println("new pos x/new pos y: "+(dx-min)/(max-min)+" "+(dy-min)/(max-min));

//            System.out.println("coordonate pozitie: "+this.x+" "+this.y);
//            System.out.println("coordonate target: "+targetX+" "+targetY);
//            System.out.println();
//            System.out.println();

     reDraw();//redraw for next pozition
            try {
                Thread.sleep(16,66666);
            }catch (Exception e){
                System.out.println(e);
            }
        }


    }

    public void reDraw(){
        body.setBounds(x,y,10,10);
        attachedArena.repaint();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void destroy(){

attachedArena.remove(this.body);
attachedArena.repaint();

    }


    public String getNumele() {
        return this.name;
    }
}
