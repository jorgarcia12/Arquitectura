package ReentrantLock;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockAlgorithm {
    private final Lock lock = new ReentrantLock();

    public void simulate(List<Process> processes) {
        lock.lock();
        try {
            for (Process process : processes) {
                System.out.println("Procesando: " + process.getId());
            }
        } finally {
            lock.unlock();
        }

    }
}