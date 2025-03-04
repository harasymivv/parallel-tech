package lab2.task4;

class CharacterPrinter implements Runnable {
    private final StringBuilder sharedString;
    private final char character;
    private final int repetitions;
    
    public CharacterPrinter(StringBuilder sharedString, char character, int repetitions) {
        this.sharedString = sharedString;
        this.character = character;
        this.repetitions = repetitions;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < repetitions; i++) {
            synchronized (sharedString) {
                sharedString.append(character);
            }
            try {
                Thread.sleep(10); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

