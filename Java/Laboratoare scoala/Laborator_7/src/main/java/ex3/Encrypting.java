package ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Encrypting {

    public static void main(String[] args) {
        int count = 0;


        try {

            FileWriter myWriter = new FileWriter("src/main/java/ex3/encrypted.enc");



            File myObj = new File("src/main/java/ex3/date.txt");
            Scanner myReader = new Scanner(myObj);






            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                for(int i=0;i<data.length();i++) {
                    myWriter.write(data.charAt(i)-1);
                }
                myWriter.write(" ");

            }
            myReader.close();
            myWriter.close();



        } catch(FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();


        } catch (Exception e){
            System.out.println("An error occurred.");

        }





    }



}
