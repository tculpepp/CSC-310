// Write a Java application to accomplish the following task:

// 1. Ask users to input the amount of tax they paid for the past 3 years.
// 2. Write this information to a text file.

// Once you finish the assignment, copy the Java program along with a screenshot of the output and paste it into a Word document. Submit the Word document to the SLP 1 dropbox.
/**
* The TaxesToFile program implements an application that
* simply requests taxes paid for a number of years from the
* user and then writes that data out to a file.
*
* Assignment: CSC310 Mod 1 SLP
*
* @author  Thomas Culpepper
* @version 1.0
* @since   2021-12-28
*/

import javax.swing.JOptionPane;
import java.util.Calendar;
// import java.util.*;
import java.util.regex.*;
import java.io.*;
public class TaxesToFile {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        String millisec = String.valueOf(cal.get(Calendar.MILLISECOND)); // added to filename to ensure uniqueness
        String userInput; //temporary holding for user input
        int yearsToCollect = 3; // number fo years of data to collect
        String[] taxesPaidArray = new String[3]; // array to hold user inputs

        // sequentially request taxes paid from the user starting with current year and going backwards as required
        for (int i = 0; i < yearsToCollect; i++) {
            int currentYear=year-i;
            userInput = JOptionPane.showInputDialog("Enter your taxes paid for " + currentYear + ":");
            Pattern p = Pattern.compile("[A-Z,a-z,&%$#@!()*^]"); // allows only 0-9 and .
            Matcher m = p.matcher(userInput);
            //If something other than a number was entered, notify the user and continue
            if (m.find()){ 
                JOptionPane.showMessageDialog(null, "Please enter only a number");
                i--;
                continue;
            }
            taxesPaidArray[i] = (String.valueOf(currentYear) + ": $" + userInput);
        }

        String outfile = ("TaxesPaid-" + millisec + ".txt");
        
        // Open the writer with a transparent buffer to read the array into
        try(Writer writer = new BufferedWriter(new FileWriter(outfile));){
            writer.write("Taxes paid:");
            writer.write(System.lineSeparator());

            for (String i : taxesPaidArray) {
                writer.write(i);
                writer.write(System.lineSeparator());
              }

            writer.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Taxes paid saved to: " + outfile);
    }
}
