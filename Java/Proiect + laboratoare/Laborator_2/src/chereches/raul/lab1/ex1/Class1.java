package chereches.raul.lab1.ex1;

import java.util.Scanner;

public class Class1 {

    public static void main(String[] args) {
        System.out.print("Introduceti 2 numere:");
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        if (x > y) {
            System.out.println("maximul este x=" + x);
        } else if (x == y) {
            System.out.println("sunt egale");
        } else {
            System.out.println("maximul este y=" + y);
        }

    }
}
