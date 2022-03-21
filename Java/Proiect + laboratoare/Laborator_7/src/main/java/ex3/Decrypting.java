package ex3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Decrypting {
    public static void main(String[] args) {


        try {
            File criptat = new File("src/main/java/ex3/encrypted.enc");

            FileWriter decriptat = new FileWriter("src/main/java/ex3/decrypted.dec");

            Scanner myReader = new Scanner(criptat);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                for (int i = 0; i < data.length(); i++) {

                    decriptat.write(data.charAt(i) + 1);

                }

            }
            myReader.close();
            decriptat.close();

        }catch (Exception e){
            System.out.println(e);
        }

    }
}