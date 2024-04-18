//Finalizacion porInterruptedException
public class MiThread extends Thread {

    public void run() {
        while (true) {
            System.out.println("Ejecuto");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Termino en sleep");
            }
            return;
        }
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
