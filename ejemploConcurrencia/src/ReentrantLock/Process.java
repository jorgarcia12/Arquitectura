package ReentrantLock;

public class Process {
    private String id;

    public Process(int id) {
        this.id = String.valueOf(id);
    }

    public int getId() {
        return Integer.parseInt(id);
    }
}
