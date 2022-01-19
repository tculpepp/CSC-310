/* 
Write a program for a real estate agent. The program should perform the following tasks:

1. Create an array to hold average house price for the each of past 25 years for a single family residence of 1500 square feet. Initialize the array with the values in sorted order, assuming the average house price increases each year.  
   Prompt the user for a house value.
2. Use a binary search algorithm to determine the year that most closely matches the house value entered by the user and display the year and average house value for that year.  
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HomeValue {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        try (BufferedReader br = new BufferedReader(new FileReader("AverageHomeValues2021-1997.csv"))) {

            String strCurrentLine;
            String[][] homeValues = new String[25][];
         
            while ((strCurrentLine = br.readLine()) != null) {
                homeValues[0] = strCurrentLine.split(",");
            }
            for (String i : homeValues[0]){
                System.out.println(i);
            }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}    
