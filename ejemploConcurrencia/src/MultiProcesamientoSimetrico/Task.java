package MultiProcesamientoSimetrico;

public class Task implements Runnable {
    private int id;

    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Task " + id + " is running on " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000); // Simulamos una "Tarea pesada"
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + id + " has finished.");
    }
}
