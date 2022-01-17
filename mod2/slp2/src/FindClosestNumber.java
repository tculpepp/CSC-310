// Java program to find element closest to given target.
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
        //IF (array[low] - value) <= (value - array[high]) {array[low]} ELSE {array[high]}
        return Math.abs(array[low] - target) <= Math.abs(target - array[high]) ? array[low] : array[high];
    }
        public static void main(String[] args)
    {
        int arr[] = { 12, 34, 56, 67, 72, 75, 87, 98 };
        int target = 68;
        System.out.println(binarySearchClosest(arr, target));
    }
}
