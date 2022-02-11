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
import java.util.Vector;
import java.util.Random;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<Integer> integerVector = new Vector<>(10, 2);
        addIntToVector(2, integerVector);
        addIntToVector(6, integerVector);
        System.out.println("The elements in the Vector are: " + integerVector);
    }

    private static void addIntToVector(int qtyToAdd, Vector vector) {
        Random rand = new Random();
        for (int i = 0; i < qtyToAdd; i++) {
            vector.add(rand.nextInt(1001));
        }
        System.out.println("The Vector size is: " + vector.size());
    }
}
