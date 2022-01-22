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
        int[][] homeValues = csvToArray("AverageHomeValues2021-1997.csv");
        int target = 200000;
        int bestYear = binarySearchClosest(homeValues, target);
        System.out.println(bestYear);

    }
    private static int[][] csvToArray(String filename) throws IOException {
        int[][] outArray = new int[25][2];
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String strCurrentLine;
            int i = 0;
            while ((strCurrentLine = br.readLine()) != null) {
                outArray[i][0] = Integer.parseInt(strCurrentLine.split(",")[0]);
                outArray[i][1] = Integer.parseInt(strCurrentLine.split(",")[1]);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outArray;
    }

    public static int binarySearchClosest(int[][] array, int target) {
        if(target < array[0][1]) {
            return array[0][0];
        }
        if(target > array[array.length-1][1]) {
            return array[array.length-1][0];
        }
        int low = 0;
        int high = array.length - 1;
        int mid=0;
        while (high - low != 1) {
            mid = (high + low) / 2;
            if (array[mid][1] == target) {
                return array[mid][0];
            }
            else if (array[mid][1] > target) { //eliminate the right sub-array and continue with the left sub-array
                high = mid;
            }
            else { //mid < target, eliminate the left sub-array and continue with the right sub-array
                low = mid;
            }
        }
        return Math.abs(array[low][1] - target) <= Math.abs(target - array[high][1]) ? array[low][0] : array[high][0];
    }
}    
