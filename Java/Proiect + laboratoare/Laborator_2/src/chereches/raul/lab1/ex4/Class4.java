package chereches.raul.lab1.ex4;

import java.util.Scanner;
import java.util.Vector;

public class Class4 {


    public static void main(String[] args) {
        int i;
        int maximul = 0;
        Vector<Integer> numere = new Vector<Integer>();
        Scanner in = new Scanner(System.in);

        System.out.print("Introduceti cate elemente va avea vectorul:");
        int n = in.nextInt();
        System.out.print("Introduceti elementele:");
        for (i = 0; i < n; i++) {
            System.out.print("v[" + i + "]= ");
            int y = in.nextInt();
            numere.add(y);
        }

        for (i = 0; i < n; i++) {

            if (maximul < numere.get(i))
                maximul = numere.get(i);

        }


        System.out.println("Vector: " + numere);
        System.out.println("Maximul=: " + maximul);


    }

}
