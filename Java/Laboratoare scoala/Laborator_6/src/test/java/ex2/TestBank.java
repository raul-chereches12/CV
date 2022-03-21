package ex2;

import ex1.BankAccount;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBank {

    @Test

    public void testBank(){

Bank accounts= new Bank();

List<BankAccount> newArrayList;


accounts.addAccount("Raul-George Chereches",700);
accounts.addAccount("Florin Deac",4000);
accounts.addAccount("Tudor Mocan",1500);
accounts.addAccount("Casian Lipo",2700);
        accounts.addAccount("Ana Lipovan",2000);

newArrayList=accounts.getAllAccounts();

        Bank newAccounts= new Bank();
        newAccounts=accounts;

        newAccounts.getAllAccounts().sort(new SortbyOwner());



       accounts.printAccounts();

        System.out.println();

       newAccounts.printAccounts();

        System.out.println();





    }





}
