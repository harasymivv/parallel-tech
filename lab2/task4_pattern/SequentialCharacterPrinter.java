package lab2.task4_pattern;

class SequentialCharacterPrinter implements Runnable {
    private final Object lock;
    private final char character;
    private static int currentTurn = 0;
    private final int threadId;
    private final int totalThreads;
    private final StringBuilder sharedString;

    public SequentialCharacterPrinter(Object lock, char character, int threadId, int totalThreads, StringBuilder sharedString) {
        this.lock = lock;
        this.character = character;
        this.threadId = threadId;
        this.totalThreads = totalThreads;
        this.sharedString = sharedString;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (lock) {

                while (currentTurn % totalThreads != threadId) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }

                sharedString.append(character);

                currentTurn++;

                lock.notifyAll();
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
