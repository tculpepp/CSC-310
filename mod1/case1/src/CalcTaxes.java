// Write a Java application to calculate how much federal and state tax you need to pay. 
// The program should accomplish the following tasks: ask your name, yearly income, federal 
// tax rate, and state tax rate, then calculate and display the amount of tax you need to pay. 
// Your program must catch user input errors. As the examples given above, use a dialog window 
// to enter program input instead of console-based commands.
import javax.swing.JOptionPane;

public class CalcTaxes {
    public static void main(String[] args) throws Exception {
        boolean calcAgain = true; //control to run again or exit
        double yearlyIncome;
        double fedTaxRate;
        double stateTaxRate;
        String username;
        String userInput; //temporary holding for user input

        JOptionPane.showMessageDialog(null, "This program will calculate your federal and state taxes");

        while (calcAgain) {
            userInput = JOptionPane.showInputDialog("Please enter your name:");
            username = userInput;
            // add validation and exception check

            userInput = JOptionPane.showInputDialog("Enter your yearly income?");
            yearlyIncome = Double.parseDouble(userInput);
            // add validation and exception check

            userInput = JOptionPane.showInputDialog("Enter your Federal tax rate (%):");
            fedTaxRate = Double.parseDouble(userInput)/100;
            // add validation and exception check

            userInput = JOptionPane.showInputDialog("Enter your State tax rate (%):");
            stateTaxRate = Double.parseDouble(userInput)/100;
            // add validation and exception check
            
            double fedTaxDue = yearlyIncome * fedTaxRate;
            double stateTaxDue = yearlyIncome * stateTaxRate;

            JOptionPane.showMessageDialog(null, username + "\nYour Federal Taxes are: $" + fedTaxDue + "\nYour State taxes are: $" + stateTaxDue);

            int reply = JOptionPane.showConfirmDialog(null, "Would you like to calculate more?", "title",  JOptionPane.YES_NO_OPTION);
            if (reply != JOptionPane.YES_OPTION) {
                 calcAgain = false;
            }
        }
    }
}
