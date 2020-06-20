package com.company;

public class BankObj {

    private int account_no;
    private int balance;

    public BankObj(int account_no, int balance) {
        this.account_no = account_no;
        this.balance = balance;
    }

    public int getAccount_no() {
        return account_no;
    }

    public void setAccount_no(int account_no) {
        this.account_no = account_no;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
