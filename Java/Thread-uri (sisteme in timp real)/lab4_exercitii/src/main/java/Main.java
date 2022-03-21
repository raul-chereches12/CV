public class Main {

        public static void main(String[] args) throws InterruptedException {

            /*
            // EXERCITIUL 1

            Integer monitor_f1_f2 = new Integer(1);
            Integer monitor_f2_f3 = new Integer(2);

            //firul 1
            new ExecutionThread(monitor_f1_f2,null, 0, 0, 3, 6,4000).start();


            //firul 2
            new ExecutionThread(monitor_f1_f2,monitor_f2_f3, 0, 0, 4, 7,3000).start();


            //firule 3
            new ExecutionThread(monitor_f2_f3,null, 0, 0, 3, 6,5000).start();



        */

            /*
            //EXERCITIUL 2



            Integer monitor1 = new Integer(1);
            Integer monitor2= new Integer(2);



            new ExecutionThread_2(monitor1,monitor2,2, 4, 4, 6,4000).start();

            new ExecutionThread_2(monitor2,monitor1, 3, 5, 5, 7,5000).start();

*/

            /*
            //EXERCITIUL 3



            Integer monitor1 = new Integer(1);



            //fir 1
            new ExecutionThread_3(monitor1,3, 6, 5000).start();


            //fir 2
            new ExecutionThread_3(monitor1,4, 7, 3000).start();


            //fir 3
            new ExecutionThread_3(monitor1, 5, 7, 6000).start();


*/

            //EXERCITIUL 4







            Res monitor1 = new Res();
            Res monitor2= new Res();

            //fir 1
            Thread f1=new ExecutionThread_4_f1(monitor1,monitor2,3, 6, 5000);
            f1.start();

            //fir 2
            Thread f2=new ExecutionThread_4_f2_f3(monitor1,3, 5);
                    f2.start();
            //fir 3
            Thread f3=new ExecutionThread_4_f2_f3(monitor2,4, 6);
            f3.start();

              f1.join();
              f2.join();
              f3.join();



        }




    }

