import java.time.LocalTime;

public class ExecutionThread_1 extends Thread{

    Integer monitor1;
    Integer monitor2;

    int sleep_min, sleep_max, activity_min, activity_max;
    int sleep;

    public ExecutionThread_1(Integer monitor1, Integer monitor2, int sleep_min, int sleep_max, int activity_min, int activity_max, int sleep) {

        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
        this.sleep_min = sleep_min;
        this.sleep_max = sleep_max;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.sleep=sleep;

    }

    public void run(){

        //state 1
        System.out.println(this.getName() + " - STATE 1 "+ System.currentTimeMillis());
        //state2
        try {
            Thread.sleep(Math.round(Math.random() * (sleep_max - sleep_min)+ sleep_min) * 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + " - STATE 2 "+ System.currentTimeMillis());


        //state 3
        if(monitor2==null) {
            synchronized (monitor1) {
                System.out.println(this.getName() + " - STATE 3 " + System.currentTimeMillis());
                int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }
                try {
                    sleep(this.sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
        else
        {

            synchronized (monitor1) {

                synchronized (monitor2) {

                    System.out.println(this.getName() + " - STATE 3 " + System.currentTimeMillis());
                    int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                    for (int i = 0; i < k * 100000; i++) {
                        i++;
                        i--;
                    }

                }

                try {
                    sleep(this.sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }




        }

        System.out.println(this.getName() + " - STATE 4");


    }


}
