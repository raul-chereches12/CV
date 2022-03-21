package ex2;

import ex1.BankAccount;

import java.util.*;

public class Bank {

    private List<BankAccount> accounts= new ArrayList<BankAccount>();


    public void addAccount(String owner,double balance){

        accounts.add(new BankAccount(owner,balance));

    }
    public void printAccounts(){

        for(int i=0; i < accounts.size(); i++){
                System.out.println( accounts.get(i).toString() );
        }
    }

    public void printAccounts(double minBalance,double maxBalance){

        System.out.println( "Elementele in range-ul"+minBalance+" si "+maxBalance);
        for(int i=0; i < accounts.size(); i++){
            if((accounts.get(i).getBalance()>=minBalance)&&(accounts.get(i).getBalance()<=maxBalance))
            System.out.println( accounts.get(i).toString() );
        }

    }

    public BankAccount getAccount(String owner){

        System.out.println( "Cautare dupa owner");
        for(int i=0; i < accounts.size(); i++){
            if((accounts.get(i).getOwner()==owner))
                return accounts.get(i);
        }
return null;//caz in care nu este owner
    }
    public List<BankAccount> getAllAccounts(){

        return this.accounts;

    }



}
