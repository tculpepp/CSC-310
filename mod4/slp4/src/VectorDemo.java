/*
 * Write a Java program that performs the following tasks:
 * 
 * 1. Declare and create a vector with initial size of 10, increment of 2.
 * 
 * 2. Add two numbers to this vector, test and display the size of the vector.
 * 
 * 3. Add six more numbers to this vector, test and display the size of the vector.
 * 
 * 4. Display all elements in the vector.
 */
import java.util.*;

public class VectorDemo {
    public static void main(String[] args) throws Exception {
        Vector<Integer> integerVector = new Vector<>(10, 2);
        integerVector.add(134);
        integerVector.add(297);
        System.out.println(integerVector.size());
        integerVector.add(134);
        integerVector.add(134);
        integerVector.add(134);
        integerVector.add(134);
        integerVector.add(134);
        integerVector.add(134);
        System.out.println("Hello, World!");
    }
}
