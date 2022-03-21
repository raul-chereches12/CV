package ex2;

import ex1.BankAccount;

import java.util.Comparator;



    class SortbyOwner implements Comparator<BankAccount> {
        // Used for sorting in ascending order of
        // name
        @Override
        public int compare(BankAccount a, BankAccount b)
        {
            return a.getOwner().compareTo(b.getOwner());
        }
    }

