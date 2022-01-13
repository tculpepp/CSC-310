//this version uses an overloaded function
import java.util.Random;
import javax.swing.JOptionPane;

public class ArraySearch2 {
    public static int[] arraySearch(int[] array, int high, int low, int target, int count) {
        if (high >= low) {
            int mid = low + (high - low)/2; //Find the middle ((high-low)/2) then offset for where low is (low + )
            if (array[mid] == target) {
                return new int[]{mid, count};
            }
            else if (array[mid] > target) { //eliminate the right sub-array and continue with the left sub-array
                return arraySearch(array, mid - 1, low, target, count + 1); 
            }
            else { //mid < target, eliminate the left sub-array and continue with the right sub-array
                return arraySearch(array, high, mid + 1, target, count + 1);
            }
        }
        return new int[]{-1, count};
    }

    public static int[] arraySearch(int[] array, int target) {
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

        int[] result = arraySearch(intArray, high, 0, target, 1);
        result = arraySearch(intArray, target);
    
        if (result[0] == -1) {
            System.out.println("Number not found in array");
        }
        else {
            System.out.println("Number found at index " 
                +result[0] + " in " + result[1] +" steps");
        }

    }
}
