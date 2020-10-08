package com.cbellmont;

public class ThreadWithdrawMoney extends Thread {

    private final int cashToWithdraw;

    public ThreadWithdrawMoney(int cashToWithdraw){
        this.cashToWithdraw = cashToWithdraw;
    }

    @Override
    public void run() {
        try {
            System.out.println("Simulamos la lectura del saldo del cliente");
            int cash = FakeDB.cash;
            // Ponemos un delay para simular el tiempo que tarda el saldo en llegar desde el servidor al movil
            long sleepingTime = (long) (Math.random()*1000);
            sleep(sleepingTime);
            cash = cash - this.cashToWithdraw;

            // Vovlemos a poner un delay para simular el tiempo que tarda la transacción en realizarse
            sleep(sleepingTime);
            System.out.println("Simulamos la escritura del saldo del cliente");
            FakeDB.cash = cash;
            System.out.println("El resultado guardado en la base de datos es " + FakeDB.cash);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

