import java.security.spec.ECField;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Fir f1=new Fir(2);
        Fir f2=new Fir(3);
        Fir f3=new Fir(4);


            Thread t1 = new Thread(f1);
            Thread t2 = new Thread(f2);
            Thread t3 = new Thread(f3);



        System.out.println();
        System.out.println();

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();

        System.out.println(f1.suma+f2.suma+f3.suma);

    }

}
