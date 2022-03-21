package chereches.raul.lab1.ex7;

import java.util.Random;
import java.util.Scanner;

public class Class7 {


    public static void main(String[] args) {
        Random rand = new Random();
        int incercari = 0;
        int numarul_de_ghicit = rand.nextInt(10), x, ok = 1;
        Scanner in = new Scanner(System.in);
        System.out.println("Joc de ghicit");

        while ((ok == 1) && (incercari < 3)) {
            System.out.println("Introduceti numarul intre 0-10:");
            x = in.nextInt();
            incercari++;
            if (x == numarul_de_ghicit) {
                System.out.println("Ati ghicit numarul");
                ok = 0;
            } else if (x > numarul_de_ghicit) {
                System.out.println("Numarul mai mare decat numarul cautat");
            } else {
                System.out.println("Numarul mai mic decat numarul cautat");
            }
            if (incercari == 3) {
                System.out.println("Ati atins numarul maxim de incercari!!!");
            }


        }

        System.out.println("Numarul cautat este: "+numarul_de_ghicit);

    }

}