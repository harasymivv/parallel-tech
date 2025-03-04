package lab2.task1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.atomic.AtomicLong;

class Bank {
    public static final int NTEST = 10000;
    private final int[] accounts;
    private long ntransacts = 0;
    private final AtomicLong atomicNtransacts = new AtomicLong(0);
    private final Lock bankLock = new ReentrantLock();
    private boolean usingAtomicTransfer = false;

    public Bank(int n, int initialBalance) {
        accounts = new int[n];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = initialBalance;
        }
    }

    // Standard method 
    public void transfer(int from, int to, int amount) {
        accounts[from] -= amount;
        accounts[to] += amount;
        ntransacts++;
        if (ntransacts % NTEST == 0)
            test();
    }

    // synchronized
    public synchronized void transferSync(int from, int to, int amount) {
        if (accounts[from] < amount) return; // Prevent overdraft
        accounts[from] -= amount;
        accounts[to] += amount;
        ntransacts++;
        if (ntransacts % NTEST == 0)
            test();
    }

    // Reentrant Lock
    public void transferLock(int from, int to, int amount) {
        bankLock.lock();
        try {
            if (accounts[from] < amount) return;
            accounts[from] -= amount;
            accounts[to] += amount;
            ntransacts++;
            if (ntransacts % NTEST == 0)
                test();
        } finally {
            bankLock.unlock();
        }
    }

    // Atomic Variables
    public void transferAtomic(int from, int to, int amount) {
        usingAtomicTransfer = true;
        synchronized (this) {
            if (accounts[from] < amount) return;
            accounts[from] -= amount;
            accounts[to] += amount;
        }
        atomicNtransacts.incrementAndGet();
        if (atomicNtransacts.get() % NTEST == 0)
            test();
    }

    public synchronized void test() {
        int sum = 0;
        for (int account : accounts)
            sum += account;
        
        long transactionCount;
        if (usingAtomicTransfer) {
            transactionCount = atomicNtransacts.get();
        } else {
            transactionCount = ntransacts;
        }
        
        System.out.println("Transactions: " + transactionCount + " Sum: " + sum);
    }

    public int size() {
        return accounts.length;
    }
}

