/* 
Write a Java application that performs the following task:

1. Create an int array (you can declare the values yourself, or use the Random feature in java to create this array)
2. Sort the data.
3. Prompt user to input an integer from the keyboard
4. Search for the user input value in the array created in step 1 using a simple linear search.
5. Display a message whether the user input has been found in the array, at what position, and how many steps the program required to search for the data value.
6. Search for the user input value in the array created in step 1 using another (hopefully more efficient) search algorithm.
7. Display a message whether the user input has been found in the array, at what position, and how many steps the program required to search for the data value. 
*/

import java.util.Random;
import javax.swing.JOptionPane;

public class ArraySearch {
    public static void main(String[] args) {
        //create 10 int array between 1-100 and sort it
        int[] intArray = selectionSort(new Random().ints(10,0,101).toArray());
        
        //get target number from user
        int target = userInteraction("Enter a number between 1-100");

        int index = -1; //holds the target index in the array, -1 = not found
        int count = 0; //holds the search step count

        // linear search
        for (int i=0; i < intArray.length; i++) {
            if (intArray[i] == target) {
                count = i + 1;
                index = i;
                break;
            }
        }
        userInteraction(index, count);

        //binary search
        index = -1; //reset the variable to not found
        count = 0; //reset count
        int high = (intArray.length) - 1;
        int low = 0;
        while (high >= low) {
            //Find the middle ((high-low)/2) & offset for where low is (low + )
            int mid = low + (high - low)/2;
            count++;
            if (intArray[mid] == target) {
                index = mid;
                break;
            }
            //eliminate the right sub-array and continue with the left sub-array
            else if (intArray[mid] > target) {
                high = mid - 1;
            }
            else {
                //mid < target, eliminate the left sub-array and
                //continue with the right sub-array
                low = mid + 1;
            }
        }
        userInteraction(index, count);
    }

    private static int[] selectionSort(int[] array) {
        for (int i=0; i < array.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < array[smallest]) {
                    smallest = j;
                }
            }
            int temp = array[smallest];
            array[smallest] = array[i];
            array[i] = temp;
        }
        return array;
    }

    private static int userInteraction (String msg) {
        int target = 0;
        if (target < 1) {
            String userInput = JOptionPane.showInputDialog(msg);
            if (userInput == null) { // Exit cleanly if user hits cancel
                System.exit(0);
            }
            try { //validate the input
                target = Integer.parseInt(userInput);
            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, 
                    "Invalid Input, please try again.");
            }
        }
        return target;
    }

    private static void userInteraction (int index, int count) {
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Number not found in array");
            System.exit(0);
        }
        else {
            JOptionPane.showMessageDialog(null, "Number found at index " 
                + index + " in " + count + " steps");
        }
    }
}
