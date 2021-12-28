// Write a Java application to accomplish the following task:

// 1. Ask users to input the amount of tax they paid for the past 3 years.
// 2. Write this information to a text file.

// Once you finish the assignment, copy the Java program along with a screenshot of the output and paste it into a Word document. Submit the Word document to the SLP 1 dropbox.

import javax.swing.JOptionPane;
import java.util.Calendar;
import java.util.*;
import java.io.*;

public class TaxesToFile {
    public static void main(String[] args) throws Exception {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        String millisec = String.valueOf(cal.get(Calendar.MILLISECOND));
        boolean saveAnother = true; //control to run again or exit
        int yearsToCollect = 3;

        HashMap<Integer,String> taxesHM=new HashMap<Integer,String>();

        for (int i = 0; i < yearsToCollect; i++) {
            String userInput; //temporary holding for user input
            int currentYear=year-i;
            userInput = JOptionPane.showInputDialog("Enter your taxes paid for " + currentYear + ":");
            taxesHM.put(currentYear, userInput);
        }

        BufferedWriter bf = null;
        File file = new File("TaxesPaid-" + millisec + ".txt"); //create a new file object

        try {

            // create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(file));
            bf.write("Taxes paid:\n");

            // iterate the hashmap
            for (Map.Entry<Integer, String> entry :
                taxesHM.entrySet()) {

                // put key and value separated by a colon
                bf.write(entry.getKey() + ": $" + entry.getValue());

                // new line
                bf.newLine();
            }

            bf.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
            // customize this catch block
        }
        finally {

            try {
                bf.close(); // close the writer when done
            }
            catch (Exception e) {
            }
        }
        JOptionPane.showMessageDialog(null, "Taxes paid saved to: " + file);
    }
}
