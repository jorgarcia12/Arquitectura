package ProcesosSincronizados;

import java.util.Random;

class Filosofo extends Thread {
    private final int id;
    private final Cubierto cubiertoIzquierdo;
    private final Cubierto cubiertoDerecho;
    private final Random random = new Random();

    public Filosofo(int id, Cubierto cubiertoIzquierdo, Cubierto cubiertoDerecho) {
        this.id = id;
        this.cubiertoIzquierdo = cubiertoIzquierdo;
        this.cubiertoDerecho = cubiertoDerecho;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (cubiertoIzquierdo) {
                    cubiertoIzquierdo.tomar();
                    synchronized (cubiertoDerecho) {
                        cubiertoDerecho.tomar();

                        System.out.println("Filósofo " + id + " comiendo");
                    }
                }

                Thread.sleep(random.nextInt(4000) + 1000);


                cubiertoIzquierdo.soltar();
                cubiertoDerecho.soltar();


                System.out.println("El filósofo " + id + " está pensando");


                Thread.sleep(random.nextInt(4000) + 1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

