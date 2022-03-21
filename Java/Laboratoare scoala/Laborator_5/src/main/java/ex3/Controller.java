package ex3;


public class Controller {
    private static Controller controller;


    public void display(Sensor temp,Sensor light){
        int counter=0;
        while(counter<=20) {

            //perioada
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println("Temperatura= "+ temp.readValue());
            System.out.println("Lumina= "+ light.readValue());
            counter++;

        }

    }



}

