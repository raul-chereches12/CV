package ex4;

import jdk.swing.interop.SwingInterOpUtils;

class FireEvent extends Event {

    private boolean smoke;
    private String location;

    FireEvent(boolean smoke,String location) {
        super(EventType.FIRE);
        this.location=location;
        this.smoke = smoke;
    }

    boolean isSmoke() {
        return smoke;
    }


    @Override
    public String toString() {
        if(smoke==true) {
            System.out.println("Calling 0757523536- Raul-George Chereches :(");
            return "FOC! FOC! FOC! in "+location;
        }
        else
            return "Temperatura mare, fum inexistend, posibil sa se aprinda ! ! !";
    }

}
