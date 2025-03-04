package lab2.task4;

class PrinterChar implements Runnable {
    private final char character;
    private final int repetitions;

    public PrinterChar(char character, int repetitions) {
        this.character = character;
        this.repetitions = repetitions;
    }

    @Override
    public void run() {
        for (int i = 0; i < repetitions; i++) {
            System.out.print(character);
            try {
                Thread.sleep(10); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
