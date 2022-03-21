public class Fir implements Runnable{


    int p;
    int suma=0;

    public Fir(int p){

        this.p=p;

    }

@Override
    public void run(){



    for(int i=0;i<50;i+=p){

        suma+=i;

    }

    System.out.println("p="+p+" s="+suma);
}



}


