package lab2.task3;

public class GroupJournalThreads {
    public static void main(String[] args) {
        Journal journal = new Journal(3, 5);
        
        Thread lecturer = new Thread(new Grader(journal, "Lecturer"));
        Thread assistant1 = new Thread(new Grader(journal, "Assistant 1"));
        Thread assistant2 = new Thread(new Grader(journal, "Assistant 2"));
        Thread assistant3 = new Thread(new Grader(journal, "Assistant 3"));
        
        lecturer.start();
        assistant1.start();
        assistant2.start();
        assistant3.start();
        
        try {
            lecturer.join();
            assistant1.join();
            assistant2.join();
            assistant3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        journal.displayGrades();
    }
}
