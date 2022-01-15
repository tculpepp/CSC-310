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

    public static int[] binarySearch (int[] array, int target) {
        int high = (array.length) - 1;
        int low = 0;
        int count = 0;
        while (high >= low) {
            int mid = low + (high - low)/2; //Find the middle ((high-low)/2) then offset for where low is (low + )
            count++;
            if (array[mid] == target) {
                return new int[]{mid, count};
            }
            else if (array[mid] > target) { //eliminate the right sub-array and continue with the left sub-array
                high = mid - 1;
            }
            else { //mid < target, eliminate the left sub-array and continue with the right sub-array
                low = mid + 1;
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

    public static int userInteraction (String msg) {
        int target = 0;
        if (target < 1) {
            String userInput = JOptionPane.showInputDialog(msg);
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
        return target;
    }

    public static void userInteraction (int index, int count) {
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Number not found in array");
            System.exit(0);
        }
        else {
            JOptionPane.showMessageDialog(null, "Number found at index " 
                + index + " in " + count + " steps");
        }
    }
    public static void main(String[] args) {
        int[] intArray = selectionSort(new Random().ints(10,0,101).toArray()); //create 10 int array between 1-100

        int target = userInteraction("Enter a number between 1-100"); //search target number

        int[] result = linearSearch(intArray, target);

        userInteraction(result[0], result[1]);

        result = binarySearch(intArray, target);

        userInteraction(result[0],result[1]);
    }
}
