//Creacion de un thread a traves de la interfaz Runnable
public class PingPongRun extends Thread implements Runnable {

    private String word;
    private int delay;

    @Override
    public void run() {
        while (true) {
            System.out.print(word + " ");
            try {
                sleep(delay);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    //MAIN
    public static void main(String[] args) {
        PingPong t1 = new PingPong("PING", 33);
        PingPong t2 = new PingPong("PONG", 10);

        Thread r1 = new Thread(t1);
        Thread r2 = new Thread(t1);
        t1.start();
        t2.start();
    }
}

