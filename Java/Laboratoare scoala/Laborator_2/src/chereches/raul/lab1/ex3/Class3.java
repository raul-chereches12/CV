package chereches.raul.lab1.ex3;

import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Class3 {


    public static void main(String[] args) {
        int increment = 0;
        int i;


            System.out.println("Introduceti 2 numere A si B:");
            Scanner in = new Scanner(System.in);
            int a = in.nextInt();
            int b = in.nextInt();



        System.out.println("Numere prime: ");
        for (i = a; i <= b; i++) {

            if(i>=2) {
                if (isPrime(i) == 1) {
                    System.out.print(i + " ");
                    increment++;
                }
            }

        }
        System.out.println("Avem " + increment + " numere prime");

    }

    public static int isPrime(int var) {
        int ok = 1, i;
        for (i = 2; i <= sqrt(var); i++)
            if (var % i == 0)
                ok = 0;

        if (ok == 1)
            return 1;
        else
            return 0;

    }

}
