package ex1;

class Sensor implements ObserverTempSensor{
private int temperature;
    @Override
    public void update(int temp) {
        this.temperature=temp;
        System.out.println("New update Temperature status");
        System.out.println("Received Temperature: "+temp);

    }

}
