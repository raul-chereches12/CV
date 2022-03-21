public class f1 extends Thread{

    f1 obj=new f1();
    Thread thread = new Thread(obj);

    public void run() {
        int suma=0;

        for(int i=0;i<=50;i+=2){
            suma+=i;
        }

        System.out.println(suma);
    }
}
