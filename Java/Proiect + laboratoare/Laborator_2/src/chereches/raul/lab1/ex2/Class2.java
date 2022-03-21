package chereches.raul.lab1.ex2;

import java.util.Scanner;

public class Class2 {


    public static void main(String[] args) {

        System.out.print("Introduceti o variabila:");
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();

        printNumberInWord(x);


    }

    public static void printNumberInWord(int var) {


        switch (var) {

            case 1:
                System.out.println("ONE");
                break;
            case 2:
                System.out.println("TWO");
                break;
            case 3:
                System.out.println("THREE");
                break;
            case 4:
                System.out.println("FOUR");
                break;
            case 5:
                System.out.println("FIVE");
                break;
            case 6:
                System.out.println("SIX");
                break;
            case 7:
                System.out.println("SEVEN");
                break;
            case 8:
                System.out.println("EIGHT");
                break;
            case 9:
                System.out.println("NINE");
                break;
            default:
                System.out.println("OTHERS");


        }

        System.out.println("METODA 2:");

        if (var == 1) {
            System.out.println("ONE");
        }
        else if (var == 2) {
            System.out.println("TWO");
        }
        else if (var == 3) {
            System.out.println("THREE");
        }
        else if (var == 4) {
            System.out.println("FOUR");
        }
        else if (var == 5) {
            System.out.println("FIVE");
        }
        else if (var == 6) {
            System.out.println("SIX");
        }
        else if (var == 7) {
            System.out.println("SEVEN");
        }
        else if (var == 8) {
            System.out.println("EIGHT");
        }
        else if (var==9) {
            System.out.println("NINE");
        }
        else System.out.println("OTHERS");


    }


}
