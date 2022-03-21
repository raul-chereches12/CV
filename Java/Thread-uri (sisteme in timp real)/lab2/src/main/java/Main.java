
class Resursa {

    int ms;

    int r;


    synchronized void set(int a){



        r=a;
        notify();

        try {
            wait(5);
        }
        catch (Exception e){
            System.out.println(e);
        }




    }

    synchronized int get(){

        try {
            wait(5);
        }
        catch (Exception e){
            System.out.println(e);
        }


        notify();
        return r;



    }


}


class FirS extends Thread{

    Resursa res;

    FirS(Resursa res) {

        this.res = res;

    }

   public void run(){

        for(int i=0;i<10;i++)
        {


            res.set(i);
            System.out.println(getName()+"am scris: "+i);


        }



    }

}

class FirC extends Thread {

    Resursa res;

    FirC(Resursa res){

        this.res = res;

    }


    public void run(){


        for(int i=0;i<10;i++){

            System.out.println(getName()+"am citit: "+res.get());

        }

    }



}

public class Main {


    public static void main(String[] args) {


        Resursa res=new Resursa();

        FirS fs = new FirS(res);
        FirC fc = new FirC(res);

        fs.start();
        fc.start();

    }


}


//wait()
//wait(ms) primeste notify sau expira timpul
//wait(ms+ns)
//notify
//notify all