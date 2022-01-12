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
import java.util.Arrays;
import javax.swing.JOptionPane;

public class ArraySearch {
    public static int[] binarySearch(int[] array, int high, int low, int target, int count) {
        if (high >= low) {
            int mid = low + (high - low)/2; //Find the middle ((high-low)/2) then offset for where low is (low + )
            if (array[mid] == target) {
                return new int[]{mid, count};
            }
            else if (array[mid] > target) { //eliminate the right sub-array and continue with the left sub-array
                return binarySearch(array, mid - 1, low, target, count + 1); 
            }
            else { //mid < target, eliminate the left sub-array and continue with the right sub-array
                return binarySearch(array, high, mid + 1, target, count + 1);
            }
        }
        return new int[]{-1, count};
    }

    public static int[] linearSearch(int[] array, int target) {
        int i;
        for (i=0; i < array.length; i++) {
            if (array[i] == target) {
                return new int[]{i, i + 1};
            }
        }
        return new int[]{-1, i + 1};
    }

    public static void main(String[] args) {
        Random randomNum = new Random();
        int [] randArray = new int[10]; //array to random array
        int i = 0;
        while (i < 10)  {  // loop to fill array with random int (1-100)
            randArray[i]= randomNum.nextInt(101);
            // System.out.println(randArray[i]);  
            i++;  
        }
        // add array sorting
        String userInputs = JOptionPane.showInputDialog("Please input a whole number between 1-100");
        // add validation here
        int target = Integer.parseInt(userInputs);
        int[] intArray = new int[] {2,5,7,10,20,24,67,89,90,93,99,112};
        int high = intArray.length - 1;
        target = 67;

        //int[] result = binarySearch(intArray, high, 0, target, 1);
        int[] result = linearSearch(intArray, target);
    
        if (result[0] == -1) {
            System.out.println("Number not found in array");
        }
        else {
            System.out.println("Number found at index " 
                +result[0] + " in " + result[1] +" steps");
        }

    }
}
