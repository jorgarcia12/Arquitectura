//Metodo isAlive()
public class Obrera extends Thread{
    private String resultado = "No calculado";
    public void run(){
        resultado = calcula ();
    }
    private String calcula(){
        try {
            Thread.sleep(10000);
        }catch (InterruptedException e){}
        return "Ya calculado";
    }
    public String getResultado(){
        return resultado;
    }
    //MAIN
    public static void main(String[] args) {
        Obrera agente = new Obrera();
        agente.start();
        while (agente.isAlive())Thread.yield();
        System.out.println(agente.getResultado());
    }
}


