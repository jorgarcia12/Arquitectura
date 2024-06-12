package FirstFit;

import java.util.List;

public class FirstFit implements AlgoritmoMemoria {
    // Método para asignar memoria a procesos según el algoritmo First Fit
    public void asignarMemoria(List<Proceso> procesos, int memoriaTotal) {
        int[] memoriaDisponible = new int[memoriaTotal]; // Crea un array para representar la memoria disponible

        // Itera sobre cada proceso
        for (Proceso proceso : procesos) {
            boolean asignado = false; // Variable para verificar si el proceso ha sido asignado a la memoria

            // Itera sobre la memoria disponible para encontrar un lugar adecuado para el proceso
            for (int i = 0; i < memoriaTotal; i++) {
                if (memoriaDisponible[i] == 0 && i + proceso.getMemoriaRequerida() <= memoriaTotal) {
                    // Si encuentra un bloque de memoria contiguo y disponible
                    for (int j = i; j < i + proceso.getMemoriaRequerida(); j++) {
                        memoriaDisponible[j] = proceso.getId(); // Asigna el proceso a los bloques de memoria correspondientes
                    }
                    asignado = true; // Marca el proceso como asignado
                    break; // Sale del bucle interno
                }
            }
            // Si el proceso no puede ser asignado, muestra un mensaje de error
            if (!asignado) {
                System.out.println("No hay suficiente memoria para el proceso " + proceso.getId());
            }
        }

        // Imprime el estado final de la memoria
        System.out.println("Estado final de la memoria:");
        for (int i = 0; i < memoriaTotal; i++) {
            System.out.print(memoriaDisponible[i] + " "); // Imprime el contenido de cada bloque de memoria
        }
        System.out.println(); // Imprime una línea en blanco al final
    }
}
