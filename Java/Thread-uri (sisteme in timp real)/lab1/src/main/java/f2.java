public class f2 extends Thread{

    f2 obj=new f2();
    Thread thread = new Thread(obj);

    public void run() {
        int suma=0;

        for(int i=0;i<=50;i+=3){
       suma+=i;
        }

        System.out.println(suma);
    }
}
