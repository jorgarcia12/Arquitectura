//Clase con thread autolanzado
public class SelfRun extends Thread implements Runnable {
    private Thread internalThread;
    private boolean noStopRequired;

    public SelfRun() {
        System.out.println("Comienza ejecucion");
        noStopRequired = true;
        internalThread = new Thread(this);
        internalThread.start();
    }

    public void run() {
        while (noStopRequired) {
            System.out.println("En ejecucion");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    public void stopRequest() {
        noStopRequired = false;
        internalThread.interrupt();
    }
//MAIN
    public static void main(String[] args) {
        SelfRun objActivo = new SelfRun();
        try {
            Thread.sleep(2000);

        }catch (InterruptedException e){
        }
        System.out.println("Main invoca stopRequest()");
        objActivo.stopRequest();
    }

}
