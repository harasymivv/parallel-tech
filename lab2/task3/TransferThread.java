package lab2.task3;

class Journal {
    private final int[][] grades;
    private final int groups;
    private final int students;
    
    public Journal(int groups, int students) {
        this.groups = groups;
        this.students = students;
        grades = new int[groups][students];
    }
    
    public synchronized void assignGrade(int group, int student, int grade, String grader) {
        grades[group][student] = grade;
        System.out.println(grader + " assigned " + grade + " to student " + (student + 1) + " in group " + (group + 1));
    }
    
    public void displayGrades() {
        System.out.println("Final Grades:");
        for (int i = 0; i < groups; i++) {
            System.out.print("Group " + (i + 1) + ": ");
            for (int j = 0; j < students; j++) {
                System.out.print(grades[i][j] + " ");
            }
            System.out.println();
        }
    }
}