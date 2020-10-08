package com.cbellmont;

public class Main {

    public static void main(String[] args) {
        try {
            ThreadWithdrawMoney t1 = new ThreadWithdrawMoney(25);
            t1.start();
            ThreadWithdrawMoney t2 = new ThreadWithdrawMoney(25);
            t2.start();
            ThreadWithdrawMoney t3 = new ThreadWithdrawMoney(25);
            t3.start();
            ThreadWithdrawMoney t4 = new ThreadWithdrawMoney(25);
            t4.start();
            t1.join();
            t2.join();
            t3.join();

            t4.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
