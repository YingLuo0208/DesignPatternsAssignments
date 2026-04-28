package iterator.fibonacci;

import java.util.Iterator;

/**
 * Sequence interface - analogous to the "Aggregate" in the classic Iterator pattern.
 * Renamed to "Sequence" to emphasize that this pattern applies not only to static
 * collections, but also to computed sequences like Fibonacci.
 */
public interface Sequence {
    Iterator<Integer> iterator();
}