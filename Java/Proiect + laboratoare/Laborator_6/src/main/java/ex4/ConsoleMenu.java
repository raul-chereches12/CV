package ex4;

import java.util.Scanner;

public class ConsoleMenu {


    private static ConsoleMenu pointer=null;




//SINGLETON
    public static ConsoleMenu getInstance(){

        if(pointer==null)
            pointer=new ConsoleMenu();

return pointer;

    }


    public void getOption(){
        Scanner myObj = new Scanner(System.in);
        String string;
        Dictionary dictionar =new Dictionary();

        int option;
        boolean ok=true;

        while(ok) {
System.out.println("Introduceti optiunea:");
            System.out.println("1)Add a word");
            System.out.println("2)Get the definition of a word");
            System.out.println("3)Get all words");
            System.out.println("4)Get all definitions");
            System.out.println("5)Exit");
            option = myObj.nextInt();  // Read user input
switch (option){

    case 1:
        System.out.println("Enter the word:");

        myObj.nextLine();//se ia enter-ul de la optiune

        string = myObj.nextLine();  // Read user input

        Word word =new Word(string);

        System.out.println("Enter the definition for the word: "+word.getName());

        string = myObj.nextLine();  // Read user input
        Definition definition =new Definition(string);

        dictionar.addWord(word,definition);

        break;
    case 2:
        System.out.println("Enter the word for which you want the description");

        myObj.nextLine();//se ia enter-ul de la optiune
        string = myObj.nextLine();  // Read user input

        dictionar.getDefinition(new Word(string));

        break;
    case 3:
        dictionar.getAllWords();
        break;
    case 4:
        dictionar.getAllDefinitions();
        break;

    case 5:
        ok=false;//se iese
        break;

    default:
        throw new IllegalStateException("Unexpected value: " + option);
}


        }


    }



}
