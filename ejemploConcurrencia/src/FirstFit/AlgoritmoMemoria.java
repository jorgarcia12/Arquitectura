package FirstFit;

import java.util.List;

// Interfaz que define el contrato para los algoritmos de asignación de memoria
public interface AlgoritmoMemoria {

    // Método para asignar memoria a procesos según el algoritmo específico
    void asignarMemoria(List<Proceso> procesos, int memoriaTotal);
}
