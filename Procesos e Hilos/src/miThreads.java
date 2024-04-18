//Ejemplo de uso de interrupt e interrupted
public class miThreads extends Thread{
    public void run (){
        while (!Thread.interrupted()){
            System.out.println("Ejecuto");
        }
        System.out.println("Termino");
        return;
    }

    public static void main(String[] args) {
        Thread elThread = new MiThread();
        elThread.start();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){}
        elThread.interrupt();
    }
}
