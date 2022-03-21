package ex4;

import ex3.LightSensor;
import ex3.Sensor;
import ex3.TemperatureSenson;

public class Controller {
    Sensor temperatura=new TemperatureSenson();
    Sensor lumina=new LightSensor();
    private static Controller controller;
    private Controller() {
    }

    public static Controller getController() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }


    public void control(){
        int counter=0;
        while(counter<=20) {

            //perioada
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println("Temperatura= "+ temperatura.readValue());
            System.out.println("Lumina= "+ lumina.readValue());
            counter++;
        }

    }



}
