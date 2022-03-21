package chereches.raul.lab1.ex6;

import java.util.Scanner;

public class Class6 {

    public static void main(String[] args){
        System.out.print("Introduceti numarul N");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.print("metoda 1: "+factorialNormal(n));



        System.out.print("metoda 2: "+factorialRecursiv(n));

    }

    public static int factorialNormal(int var){
        int i,prod=1;

        for(i=1;i<=var;i++)
            prod=prod*i;

        return prod;
    }
    public static int factorialRecursiv(int var){
        if(var==1)
            return 1;
        else
            return factorialRecursiv(var-1)*var;

    }

}
