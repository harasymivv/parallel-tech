package lab1.lab1_task5;

import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockCounter extends Counter {
    private final ReentrantLock lock = new ReentrantLock();
    
    @Override
    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
    
    @Override
    public void decrement() {
        lock.lock();
        try {
            count--;
        } finally {
            lock.unlock();
        }
    }
    
    @Override
    public int getValue() {
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }
}
