//Metodo JOIN

public class Obreras extends Thread{
    private String resultado = "No calculado";

    public void run() {
        resultado = calcula();
    }

    private String calcula() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
        return "Ya calculado";
    }

    public String getResultado() {
        return resultado;
    }

    public static void main(String[] args) {
        Obreras agente = new Obreras();
        agente.start();
        try {
            agente.join();
        }catch (InterruptedException e){};
        System.out.println(agente.getResultado());
    }
}
