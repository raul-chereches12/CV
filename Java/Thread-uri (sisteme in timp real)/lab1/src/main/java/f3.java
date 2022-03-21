public class f3 extends Thread{

    f3 obj=new f3();
    Thread thread = new Thread(obj);

    public void run() {
        int suma=0;

        for(int i=0;i<=50;i+=4){
            suma+=i;
        }

        System.out.println(suma);
    }
}
