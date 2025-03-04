package lab2.task3;

import java.util.Random;

class Grader implements Runnable {
    private final Journal journal;
    private final String name;
    private final Random random = new Random();
    
    public Grader(Journal journal, String name) {
        this.journal = journal;
        this.name = name;
    }
    
    @Override
    public void run() {
        for (int group = 0; group < 3; group++) {
            for (int student = 0; student < 5; student++) {
                int grade = random.nextInt(101);
                journal.assignGrade(group, student, grade, name);
                try {
                    Thread.sleep(random.nextInt(200));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}