import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.ArrayList;

public class Main {

    public static int dineroSacado = 0;


    public static void main(String[] args) {
        try {
            ImmutablePair<String, Long> resultado1 = sinJoin();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static ImmutablePair<String, Long> sinJoin() throws InterruptedException {
        reiniciar();
        System.out.println("======================================================");

        long inicio = System.currentTimeMillis();
        Cajero t1 = new Cajero(25, 1);
        t1.start();
        Cajero t2 = new Cajero(25,2);
        t2.start();
        Cajero t3 = new Cajero(25, 3);
        t3.start();
        Cajero t4 = new Cajero(25, 4);
        t4.start();
        Cajero t5 = new Cajero(25, 5);
        t5.start();
        long fin = System.currentTimeMillis();

        System.out.println("He sacado en total: " + dineroSacado + "€");
        BaseDatosSimulada.imprimirSaldo();

        System.out.println("======================================================");

        return new ImmutablePair<>("usandoJoinsIntercalados", fin - inicio);
    }


    private static void reiniciar() {
        dineroSacado = 0;
        BaseDatosSimulada.reiniciar();
    }
}
