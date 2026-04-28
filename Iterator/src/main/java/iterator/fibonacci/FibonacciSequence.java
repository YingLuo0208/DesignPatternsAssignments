package iterator.fibonacci;

import java.util.Iterator;

/**
 * FibonacciSequence acts as the "pseudo-collection" in the Iterator pattern.
 * It does NOT store Fibonacci numbers, nor does it hold any calculation state.
 *
 * STATE DECISION:
 * The state (current, previous values and count) is maintained in FibonacciIterator,
 * NOT here in FibonacciSequence. This is a deliberate design choice:
 * - If state were kept here, all iterators created from the same FibonacciSequence
 *   instance would share and interfere with each other's progress.
 * - By keeping state in FibonacciIterator, each call to iterator() produces a
 *   completely independent iterator that starts fresh from the beginning.
 * This mirrors how java.util.ArrayList works: the list itself holds the data,
 * but each iterator() call returns a new, independent iterator object.
 */
public class FibonacciSequence implements Sequence {

    private final int limit;

    /**
     * @param limit how many Fibonacci numbers this sequence will produce
     */
    public FibonacciSequence(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    /**
     * Each call returns a brand-new FibonacciIterator with its own independent state.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(this);
    }
}