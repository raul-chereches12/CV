import javax.swing.*;

public class test {


    public static void main(String[] args) {


        window obiect_cu_care_sincronizam=new window();

        Runnable runnable_citire = new citireFisier(obiect_cu_care_sincronizam);
        Runnable runnable_scriere = new scriereFisier(obiect_cu_care_sincronizam);


        Thread thread_citire = new Thread(runnable_citire);
        Thread thread_scriere = new Thread(runnable_scriere);

        System.out.println("Starting Thread...");

        thread_citire.start();
        thread_scriere.start();






    }



}
