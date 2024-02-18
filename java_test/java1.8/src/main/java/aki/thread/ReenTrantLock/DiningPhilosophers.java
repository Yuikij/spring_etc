package aki.thread.ReenTrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {
    private static final int NUM_PHILOSOPHERS = 5;
    private static final ReentrantLock[] forks = new ReentrantLock[NUM_PHILOSOPHERS];
    private static final Condition[] forkAvailable = new Condition[NUM_PHILOSOPHERS];

    public static void main(String[] args) {
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new ReentrantLock();
            forkAvailable[i] = forks[i].newCondition();
        }

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            final int philosopherIndex = i;
            Thread philosopherThread = new Thread(() -> {
                while (true) {
                    try {
                        forks[philosopherIndex].lock();
                        while (!forks[(philosopherIndex + 1) % NUM_PHILOSOPHERS].tryLock()) {
                            forkAvailable[philosopherIndex].await();
                        }
                        System.out.println("Philosopher " + philosopherIndex + " is eating");
                        Thread.sleep(1000);
                        forks[(philosopherIndex + 1) % NUM_PHILOSOPHERS].unlock();
                        forkAvailable[(philosopherIndex + 1) % NUM_PHILOSOPHERS].signal();
                        forks[philosopherIndex].unlock();
                        System.out.println("Philosopher " + philosopherIndex + " is thinking");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            philosopherThread.start();
        }
    }
}
