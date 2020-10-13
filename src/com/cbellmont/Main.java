package com.cbellmont;

public class Main {

    public static void main(String[] args) {
        try {
            ThreadWithdrawMoney t1 = new ThreadWithdrawMoney(25);
            t1.start();
            t1.join();
            ThreadWithdrawMoney t2 = new ThreadWithdrawMoney(25);
            t2.start();
            t2.join();
            ThreadWithdrawMoney t3 = new ThreadWithdrawMoney(25);
            t3.start();
            t3.join();
            ThreadWithdrawMoney t4 = new ThreadWithdrawMoney(25);
            t4.start();
            t4.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
