import java.util.Random;

public class Car extends  Thread{
    private int MAX_FUEL_CAPACITY=50;
    private int fuel;
    public static float speed;
    public static int acceleration;
    public static float distance;

    public static float turation;
    private float gear_ratio;


    private static int kilometers_traveled;
    private float time=0;
    public static Success board;
    public static Gears gear;

    private float second=0;

    Car(Success board){
        gear=Gears.NEUTRAL_GEAR;
this.board=board;
        this.fuel=10;
        this.kilometers_traveled=0;



    }




    public void run(){
 ///////////////////////////////////////
        Random rand = new Random();
        //int random_noise=0;
        time=0;
        this.speed=0;
        this.acceleration=0;
        turation=0;




/////////////////////////////////////////
        while(true){

                long start = System.currentTimeMillis();

            change_Gear();

            turation=(int)(gear_ratio*speed*(float)3.6);

            if(gear==Gears.REVERSE_GEAR)
            speed=speed-acceleration*time;
            else if(gear==Gears.NEUTRAL_GEAR){
                if(speed>0){
                    //speed decaying if in neutral
                    speed=speed-1*time;
                }else speed=0;
            }
                else
                speed=speed+acceleration*time;

          //  distance=distance+speed*time;



try {
    Thread.sleep(16,6666);//t= 1, 2 , 3, 4........60 fps
}catch (Exception e){
    System.out.println(e);
}

board.update();

//            System.out.println("(M/S)speed:"+speed);
//            System.out.println("(M)distance:"+distance);
         // System.out.println("(RPM)turation:"+turation);
//            System.out.println("Current gear: "+gear);
//            System.out.println();
           long end = System.currentTimeMillis();

            time = (end - start)/(float)1000;
            //System.out.println("elapsed Time="+time);
second+=time;
            if(second>=1.000){
               second=0;
                distance=distance+speed;
            }


        }




    }

    public void fill_car(int liters){


    }

    public void change_Gear(){


        switch (gear){
            case REVERSE_GEAR:
                gear_ratio= (float) 133.3 /1;
                break;
            case NEUTRAL_GEAR:
                gear_ratio=(float) 133.3 / 1;
                break;

            case FIRST_GEAR:
                gear_ratio= (float) 133.3 /1;
                break;

            case SECOND_GEAR:
                gear_ratio=(float)133.3 / 2;
                break;

            case THIRD_GEAR:
                gear_ratio=(float)133.3 / 3;
                break;



        }



    }


}
