/* 
* Write a Java application to calculate how much federal and state tax you need to pay. 
* The program should accomplish the following tasks: ask your name, yearly income, federal 
* tax rate, and state tax rate, then calculate and display the amount of tax you need to pay. 
* Your program must catch user input errors. As the examples given above, use a dialog window 
* to enter program input instead of console-based commands.
 */

 /**
* The CalcTaxes program implements an application that requests tax information 
* from the user and then calculates taxes due.
*
* Assignment: CSC310 Mod 1 Case
*
* @author  Thomas Culpepper
* @version 1.0
* @since   2021-12-28
*/
import javax.swing.JOptionPane;
import java.util.regex.*;

public class CalcTaxes {
    public static void main(String[] args) {
        boolean calcAgain = true; //control to run again or exit

        JOptionPane.showMessageDialog(null, "This program will calculate your federal and state taxes");

        while (calcAgain) {
            String validationPattern = null;
            String errorMessage = null;
            String[] userInputs = new String[4]; //array to hold input strings
            String[][] inputRequests = {
                {"Please enter your name:","str"},
                {"Enter your yearly income","num"},
                {"Enter your Federal tax rate (%):","num"},
                {"Enter your State tax rate (%):","num"}
            };
            for (int i=0; i < inputRequests.length; i++) {
                userInputs[i] = JOptionPane.showInputDialog(inputRequests[i][0]);
                if (userInputs[i] == null) { // Exit cleanly if user hits cancel
                    System.exit(0);
                }
                else if (inputRequests[i][1].equals("num")){
                    validationPattern = "[A-Za-z&%$#@!()*^, ]"; // allows only numbers plus , .
                    errorMessage = "Please enter a number";
                }
                else if (inputRequests[i][1].equals("str")) {
                    validationPattern = "[0-9&%$#@!()*^]"; // allows only letters and spaces
                    errorMessage = "No numbers or special characters please";
                }
                else {
                    JOptionPane.showMessageDialog(null, "Illegal Input type Option. Please contact the developer.");
                    throw new IllegalArgumentException("Input type option invalid. Only 'num' or 'str' allowed");
                }
                Pattern p = Pattern.compile(validationPattern);
                Matcher m = p.matcher(userInputs[i]);
                if (m.find() || userInputs[i].isBlank()){ 
                    JOptionPane.showMessageDialog(null, errorMessage);
                    i--;
                }
            }

            double yearlyIncome = Double.parseDouble(userInputs[1]);
            double fedTaxRate = Double.parseDouble(userInputs[2]) / 100;
            double stateTaxRate = Double.parseDouble(userInputs[3]) / 100;
            double fedTaxDue = yearlyIncome * fedTaxRate;
            double stateTaxDue = yearlyIncome * stateTaxRate;

            JOptionPane.showMessageDialog(null, userInputs[0] + "\nYour Federal Taxes are: $" + fedTaxDue + "\nYour State taxes are: $" + stateTaxDue);

            int reply = JOptionPane.showConfirmDialog(null, "Would you like to calculate more?", "Run Again?",  JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.NO_OPTION) {
                    calcAgain = false;
            }
        }
    } 
}
