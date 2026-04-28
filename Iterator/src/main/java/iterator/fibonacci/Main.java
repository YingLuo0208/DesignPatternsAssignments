package iterator.fibonacci;

import java.util.Iterator;

/**
 * Demonstrates the Fibonacci sequence generator using the Iterator pattern.
 */
public class Main {
    public static void main(String[] args) {

        // Create a FibonacciSequence that will produce the first 10 numbers
        FibonacciSequence sequence = new FibonacciSequence(10);

        System.out.println("First 10 Fibonacci numbers:");
        Iterator<Integer> iterator = sequence.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // Demonstrate that a second iterator is fully independent of the first
        System.out.println("\nDemonstrating iterator independence (second iterator starts fresh):");
        Iterator<Integer> iterator2 = sequence.iterator();
        while (iterator2.hasNext()) {
            System.out.print(iterator2.next() + " ");
        }
        System.out.println();
    }
}