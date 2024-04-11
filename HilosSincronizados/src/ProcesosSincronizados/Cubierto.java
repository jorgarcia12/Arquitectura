package ProcesosSincronizados;

public class Cubierto {
    private boolean disponible = true;

    public synchronized void tomar() throws InterruptedException {
        while (!disponible) {
            wait();
        }
        disponible = false;
    }

    public synchronized void soltar() {
        disponible = true;
        notifyAll();
    }
}

