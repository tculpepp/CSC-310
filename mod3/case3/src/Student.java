/*
 * Write a Java program using ArrayList to allow the professor to enter student's names,and four
 * test scores for each student.There should be an option to type"C"when student data entry is
 * complete.Next,display each student's name,average score and letter grade.The output should be
 * sorted by student last name.
 * 
 * Hint:Create a class or data structure hold a student first name, last name, the student's4 test
 * scores, and letter grade. Then create your ArrayList to hold objects of this type.
 */
import java.lang.Math;

public class Student {
    String firstName;
    String lastName;
    int score1;
    int score2;
    int score3;
    int score4;
    Double avg;
    char grade;

    public Student(String firstName, String lastName, int score1,
            int score2, int score3, int score4) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.score4 = score4;
    }

    void calcAvg() {
        avg = ((this.score1 + this.score2 + this.score3 + this.score4) / (double) 4);
    }

    void getGrade() {
        if (this.avg > 89) {
            grade = 'A';
        } else if (this.avg < 90 && this.avg > 79) {
            grade = 'B';
        } else if (this.avg < 80 && this.avg > 69) {
            grade = 'C';
        } else if (this.avg < 70 && this.avg > 59) {
            grade = 'D';
        } else if (this.avg < 60) {
            grade = 'F';
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("steve", "jones", 95, 45, 67, 83);
        student1.calcAvg();
        student1.getGrade();
        System.out.println(student1.toString());
    }

}
