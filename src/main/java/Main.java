import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.ArrayList;

public class Main {

    public static int dineroSacado = 0;


    public static void main(String[] args) {
        try {
            ImmutablePair<String, Long> resultado1 = usandoJoinsIntercalados();
            ImmutablePair<String, Long> resultado2 = usandoJoinsAlFin();
            ImmutablePair<String, Long> resultado3 =usandoJoinsEnLista();
            System.out.println(resultado1.getKey() + " ha tardado " + resultado1.getValue() + " mientras que " + resultado2.getKey() + " ha tardado " + resultado2.getValue());
            System.out.println(resultado1.getKey() + " ha tardado " + resultado1.getValue() + " mientras que " + resultado3.getKey() + " ha tardado " + resultado3.getValue());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * Este ejemplo utiliza joins al finalizar todos los hilos.
     * @return el tiempo que ha tardado en realizar la operación
     */
    private static ImmutablePair<String, Long> usandoJoinsIntercalados() throws InterruptedException {
        reiniciar();
        System.out.println("======================================================");

        long inicio = System.currentTimeMillis();
        Cajero t1 = new Cajero(25, 1);
        t1.start();
        t1.join();
        Cajero t2 = new Cajero(25,2);
        t2.start();
        t2.join();
        Cajero t3 = new Cajero(25, 3);
        t3.start();
        t3.join();
        Cajero t4 = new Cajero(25, 4);
        t4.start();
        t4.join();
        Cajero t5 = new Cajero(25, 5);
        t5.start();
        t5.join();
        long fin = System.currentTimeMillis();

        System.out.println("He sacado en total: " + dineroSacado + "€");
        BaseDatosSimulada.imprimirSaldo();

        System.out.println("======================================================");

        return new ImmutablePair<>("usandoJoinsIntercalados", fin - inicio);
    }

    /**
     * Este ejemplo utiliza joins entre cada una de los hilos.
     * @return el tiempo que ha tardado en realizar la operación
     */
    private static ImmutablePair<String, Long> usandoJoinsAlFin() throws InterruptedException {
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

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        long fin = System.currentTimeMillis();

        System.out.println("He sacado en total: " + dineroSacado + "€");
        BaseDatosSimulada.imprimirSaldo();
        System.out.println("======================================================");

        return new ImmutablePair<>("usandoJoinsIntercalados", fin - inicio);
    }


    /**
     * Este ejemplo utiliza joins entre cada una de los hilos.
     * @return el tiempo que ha tardado en realizar la operación
     */
    private static ImmutablePair<String, Long> usandoJoinsEnLista() throws InterruptedException {
        reiniciar();
        System.out.println("======================================================");

        long inicio = System.currentTimeMillis();

        ArrayList<Thread> listaHilos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listaHilos.add(new Cajero(25, i));
            listaHilos.get(i).start();
        }

        for (Thread t : listaHilos) {
            t.join();
        }

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
