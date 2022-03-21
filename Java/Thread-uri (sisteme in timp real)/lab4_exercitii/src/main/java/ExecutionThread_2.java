public class ExecutionThread_2 extends Thread{

    Integer monitor1;
    Integer monitor2;

    int activity_min_state1, activity_max_state1,activity_min_state2, activity_max_state2;
    int sleep;

    public ExecutionThread_2(Integer monitor1, Integer monitor2, int activity_min_state1, int activity_max_state1,int activity_min_state2, int activity_max_state2, int sleep) {

        this.monitor1 = monitor1;
        this.monitor2 = monitor2;

        //activitate 1
        this.activity_min_state1 = activity_min_state1;
        this.activity_max_state1 = activity_max_state1;


        //activitate 2
        this.activity_min_state2 = activity_min_state2;
        this.activity_max_state2 = activity_max_state2;


        this.sleep=sleep;

    }

    public void run(){

        //state 1
        System.out.println(this.getName() + " - STATE 1 " + System.currentTimeMillis());
        int k = (int) Math.round(Math.random() * (activity_max_state1 - activity_min_state1) + activity_min_state1);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }


        //state2

            synchronized (monitor1) {
                synchronized (monitor2){


                System.out.println(this.getName() + " - STATE 2 "+ System.currentTimeMillis());

                k = (int) Math.round(Math.random() * (activity_max_state2 - activity_min_state2) + activity_min_state2);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }






                    System.out.println(this.getName() + " - STATE 3 " + System.currentTimeMillis());
                    k = (int) Math.round(Math.random() * (activity_max_state2 - activity_min_state2) + activity_min_state2);
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





        System.out.println(this.getName() + " - STATE 4 " + System.currentTimeMillis());




        }




    }



