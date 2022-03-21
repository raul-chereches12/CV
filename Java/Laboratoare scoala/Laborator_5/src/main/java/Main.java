import ex4.Controller;

public class Main {


    public static void main(String[] args) {

       // Controller.getController().control();//ex4


        ex3.TemperatureSenson temperatureSenson = new ex3.TemperatureSenson();
        ex3.LightSensor lightSensor = new ex3.LightSensor();
        ex3.Controller controler =new ex3.Controller();
        controler.display(temperatureSenson,lightSensor);


    }

}
