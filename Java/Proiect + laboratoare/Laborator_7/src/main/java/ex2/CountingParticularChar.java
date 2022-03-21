package ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountingParticularChar {
    public static void main(String[] args) {
        int count = 0;


        try {

            File myObj = new File("src/main/java/ex2/date.txt");
            Scanner myReader = new Scanner(myObj);
            Scanner option = new Scanner(System.in);
            System.out.println("Introduceti caracterul cautat:");

            char c = option.next().charAt(0);


            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);

                for (int i = 0; i < data.length(); i++) {
                    if (data.charAt(i) == c) {
                        count++;
                    }
                }
            }
                myReader.close();


            System.out.println("Number of characters "+c+" are: "+count);
            } catch(FileNotFoundException e){
                System.out.println("An error occurred.");
                e.printStackTrace();
            } catch (Exception e){
            System.out.println("An error occurred.");

        }
    }

}
