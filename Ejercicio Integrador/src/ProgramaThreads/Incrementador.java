package ProgramaThreads;

class Incrementador implements Runnable {
    private Contador contador;

    public Incrementador(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        // Incrementa el contador
        for (int i = 0; i < 1000; i++) {
            contador.incrementar();
        }
    }
}
