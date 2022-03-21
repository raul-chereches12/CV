package ex4;

public class CoolEvent extends Event{



    CoolEvent() {
        super(EventType.COOL);

    }



    @Override
    public String toString() {
        return "Cooling process started!";
    }
}
