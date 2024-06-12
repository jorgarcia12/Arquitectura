package FirstFit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EjecutorProcesos {
    private ExecutorService executorService; // Declara una variable para almacenar el servicio de ejecución de procesos

    // Constructor que inicializa el ExecutorService con un número fijo de threads
    public EjecutorProcesos(int numThreads) {
        executorService = Executors.newFixedThreadPool(numThreads);
    }

    // Método para ejecutar un proceso
    public void ejecutarProceso(Proceso proceso) {
        executorService.execute(() -> { // Ejecuta un proceso en un thread del pool
            System.out.println("Ejecutando proceso " + proceso.getId()); // Imprime un mensaje indicando que el proceso está siendo ejecutado
            try {
                Thread.sleep(proceso.getTiempoDeEjecucion()); // Simula el tiempo de ejecución del proceso
            } catch (InterruptedException e) {
                e.printStackTrace(); // Maneja una posible interrupción del thread
            }
            System.out.println("Proceso " + proceso.getId() + " finalizado"); // Imprime un mensaje indicando que el proceso ha finalizado
        });
    }

    // Método para detener la ejecución de procesos
    public void detenerEjecucion() {
        executorService.shutdown(); // Detiene la ejecución del ExecutorService
    }
}
