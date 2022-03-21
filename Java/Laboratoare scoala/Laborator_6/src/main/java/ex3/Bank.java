package ex3;

import ex1.BankAccount;

import java.util.*;

public class Bank {

    private TreeSet<BankAccount> accounts= new TreeSet<BankAccount>();


    public void addAccount(String owner,double balance){

        accounts.add(new BankAccount(owner,balance));

    }
    public void printAccounts(){

        System.out.println(Arrays.toString(accounts.toArray()));
    }

    public void printAccounts(double minBalance,double maxBalance){

        System.out.println( "Elementele in range-ul"+minBalance+" si "+maxBalance);
        Iterator<BankAccount> itr = accounts.iterator();
        BankAccount aux;
        while (itr.hasNext()) {
            aux=itr.next();
            if((aux.getBalance()>=minBalance)&&(aux.getBalance()<=maxBalance));
            System.out.println(aux);
        }

    }

    public BankAccount getAccount(String owner) {

        System.out.println("Cautare dupa owner");
        Iterator<BankAccount> itr = accounts.iterator();
        BankAccount aux;
        while (itr.hasNext()) {
            aux = itr.next();
         if(aux.getOwner()==owner)
            return aux;
        }
        return null;//caz in care nu este owner
    }

}