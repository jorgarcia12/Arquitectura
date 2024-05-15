package MultiTasking;

public class CharPrinter implements Runnable {
    @Override
    public void run() {
        char[] chars = {'A', 'B', 'C', 'D', 'E'};
        for (char c : chars) {
            System.out.println("Char Thread: " + c);
            try {
                Thread.sleep(1200); // Pausa de 1.2 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}