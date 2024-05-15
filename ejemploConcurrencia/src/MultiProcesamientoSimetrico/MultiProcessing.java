package MultiProcesamientoSimetrico;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiProcessing {
    public static void main(String[] args) {
        // Creamos una varaible q utiliza el numero de nucleos de nuestra PC para simular mejor este Multiprocesamiento
        int numCores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numCores);

        // Crear e iniciar las tareas
        for (int i = 0; i < numCores; i++) {
            executor.submit(new Task(i));
        }

        // Apagar el pool de hilos después de que todas las tareas han sido enviadas
        executor.shutdown();

        // Crear e iniciar el procesador de resultados
        ResultProcessor resultProcessor = new ResultProcessor();
        resultProcessor.processResults();
    }
}
