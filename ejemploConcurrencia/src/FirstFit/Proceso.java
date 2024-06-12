package FirstFit;

public class Proceso {
    private int id; // Identificador único del proceso
    private int memoriaRequerida; // Cantidad de memoria requerida por el proceso
    private int tiempoDeEjecucion; // Tiempo estimado de ejecución del proceso

    // Constructor de la clase Proceso
    public Proceso(int id, int memoriaRequerida, int tiempoDeEjecucion) {
        this.id = id; // Asigna el ID proporcionado al proceso
        this.memoriaRequerida = memoriaRequerida; // Asigna la memoria requerida al proceso
        this.tiempoDeEjecucion = tiempoDeEjecucion; // Asigna el tiempo de ejecución al proceso
    }

    // Método para obtener el ID del proceso
    public int getId() {
        return id; // Devuelve el ID del proceso
    }

    // Método para obtener la cantidad de memoria requerida por el proceso
    public int getMemoriaRequerida() {
        return memoriaRequerida; // Devuelve la memoria requerida por el proceso
    }

    // Método para obtener el tiempo de ejecución del proceso
    public int getTiempoDeEjecucion() {
        return tiempoDeEjecucion; // Devuelve el tiempo de ejecución del proceso
    }
}
