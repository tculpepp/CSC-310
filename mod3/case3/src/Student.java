/*
 * Write a Java program using ArrayList to allow the professor to enter student's names,and four
 * test scores for each student.There should be an option to type"C"when student data entry is
 * complete.Next,display each student's name,average score and letter grade.The output should be
 * sorted by student last name.
 * 
 * Hint:Create a class or data structure hold a student first name, last name, the student's4 test
 * scores, and letter grade. Then create your ArrayList to hold objects of this type.
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.regex.*;

public class Student {
    String firstName;
    String lastName;
    int score1;
    int score2;
    int score3;
    int score4;
    Double avg;
    char grade;

    public Student(String lastName, String firstName, int score1,
            int score2, int score3, int score4) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.score4 = score4;
        calcAvg();
        getGrade();
    }

    void calcAvg() {
        avg = ((this.score1 + this.score2 + this.score3 + this.score4) / (double) 4);
    }

    void getGrade() {
        if (this.avg >= 90) {
            grade = 'A';
        } else if (this.avg >= 80) {
            grade = 'B';
        } else if (this.avg >= 70) {
            grade = 'C';
        } else if (this.avg >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
    }

    public String toString() {
        return ("Name: " + lastName + ", " + firstName + "\n" +
                "Scores: " + score1 + "\t" + score2 + "\t" + score3 + "\t" + score4 + "\n" +
                "Average: " + avg + "\n" +
                "Grade: " + grade + "\n\n");
    }

    public static void main(String[] args) {
        ArrayList<Object> classGrades = new ArrayList<>(10);
        String[] scores = new String[4];
        String[] studentName =
                JOptionPane.showInputDialog("Student Name (Last, First):").split(", ");
        String scoresString =
                JOptionPane.showInputDialog("Last 4 Test Scores:\n(01, 02, 03, 04)");
        Pattern p = Pattern.compile("^?\\d{2}\\,\\s\\d{2}\\,\\s\\d{2}\\,\\s\\d{2}$");
        Matcher m = p.matcher(scoresString);
        if (m.find()) {
            System.out.println("regex match found");
            scores = scoresString.split(", ");
        }
        classGrades.add(new Student(studentName[0], studentName[1], Integer.parseInt(scores[0]),
                Integer.parseInt(scores[1]), Integer.parseInt(scores[2]),
                Integer.parseInt(scores[3])));
        classGrades.add(new Student("Steve", "Jones", 95, 45, 67, 83));
        classGrades.add(new Student("Currey", "Skittrell", 84, 91, 89, 97));
        classGrades.add(new Student("Phip", "Webbe", 81, 68, 51, 94));
        classGrades.add(new Student("Idaline", "Prince", 74, 74, 71, 100));
        classGrades.add(new Student("Deloria", "Leamon", 55, 92, 67, 87));
        classGrades.add(new Student("Ulrikaumeko", "Tosspell", 97, 65, 94, 55));
        classGrades.add(new Student("Lilllie", "Divill", 64, 71, 98, 54));
        classGrades.add(new Student("Alexio", "Jakubovicz", 93, 90, 50, 55));
        classGrades.add(new Student("Faina", "O'Concannon", 95, 89, 84, 96));
        StringBuilder classReport = new StringBuilder();
        for (Object student : classGrades) {
            classReport.append(student.toString());
        }
        JOptionPane.showMessageDialog(null, classReport);
    }

}
