package iterator.fibonacci;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * FibonacciIterator implements java.util.Iterator<Integer>.
 *
 * STATE DECISION (see also FibonacciSequence):
 * All iteration state is stored here:
 * - prev: the value two steps back
 * - current: the value one step back (next to be returned)
 * - count: how many numbers have been returned so far
 *
 * Keeping state here means:
 * - Multiple iterators from the same FibonacciSequence are fully independent.
 * - FibonacciSequence remains stateless and reusable.
 * - This follows the Single Responsibility Principle: FibonacciSequence defines
 *   "what" the sequence is, FibonacciIterator handles "how" to traverse it.
 */
public class FibonacciIterator implements Iterator<Integer> {

    private final int limit;
    private int prev = 0;
    private int current = 1;  // next value to return (sequence starts at 1, 1, 2, 3...)
    private int count = 0;

    public FibonacciIterator(FibonacciSequence sequence) {
        this.limit = sequence.getLimit();
    }

    /**
     * Returns true if there are still Fibonacci numbers left to produce.
     */
    @Override
    public boolean hasNext() {
        return count < limit;
    }

    /**
     * Returns the next Fibonacci number and advances the internal state.
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Fibonacci sequence limit reached.");
        }

        int result = current;   // the number we will return this call

        int next = prev + current;
        prev = current;
        current = next;
        count++;

        return result;
    }
}