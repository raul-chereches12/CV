package ex3;
import java.util.Random;
public class TemperatureSenson extends Sensor{

    Random rand = new Random();


    public int readValue() {
        return rand.nextInt(100);
    }

}
