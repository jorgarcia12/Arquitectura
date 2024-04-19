package ProgramaThreads;

public class Main {
    public static void main(String[] args) {
        // Creamos un objeto de tipo Contador
        Contador contador = new Contador();

        // Crear los threads
        Thread thread1 = new Thread(new Incrementador(contador));
        Thread thread2 = new Thread(new Incrementador(contador));

        // le damos .start() a los threads
        thread1.start();
        thread2.start();

        try {
            // Esperamos a que los threads terminen su ejecucion
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Imprimos el ultimo valor del contador
        System.out.println("Valor final del contador: " + contador.getValor());
    }
}

