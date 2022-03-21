public class ExecutionThread_4_f1 extends Thread{



    int activity_min_state1, activity_max_state1,activity_min_state2, activity_max_state2;
    int sleep;
    Res m1,m2;

    public ExecutionThread_4_f1(Res m1,Res m2, int activity_min_state1, int activity_max_state1, int sleep) {


this.m1=m1;
this.m2=m2;

        //activitate 1
        this.activity_min_state1 = activity_min_state1;
        this.activity_max_state1 = activity_max_state1;


        this.sleep=sleep;

    }

    public void run(){



            //start
            System.out.println(this.getName() + " - START     " + System.currentTimeMillis());

        try {
            sleep(this.sleep);
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

                m1.notifica();
                m2.notifica();



            System.out.println(this.getName() + " - STATE 2   " + System.currentTimeMillis());


        System.out.println("gata");





        }

        }








