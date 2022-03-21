import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class scriereFisier implements Runnable{

    private window object;

    scriereFisier(window object){

        this.object=object;

    }


    public void scriere(){

        synchronized (object) {

            while(object.asteapta==true) {
                try {
                    object.wait();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            try {
                File myObj = new File(String.valueOf(object.itteration));
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    object.textArea2.setText(data);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            System.out.println("Terminarea iteratiei: "+object.itteration);
        }

    }


    @Override
    public void run() {

        while(object.itteration<=20){


            System.out.println("AM SCRIS");
            scriere();

            object.itterate();
            object.asteapta=true;

        }


    }
}
