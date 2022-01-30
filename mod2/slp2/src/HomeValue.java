
/*
 * Write a program for a real estate agent. The program should perform the following tasks:
 * 
 * 1. Create an array to hold average house price for the each of past 25 years for a single family
 * residence of 1500 square feet. Initialize the array with the values in sorted order, assuming the
 * average house price increases each year. Prompt the user for a house value. 2. Use a binary
 * search algorithm to determine the year that most closely matches the house value entered by the
 * user and display the year and average house value for that year.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class HomeValue {
    public static void main(String[] args) throws Exception {
        int[][] homeValuesArr = csvToArray("AveragehomeValues2021-1997.csv");
        String introString = "This program will calculate the ideal home \n" +
                "purchase year between " + homeValuesArr[0][0] + " - "
                + homeValuesArr[homeValuesArr.length - 1][0] +
                ".\nPlease enter your desired price.";
        int target = 0; // placeholder for search target value
        if (target < 1) {
            String userInput = JOptionPane.showInputDialog(introString);
            if (userInput == null) { // Exit cleanly if user hits cancel
                System.exit(0);
            }
            try { // validate the input
                target = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Invalid Input, please try again.");
            }
        }
        int closestYear = binarySearchClosest(homeValuesArr, target);
        JOptionPane.showMessageDialog(null, "The ideal year for you to " +
                "purchase a home was " + closestYear);
    }

    private static int[][] csvToArray(String filename) throws IOException {
        int[][] outArray = new int[25][2]; // array to hold years and avg price
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String currentLine; // current line read
            int i = 0; // counter for line number
            while ((currentLine = br.readLine()) != null) {
                outArray[i][0] = Integer.parseInt(currentLine.split(",")[0]);
                outArray[i][1] = Integer.parseInt(currentLine.split(",")[1]);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outArray;
    }

    public static int binarySearchClosest(int[][] array, int target) {
        if (target < array[0][1]) {
            return array[0][0];
        }
        if (target > array[array.length - 1][1]) {
            return array[array.length - 1][0];
        }
        int low = 0;
        int high = array.length - 1;
        int mid = 0;
        while (high - low != 1) {
            mid = (high + low) / 2;
            if (array[mid][1] == target) {
                return array[mid][0];
                // eliminate the right sub-array and continue with the left sub-array
            } else if (array[mid][1] > target) {
                high = mid;
            } else { // mid < target, eliminate the left sub-array and continue with the right
                     // sub-array
                low = mid;
            }
        }
        // find the difference between target and high vs target and low, return the appropriate
        // index year
        return Math.abs(array[low][1] - target) <= Math.abs(target - array[high][1]) ? array[low][0]
                : array[high][0];
    }
}
