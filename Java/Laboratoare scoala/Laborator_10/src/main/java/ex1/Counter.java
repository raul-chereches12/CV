package ex1;

public class Counter extends Thread {

    Counter(String name) {
        super(name);
    }

    public synchronized void run() {

        for (int i = 0; i < 20; i++) {
            System.out.println(getName() + " i = " + i);
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//                try{
//                    Thread.sleep(30);
//                }catch (Exception e){
//                    System.out.println(e);
//                }
            //  try {
//                   wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }

            System.out.println(getName() + " job finalised.");
        }

    }
        public static void main (){
            Counter c1 = new Counter("counter1");
            Counter c2 = new Counter("counter2");
            Counter c3 = new Counter("counter3");

            c1.run();
            c2.run();
            c3.run();
        }

}
