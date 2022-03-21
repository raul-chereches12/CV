package ex1;



public class Main {


    public static void main(String[] args) {
        TemperatureControl control_temp=new TemperatureControl();
        Sensor temp_sensor1=new Sensor();

control_temp.register(temp_sensor1);

        Thread newThread = new Thread(control_temp);
        newThread.start();








    }



}
