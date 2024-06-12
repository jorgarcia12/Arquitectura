package ReentrantLock;

import java.util.List;

public class ConcurrencySimulator {
    public static void main(String[] args) {
        List<Process> processes = List.of(new Process(1), new Process(2), new Process(3));
        ReentrantLockAlgorithm algorithm = new ReentrantLockAlgorithm();
        algorithm.simulate(processes);
    }

}
