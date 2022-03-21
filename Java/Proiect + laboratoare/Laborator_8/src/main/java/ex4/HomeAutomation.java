package ex4;

import java.io.File;
import java.io.FileWriter;
import java.security.spec.ECField;

public class HomeAutomation {

    public static void main(String[] args){

        File file = new File("src/main/java/ex4/event_log.txt");


        //test using an annonimous inner class
        ControlUnit controlUnit=new ControlUnit();

            Home h = new Home() {
                protected void setValueInEnvironment(Event event) {
                    System.out.println("New event in environment " + event);
                }

                protected void controllStep() {
                    controlUnit.execute();

                }





            };
            h.simulate();




    }
}
