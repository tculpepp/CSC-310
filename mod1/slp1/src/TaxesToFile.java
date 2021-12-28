// Write a Java application to accomplish the following task:

// 1. Ask users to input the amount of tax they paid for the past 3 years.
// 2. Write this information to a text file.

// Once you finish the assignment, copy the Java program along with a screenshot of the output and paste it into a Word document. Submit the Word document to the SLP 1 dropbox.

import javax.swing.JOptionPane;
import java.util.Calendar;
import java.io.*;

public class TaxesToFile {
    public static void main(String[] args) throws Exception {
        boolean saveAnother = true; //control to run again or exit
        String userInput; //temporary holding for user input
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);

        while (saveAnother) {
            userInput = JOptionPane.showInputDialog("Enter your taxes paid for " + year + ":");
            //put the taxes into an array here


            File file = new File("taxes_paid.txt")
            file.createNewFile();
            
            FileWriter writer = new FileWriter(file); 
            
            // Writes the content to the file
            writer.write(userInput); 
            writer.flush();
            writer.close();

            saveAnother = false;
        }
    }
}
