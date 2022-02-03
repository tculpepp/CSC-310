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
        this.avg = ((score1 + score2 + score3 + score4) / (double) 4);
        if (this.avg >= 90) {
            this.grade = 'A';
        } else if (this.avg >= 80) {
            this.grade = 'B';
        } else if (this.avg >= 70) {
            this.grade = 'C';
        } else if (this.avg >= 60) {
            this.grade = 'D';
        } else {
            this.grade = 'F';
        }
    }

    public String toString() {
        return ("Name: " + lastName + ", " + firstName + "\n" +
                "Scores: " + score1 + "\t" + score2 + "\t" + score3 + "\t" + score4 + "\n" +
                "Average: " + avg + "\n" +
                "Grade: " + grade + "\n\n");
    }

    private static boolean validateUserInput(String pattern, String userInput,
            String errorMessage) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(userInput);
        if (m.find()) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, errorMessage);
            return false;
        }
    }

    private static String[] getUserInput(String requestMessage, String validationPattern,
            String errorMessage) {
        while (true) {
            String rawUserInput = JOptionPane.showInputDialog(requestMessage);
            if (rawUserInput == null) { // Exit cleanly if user hits cancel
                System.exit(0);
            }
            if (!validateUserInput(validationPattern, rawUserInput, errorMessage)) {
                continue;
            }
            return rawUserInput.split(",(\\s)?");
        }
    }

    public static void main(String[] args) {
        ArrayList<Object> classGrades = new ArrayList<>(10);
        boolean addAnother = true;
        while (addAnother) {
            String[] studentName = getUserInput(
                    "Student Name (Last, First):", "^[A-Za-z]*\\,(\\s)?[A-Za-z]*$",
                    "regex match NOT found for name, please try again");
            String[] scores = getUserInput(
                    "Last 4 Test Scores:\n(01, 02, 03, 04)",
                    "^?\\d{1,3}\\,(\\s)?\\d{1,3}\\,(\\s)?\\d{1,3}\\,(\\s)?\\d{1,3}$",
                    "Invalid entry format please use: 'num, num, num, num'");
            classGrades.add(new Student(studentName[0], studentName[1],
                    Integer.parseInt(scores[0]), Integer.parseInt(scores[1]),
                    Integer.parseInt(scores[2]), Integer.parseInt(scores[3])));
            int reply = JOptionPane.showConfirmDialog(null, "Would you like to calculate more?",
                    "Run Again?", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.NO_OPTION) {
                addAnother = false;
            }
        }
        StringBuilder classReport = new StringBuilder();
        for (Object student : classGrades) {
            classReport.append(student.toString());
        }
        JOptionPane.showMessageDialog(null, classReport);
    }

}
