package FirstFit;

import java.util.ArrayList;
import java.util.List;

public class SimuladorConcurrencia {
    public static void main(String[] args) {

        int memoriaTotal = 10; // Tamaño total de la memoria
        AlgoritmoMemoria algoritmoMemoria = new FirstFit(); // Instancia un algoritmo de asignación de memoria

        // Crear una lista de procesos
        List<Proceso> procesos = new ArrayList<>();
        procesos.add(new Proceso(1, 3, 2000)); // Proceso 1: Requiere 3 unidades de memoria, tiempo de ejecución 2 segundos
        procesos.add(new Proceso(2, 4, 3000)); // Proceso 2: Requiere 4 unidades de memoria, tiempo de ejecución 3 segundos
        procesos.add(new Proceso(3, 2, 1500)); // Proceso 3: Requiere 2 unidades de memoria, tiempo de ejecución 1.5 segundos

        // Asignar memoria a los procesos utilizando el algoritmo especificado
        algoritmoMemoria.asignarMemoria(procesos, memoriaTotal);

        // Ejecutar procesos concurrentemente
        EjecutorProcesos ejecutor = new EjecutorProcesos(procesos.size()); // Crea un ejecutor de procesos con el tamaño de la lista de procesos
        for (Proceso proceso : procesos) {
            ejecutor.ejecutarProceso(proceso); // Ejecuta cada proceso
        }

        // Esperar a que todos los procesos terminen
        ejecutor.detenerEjecucion();
    }
}
