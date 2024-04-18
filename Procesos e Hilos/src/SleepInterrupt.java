//interrupcion durante sleep
public class SleepInterrupt implements Runnable{

    public void run() {
        try {
            System.out.println("in run(): me duermo 20s");
            Thread.sleep(20000);
            System.out.println("in run (): me despierto ");
        }catch (InterruptedException e){
            System.out.println("in run (): interrumpida en sleep");
            return;
        }
        System.out.println("in run (): fin normal");
    }

    public static void main(String[] args) {
        SleepInterrupt si = new SleepInterrupt();
        Thread t = new Thread(si);
        t.start();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){}
        System.out.println("in main (): Interrumpo a t");
        t.interrupt();
        System.out.println("in main(): termina");
    }
}
