package ProgramaThreads;

class Contador {
    private int valor = 0;

    // Método para sincronizar el incremento del contador
    public synchronized void incrementar() {
        valor++;
    }

    // Método para obtener el valor del contador
    public int getValor() {
        return valor;
    }
}
