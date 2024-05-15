package MultiTasking;

public class Multitasking {
    public static void main(String[] args) {
        // Crear instancias de las clases
        NumberCounter numberCounter = new NumberCounter();
        CharPrinter charPrinter = new CharPrinter();

        // Crear hilos para ejecutar las tareas
        Thread countThread = new Thread(numberCounter);
        Thread charThread = new Thread(charPrinter);

        // Iniciar ambos hilos
        countThread.start();
        charThread.start();

        // Esperar a que ambos hilos terminen
        try {
            countThread.join();
            charThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Ambos hilos han terminado.");
    }
}



