public class ExecutionThread_4_f2_f3 extends Thread{

    Res monitor;


    int activity_min_state1, activity_max_state1,activity_min_state2, activity_max_state2;
    int sleep;

    public ExecutionThread_4_f2_f3(Res monitor, int activity_min_state1, int activity_max_state1) {

        this.monitor = monitor;


        //activitate 1
        this.activity_min_state1 = activity_min_state1;
        this.activity_max_state1 = activity_max_state1;

    }

    public void run(){

            //start
            System.out.println(this.getName() + " - START     " + System.currentTimeMillis());
        try {
            System.out.println("Waiting.....");
            monitor.ast();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //state1


                System.out.println(this.getName() + " - STATE 1   " + System.currentTimeMillis());

                int k = (int) Math.round(Math.random() * (activity_max_state1 - activity_min_state1) + activity_min_state1);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }





            System.out.println(this.getName() + " - STATE 2   " + System.currentTimeMillis());




    }



        }








