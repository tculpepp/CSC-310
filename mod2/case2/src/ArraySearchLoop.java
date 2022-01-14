import java.util.Random;
import javax.swing.JOptionPane;

public class ArraySearchLoop {

    public static int[] selectionSort(int[] array) {
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
    public static void main(String[] args) {
        int[] intArray = new Random().ints(10,0,101).toArray(); //create 10 int array between 1-100

        for (int value : intArray){ //temporary debugging loop
            System.out.println(value);
        }
        //insert sorting code here ******************
        intArray = selectionSort(intArray);
        System.out.println("********************");
        for (int value : intArray){ //temporary debugging loop
            System.out.println(value);
        }   
        // Get and validate user input *****************
        int target = 0; //search target number
        int result = -1; //index of target number
        int count = -1; //search step count
        if (target <= 0) {
            String userInput = JOptionPane.showInputDialog(
                "Please input a number between 1-100");
            if (userInput == null) { // Exit cleanly if user hits cancel
                System.exit(0);
            }
            try {
                target = Integer.parseInt(userInput);
            }
            catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, 
                    "Invalid Input, please try again.");
            }
        }
        // Do Linear Search *************
        for (int i=0; i < intArray.length; i++) {
            if (intArray[i] == target) {
                result = i;
                count = i + 1;
            }
            else if (i == intArray.length) {
                result = -1;
            }
        }
        //display results***************
        if (result == -1) {
            JOptionPane.showMessageDialog(null, "Number not found in array");
            System.exit(0);
        }
        else {
            JOptionPane.showMessageDialog(null, "Number found at index " 
                + result + " in " + count + " steps");
        }
        // Do Binary Search **************
        int high = (intArray.length) - 1;
        int low = 0;
        while (high >= low) {
            int mid = low + (high - low)/2; //Find the middle ((high-low)/2) then offset for where low is (low + )
            count++;
            if (intArray[mid] == target) {
                result = mid;
                break;
            }
            else if (intArray[mid] > target) { //eliminate the right sub-array and continue with the left sub-array
                high = mid - 1;
            }
            else { //mid < target, eliminate the left sub-array and continue with the right sub-array
                low = mid + 1;
            }
            if (high < low) { //if the array runs out without a match
                result = -1;
            }
        }
        JOptionPane.showMessageDialog(null, "Number found at index " 
                + result + " in " + count + " steps");
    }
}
