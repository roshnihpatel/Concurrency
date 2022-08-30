package com.sparta.rp;

public class BankAccount implements Runnable {
    private static int balance = 100;

    @Override
    public void run() {
        System.out.println(Util.getThreadName() + " checks the balance " + balance);
        makesWithdrawal(75);
        if(balance < 0){
            System.out.println("Account has been overdrawn, Balance:" + balance);
        }

    }

    private synchronized void makesWithdrawal(int amount) {
        if (balance >= amount){
            System.out.println(Util.getThreadName() + " is going to withdraw");
            balance = balance - amount;
            System.out.println(Util.getThreadName() + " has withdrawn " + amount);
        } else {
            System.out.println( "Sorry, not enough balance for " + Util.getThreadName() + " to withdraw");
        }

    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        Thread husband = new Thread(bankAccount);
        Thread wife = new Thread(bankAccount);
        husband.setName("Husband");
        wife.setName("Wife");

        husband.start();
        wife.start();
    }
}
