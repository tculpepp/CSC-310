// Java program to find element closest to given target.
import java.util.Random;
class FindClosestNumber {
    public static int binarySearchClosest(int[] array, int target) {

        if(target < array[0]) {
            return array[0];
        }
        if(target > array[array.length-1]) {
            return array[array.length-1];
        }
    
        int low = 0;
        int high = array.length - 1;
        int mid=0;
    
        while (high - low != 1) {
            mid = (high + low) / 2;
    
            if (array[mid] == target) {
                return mid;
            }
            else if (array[mid] > target) { //eliminate the right sub-array and continue with the left sub-array
                high = mid;
            }
            else { //mid < target, eliminate the left sub-array and continue with the right sub-array
                low = mid;
            }
        }
        return Math.abs(array[low] - target) <= Math.abs(target - array[high]) ? array[low] : array[high];
    }
        public static void main(String[] args)
    {
        //int arr[] = { 12, 34, 56, 67, 72, 75, 87, 98 };
        //int target = 68;
        for (int i=0; i <= 10; i++) {
            int[] intArray = selectionSort(new Random().ints(10,0,101).toArray());
            for (int j : intArray) {
                System.out.println(j);
            }
            int target = new Random().nextInt(101);
            System.out.println("target = " +target);
            System.out.println(binarySearchClosest(intArray, target));
            System.out.println("***********************");
    
        }
    }
    //temporary for testing
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
}
