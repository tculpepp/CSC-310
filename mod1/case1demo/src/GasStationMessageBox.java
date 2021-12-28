import javax.swing.JOptionPane; // Needed for the Scanner class

    public class GasStationMessageBox
    {
        public static void main(String[] args)
        {
            String custInput;// To hold the user's input
            char gasGrade; // choice of gas
            double unleadPrice = 2.6;
            double regularPrice = 3.2;
            double premPrice = 3.8;
            double total = 0.0;
            boolean moreOrder = true;
            //Prompt the price for the gas
            JOptionPane.showMessageDialog(null, "Three kinds of gas available: \n" + "Unlead: $"+ unleadPrice);

        while (moreOrder)
        {
            custInput = JOptionPane.showInputDialog("Press U for unlead, R for regular, and P for premium");
            gasGrade = custInput.charAt(0);
            
            if (gasGrade == 'U'|| gasGrade == 'u')
            {
                custInput = JOptionPane.showInputDialog("How many gallons of gas you want to purchase? ");
                total = unleadPrice * Double.parseDouble(custInput);
                JOptionPane.showMessageDialog(null,"Total is $" + total + ". Thank you for your business");
            }
            else if (gasGrade == 'R'|| gasGrade =='r')
            {
                custInput = JOptionPane.showInputDialog("How many gallons of gas you want to purchase? total = regularPrice * Double.parseDouble(custInput");
                JOptionPane.showMessageDialog(null,"Total is $" + total + ". Thank you for your business");
            }
            else if (gasGrade == 'P'|| gasGrade == 'p')
            {
                custInput = JOptionPane.showInputDialog("How many gallons of gas you want to purchase?");
                total = premPrice * Double.parseDouble(custInput);
                JOptionPane.showMessageDialog(null,"Total is $" + total + ". Thank you for your business");
            }
            else if (gasGrade == 'E'|| gasGrade =='e')
            {
                JOptionPane.showMessageDialog(null, "Thanks for your business. See you next time");
                moreOrder = false;
            }
            else
                JOptionPane.showMessageDialog(null, "Invalid choice, try again. ");
            }
}
}