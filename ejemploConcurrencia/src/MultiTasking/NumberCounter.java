package MultiTasking;

public class NumberCounter implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count Thread: " + i);
            try {
                Thread.sleep(1000); // Pausa de un segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
