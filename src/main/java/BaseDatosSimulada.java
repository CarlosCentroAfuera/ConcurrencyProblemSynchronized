public class BaseDatosSimulada {

    private static int saldo = 100;

    private static int obtenerSaldo() throws InterruptedException {
        long sleepingTime = (long) (Math.random()*1000);
        Thread.sleep(sleepingTime);
        return saldo;
    }

    private static void actualizarSaldo(int saldo) throws InterruptedException {
        long sleepingTime = (long) (Math.random()*1000);
        Thread.sleep(sleepingTime);
        BaseDatosSimulada.saldo = saldo;
    }

    /**
     *
     * @param cantidad representa la cantidad de € que le gustaría sacar
     * @return la cantidad de € que ha conseguido sacar
     * @throws InterruptedException
     */
    static boolean enUso = false;

    public synchronized static int sacarDinero(int cantidad) throws InterruptedException {
        int saldo = obtenerSaldo();
        if (saldo - cantidad >= 0) {
            actualizarSaldo(saldo - cantidad);
            System.out.println("Se ha entregado al cliente " + cantidad + "€");
            return cantidad;
        } else {
            System.out.println("No había cantidad de € suficientes");
            return 0;
        }

    }

    public static void imprimirSaldo(){
        System.out.println("En la base de datos actualmente tenemos  " + saldo + "€");
    }

    public static void reiniciar(){
        System.out.println("En la base de datos comenzamos teniendo " + 100 + "€");
        saldo = 100;
    }
}
