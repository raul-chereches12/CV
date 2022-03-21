package ex3;

public class Counter extends Thread {

    private int rangeA,rangeB;

    Counter(String name,int a,int b){

        super(name);
        this.rangeA=a;
        this.rangeB=b;
    }

    public void run(){
        for(int i=rangeA;i<=rangeB;i++){
            System.out.println(getName() + " i = "+i);
            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + " job finalised.");
    }

    public static void main(String[] args) {
        Counter c1 = new Counter("counter1",0,100);
        Counter c2 = new Counter("counter2",100,200);
      //  Counter c3 = new Counter("counter3");

        c1.run();
        c2.run();
       // c3.run();
    }
}
