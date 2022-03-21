import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.spec.ECField;

public class citireFisier implements Runnable{

    private window object;
    private String sir;


    citireFisier(window object){

        this.object=object;

    }

    public void citire(){


        synchronized (object){

            try {
                File myObj = new File(String.valueOf(object.itteration));
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());

                    FileWriter myWriter = new FileWriter(myObj.getName());
                    myWriter.write(object.textArea1.getText());
                    myWriter.close();


                } else {
                    System.out.println("File already exists.");
                }

            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            object.notify();
        }


    }


    @Override
    public void run() {

        while(object.itteration<=20) {

            try {
                Thread.sleep(4000);
            }catch (Exception r){
                System.out.println(r);
            }
            System.out.println("AM INTRAT");


            citire();


object.asteapta=false;

        }

    }




}
