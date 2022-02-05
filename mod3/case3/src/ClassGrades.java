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
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Collections;

class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private int score1;
    private int score2;
    private int score3;
    private int score4;
    private Double avg;
    private char grade;

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

    public String getStudentLastName() {
        return lastName;
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

    public static String[] getValidUserInput(String requestMessage, String validationPattern,
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

    @Override // method to sort based on last name
    public int compareTo(Student comparestu) {
        String compareLastName = ((Student) comparestu).getStudentLastName().toLowerCase();
        return this.lastName.toLowerCase().compareTo(compareLastName);
    }
}


public class ClassGrades {
    public static void main(String[] args) {
        ArrayList<Student> classGrades = new ArrayList<>(10); // to hold student objects
        boolean addAnother = true;
        JOptionPane.showMessageDialog(null,
                "This program will collect student names and test scores\n"
                        + "and then report averages and grades for each student.");
        while (addAnother) {
            // regex matches "name, name"
            String[] studentName = Student.getValidUserInput(
                    "Student Name (Last, First):", "^[A-Za-z]*\\,(\\s)?[A-Za-z]*$",
                    "Invalid Entry.\nPlease enter 'Last, First'");
            // regex matches csv format for 4 ints between 0-100
            String[] scores = Student.getValidUserInput(
                    "Last 4 Test Scores:\n(01, 02, 03, 04)",
                    "^?\\d{1,3}\\,(\\s)?\\d{1,3}\\,(\\s)?\\d{1,3}\\,(\\s)?\\d{1,3}$",
                    "Invalid entry format.\nPlease enter only whole numbers separated by commas");
            classGrades.add(new Student(studentName[0], studentName[1],
                    Integer.parseInt(scores[0]), Integer.parseInt(scores[1]),
                    Integer.parseInt(scores[2]), Integer.parseInt(scores[3])));
            int reply =
                    JOptionPane.showConfirmDialog(null, "Would you like to add another student?",
                            "Add Another?", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.NO_OPTION) {
                addAnother = false;
            }
        }
        Collections.sort(classGrades);
        StringBuilder classReport = new StringBuilder(); // create the string for output
        for (Student stud : classGrades) {
            classReport.append(stud.toString());
        }
        JOptionPane.showMessageDialog(null, classReport);
    }
}
