package ex4;

import java.util.ArrayList;

public class GameInstance {
    public ArrayList<Robot> roboti=new ArrayList<Robot>();

    Arena a=new Arena();
Collision ciocnire=new Collision(roboti);


    public void runGame(){


             initRoboti();







            for (Robot i : roboti) {
                i.start();
            }

//            try {
//                Thread.sleep(10);
//            }catch (Exception e){
//                System.out.println(e);
//            }


            ciocnire.start();





    }


    public void initRoboti(){

        Robot raul=new Robot("R",0,0,a,1);
        roboti.add(raul);

        Robot erik=new Robot("E",0,100,a,1);
        roboti.add(erik);

        Robot dan=new Robot("D",0,200,a,1);
        roboti.add(dan);

        Robot paul=new Robot("R",0,300,a,1);
        roboti.add(paul);

        Robot florin=new Robot("E",0,400,a,1);
        roboti.add(florin);

        Robot tudor=new Robot("D",0,475,a,1);
        roboti.add(tudor);

        Robot casian=new Robot("R",0,400,a,1);
        roboti.add(casian);

        Robot rares=new Robot("E",100,400,a,1);
        roboti.add(rares);

        Robot sebi=new Robot("D",200,400,a,1);
        roboti.add(sebi);

        Robot cosmin=new Robot("D",300,400,a,1);
        roboti.add(cosmin);
    }





}
