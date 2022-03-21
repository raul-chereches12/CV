package pack_computer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logs {


    public static void update(String str){


        SimpleDateFormat formatter= new SimpleDateFormat("yyyy_MM_dd_'at'_HH_mm_ss_z");
        Date date = new Date(System.currentTimeMillis());
        String pathname=formatter.format(date);


//pathname.replaceAll("\\s+","_");
System.out.println(pathname);


        try {
            File myObj = new File("logs/"+pathname+".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("logs/"+pathname+".txt");

            myWriter.write(str);


            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }



    }






}
