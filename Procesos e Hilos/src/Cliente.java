//Metodo currentThread
public class Cliente extends Thread{
    public void run(){
        Recurso.uso();
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){}
    }
    public class Recurso{
        static synchronized void uso(){
            Thread t =Thread.currentThread();
            System.out.println("Soy "+t.getName());
        }
    }
    //MAIN
    public static void main(String[] args) {
        Cliente juan= new Cliente();
        juan.setName("Juan López");
                Cliente ines= new Cliente();
        ines.setName("Inés García");
                juan.start();
        ines.start();
    }
}
