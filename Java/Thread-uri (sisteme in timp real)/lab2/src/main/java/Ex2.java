public class Ex2 {

    private static boolean stopThreads = false;

    public static void main(String[] args){

        FileService service = new FileService("messages.txt");

        RThread reader = new RThread(service);

        WThread writer = new WThread(service);

        reader.start();

        writer.start();

    }

    public static boolean isStopThreads(){

        return stopThreads;

    }

}

class WThread extends Thread{

    FileService service;

    public WThread(FileService service) {

        this.service = service;

    }

    public void run(){

        while(!Ex2.isStopThreads()){

            String msg= String.valueOf(Math.round(Math.random()*100));

            service.write(msg);

            try {

                Thread.sleep(2000);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }

}

class RThread extends Thread{

    FileService service;

    public RThread(FileService service) {

        this.service = service;

    }

    public void run(){
        while (!Ex2.isStopThreads())
        { try {
            String readMsg = service.read();
            System.out.println(readMsg);
            Thread.sleep(3000);
        } catch (Exception e) { e.printStackTrace();
        }
        }
    }

}

