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

    public static int binarySearch(int arr[], int first, int last, int key){  
        if (last>=first){  
            int mid = first + (last - first)/2;  
            if (arr[mid] == key){  
            return mid;  
            }  
            if (arr[mid] > key){  
            return binarySearch(arr, first, mid-1, key);//search in left subarray  
            }else{  
            return binarySearch(arr, mid+1, last, key);//search in right subarray  
            }  
        }  
        return -1;  
    }  
    // this code was copy pasta'd
    public static void main(String[] args) {
        Random randomNum = new Random();

        int [] randArray = new int[10]; //array to random array
        int i = 0;
        while (i < 10)  {  // loop to fill array with random int (1-100)
            randArray[i]= randomNum.nextInt(101);
            System.out.println(randArray[i]);  
            i++;  
        }
        String userInputs = JOptionPane.showInputDialog("Please input a whole number between 1-100");
        // add validation here
        int userInt = Integer.parseInt(userInputs);

        // JOptionPane.showMessageDialog(
        //     null, "You input: "+ userInt);

        // System.out.println("i = "+i); 

        // // write the search as a function and the output with the result
        // for (i=0; i < randArray.length; i++) {
        //     if (randArray[i] != userInt) {
        //         System.out.println("Array: " + randArray[i] + " : target: " + userInt); //this is temporary
        //     }
        //     else if (randArray[i] == userInt) {
        //         i++;
        //         JOptionPane.showMessageDialog(
        //             null, "Your number was found in the array. It took "
        //             + i + " steps using a linear search");
        //     }
        //     else {
        //         JOptionPane.showMessageDialog(
        //             null, "something went wrong");
        //     }
        // }

        //  binary search code here *************
        int low = 0;
        int high = randArray.length;
        int mid = Math.floorDiv((low + high), 2);
        int midValue = randArray[mid];
        int count = 0;
        System.out.println("low: " + low);
        System.out.println("high: " + high);
        System.out.println("mid: " + mid);
        System.out.println("midValue: " + midValue);
        
    }
}
