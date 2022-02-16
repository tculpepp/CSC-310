/*
 * 1. Create and populate a LinkedList using a one dimensional array.
 * 
 * 2. Add 6 numbers to this LinkedList.
 * 
 * 3. Search this LinkedList and find the smallest number.
 * 
 * 4. Display the number you get from step 3.
 */

import java.util.Random;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LinkedListDemo {
    public static void main(String[] args) {
        int[] intArray = (new Random().ints(10, 0, 1001).toArray());
        List<Integer> intLinkedList = new LinkedList<>();
        // populate with the random array
        intLinkedList = Arrays.stream(intArray).boxed()
                .collect(Collectors.toList());
        addIntToLinkedList(6, intLinkedList);
        // Added this print to validate the list values
        System.out.println(intLinkedList);
        // find the smallest element
        Integer smallestElement = intLinkedList.get(0);
        for (Integer element : intLinkedList) {
            if (element < smallestElement) {
                smallestElement = element;
            }
        }
        System.out.println("The smallest number in the LinkedList is: "
                + smallestElement);
    }

    private static void addIntToLinkedList(int qtyToAdd, List<Integer> linkedList) {
        Random rand = new Random();
        for (int i = 0; i < qtyToAdd; i++) {
            linkedList.add(rand.nextInt(1001));
        }
    }
}
