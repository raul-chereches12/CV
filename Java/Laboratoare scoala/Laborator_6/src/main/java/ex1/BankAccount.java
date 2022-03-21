package ex1;

import java.util.Objects;

public class BankAccount {

    private String owner;
    private double balance;


    public BankAccount(String owner,double balance){
        this.owner=owner;
        this.balance=balance;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void withdraw(double sum){
        this.balance-=sum;

    }

    public void deposit(double sum){
        this.balance+=sum;

    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "owner='" + owner + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Double.compare(that.balance, balance) == 0 && Objects.equals(owner, that.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, balance);
    }
}

