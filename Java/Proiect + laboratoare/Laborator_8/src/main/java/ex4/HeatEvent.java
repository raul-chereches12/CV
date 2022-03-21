package ex4;

public class HeatEvent extends Event{


    HeatEvent() {
        super(EventType.HEAT);

    }



    @Override
    public String toString() {
        return "Heating process started!";
    }
}
