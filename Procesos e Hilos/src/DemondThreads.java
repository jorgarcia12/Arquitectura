//Ejemplo de Thread user
public class DemondThreads implements Runnable {
    public void run() {
        System.out.println("Comienza run()");
        try {
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }

                System.out.println("run() ha despertado");
            }
        } finally {
            System.out.println("Termina run()");
        }
    }

    public static void main(String[] args) {
        System.out.println("Comienza main()");
        Thread t =new Thread(new DaemondThread());
        t.setDaemon(true);
        t.start();
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){}
        System.out.println("Termina main()");
    }
}
