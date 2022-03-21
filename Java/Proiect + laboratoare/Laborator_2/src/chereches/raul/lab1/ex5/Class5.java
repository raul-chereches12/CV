package chereches.raul.lab1.ex5;

import java.util.Scanner;
import java.util.Vector;
import java.util.Random;

public class Class5 {
    int i;

    public static void main(String[] args) {
        int numar_random, i, j;
        Vector<Integer> numere = new Vector<Integer>();
        Random rand = new Random();
        System.out.print("Introduceti numarul de elemente al vectorului:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (i = 0; i < n; i++) {
            numar_random = rand.nextInt(99);
            numere.add(numar_random);

        }
        //sortare
        int aux = 0;
        for (i = 0; i < n - 1; i++)
            for (j = i + 1; j < n; j++)
                if (numere.get(i) > numere.get(j)) {
                    aux = numere.get(i);
                    numere.set(i, numere.get(j));
                    numere.set(j, aux);
                }

        System.out.println("Vector: " + numere);

    }
}
