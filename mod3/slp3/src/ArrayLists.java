/*
 * Write a Java program that inserts 25 random integers ranging from 0 to 100 into an ArrayList in
 * ascending order. The program should then output the numbers and display the sum and average of
 * the numbers.
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class ArrayLists {
    public static void main(String[] args) {
        // random int stream boxed to integer and loaded into ArrayList
        ArrayList<Integer> randomIntegers = new Random().ints(10, 0, 100).boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> sortedInts = selectionSort(randomIntegers);
        System.out.println("done");
    }

    private static ArrayList<Integer> selectionSort(ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size() - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < arrayList.size(); j++) {
                if (arrayList.get(j) < arrayList.get(smallest)) {
                    smallest = j;
                }
            }
            int temp = arrayList.get(smallest);
            arrayList.set(smallest, arrayList.get(i));
            arrayList.set(i, temp);
        }
        return arrayList;
    }
}


