public class Cajero extends Thread {

    private final int dineroASacar;
    private final int numeroTransaccion;

    public Cajero(int dineroASacar, int numeroTransaccion){
        this.dineroASacar = dineroASacar;
        this.numeroTransaccion = numeroTransaccion;
    }

    @Override
    public void run() {
        try {
            System.out.println("Simulamos que sacamos " + dineroASacar + "€ en la operación " + numeroTransaccion);
            Main.dineroSacado += BaseDatosSimulada.sacarDinero(dineroASacar);
            System.out.println("Transacción número "+ numeroTransaccion + " finalizada.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

