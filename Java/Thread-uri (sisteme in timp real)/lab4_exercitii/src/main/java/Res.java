public class Res {

    public synchronized void notifica(){

        notify();
    }

    public synchronized void ast() throws InterruptedException {
        wait();
    }


}
