package ProcesosSincronizados;

public class Main {
    public static void main(String[] args) {
        int numFilosofos = 5;
        Cubierto[] cubiertos = new Cubierto[numFilosofos];
        Filosofo[] filosofos = new Filosofo[numFilosofos];


        for (int i = 0; i < numFilosofos; i++) {
            cubiertos[i] = new Cubierto();
        }


        for (int i = 0; i < numFilosofos; i++) {
            Cubierto cubiertoIzquierdo = cubiertos[i];
            Cubierto cubiertoDerecho = cubiertos[(i + 1) % numFilosofos];
            filosofos[i] = new Filosofo(i, cubiertoIzquierdo, cubiertoDerecho);
            filosofos[i].start();
        }
    }
}

