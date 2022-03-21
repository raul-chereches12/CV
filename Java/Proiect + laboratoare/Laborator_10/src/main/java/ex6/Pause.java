package ex6;

public class Pause extends Thread{







    synchronized void pauseChronometer(){
        try {
           // while (!Chronometer.on) wait();

        }catch (Exception e)
        {
            System.out.println(e);
        }

    }

}
