import FirstFit.*;
import MultiProcesamientoSimetrico.*;
import MultiTasking.*;
import ReentrantLock.*;
import ReentrantLock.Process;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el algoritmo de procesamiento concurrente:");
        System.out.println("1. First Fit");
        System.out.println("2. MultiProcesamiento Simétrico");
        System.out.println("3. MultiTasking");
        System.out.println("4. Reentrant Lock");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                ejecutarFirstFit();
                break;
            case 2:
                ejecutarMultiProcessing();
                break;
            case 3:
                ejecutarMultiTasking();
                break;
            case 4:
                ejecutarReentrantLock();
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    private static void ejecutarFirstFit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de procesos:");
        int n = scanner.nextInt();

        List<Proceso> procesos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese el ID del proceso " + (i + 1) + ":");
            int id = scanner.nextInt();
            System.out.println("Ingrese la memoria requerida para el proceso " + id + ":");
            int memoriaRequerida = scanner.nextInt();
            System.out.println("Ingrese el tiempo de ejecución para el proceso " + id + ":");
            int tiempoDeEjecucion = scanner.nextInt();
            procesos.add(new Proceso(id, memoriaRequerida, tiempoDeEjecucion));
        }

        System.out.println("Ingrese la memoria total:");
        int memoriaTotal = scanner.nextInt();

        AlgoritmoMemoria algoritmoMemoria = new FirstFit();
        algoritmoMemoria.asignarMemoria(procesos, memoriaTotal);

        EjecutorProcesos ejecutor = new EjecutorProcesos(procesos.size());
        for (Proceso proceso : procesos) {
            ejecutor.ejecutarProceso(proceso);
        }
        ejecutor.detenerEjecucion();
    }

    private static void ejecutarMultiProcessing() {
        int numCores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numCores);

        for (int i = 0; i < numCores; i++) {
            executor.submit(new Task(i));
        }
        executor.shutdown();

        ResultProcessor resultProcessor = new ResultProcessor();
        resultProcessor.processResults();
    }

    private static void ejecutarMultiTasking() {
        NumberCounter numberCounter = new NumberCounter();
        CharPrinter charPrinter = new CharPrinter();

        Thread countThread = new Thread(numberCounter);
        Thread charThread = new Thread(charPrinter);

        countThread.start();
        charThread.start();

        try {
            countThread.join();
            charThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Ambos hilos han terminado.");
    }

    private static void ejecutarReentrantLock() {
        List<Process> processes = List.of(new Process(1), new Process(2), new Process(3));
        ReentrantLockAlgorithm algorithm = new ReentrantLockAlgorithm();
        algorithm.simulate(processes);
    }
}

