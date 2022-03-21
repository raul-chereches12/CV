package ex6;

public class Main {

    public static void main(String[] args) {

        Chronometer ceasu=new Chronometer();

       new Thread(() -> ceasu.run()).start();



    }





}
