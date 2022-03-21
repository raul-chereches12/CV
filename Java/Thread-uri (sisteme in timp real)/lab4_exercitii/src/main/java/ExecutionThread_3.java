public class ExecutionThread_3 extends Thread{

    Integer monitor1;


    int activity_min_state1, activity_max_state1,activity_min_state2, activity_max_state2;
    int sleep;

    public ExecutionThread_3(Integer monitor1, int activity_min_state1, int activity_max_state1, int sleep) {

        this.monitor1 = monitor1;


        //activitate 1
        this.activity_min_state1 = activity_min_state1;
        this.activity_max_state1 = activity_max_state1;




        this.sleep=sleep;

    }

    public void run(){

        while(true) {

            //start
            System.out.println(this.getName() + " - START     " + System.currentTimeMillis());

            //state1
            synchronized (monitor1) {

                System.out.println(this.getName() + " - STATE 1   " + System.currentTimeMillis());

                int k = (int) Math.round(Math.random() * (activity_max_state1 - activity_min_state1) + activity_min_state1);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }


                }


            System.out.println(this.getName() + " - STATE 2   " + System.currentTimeMillis());

            try {
                sleep(this.sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(this.getName() + " - STATE 3   " + System.currentTimeMillis());

        }





        }

        }








