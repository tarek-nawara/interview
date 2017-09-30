package edu.interview.algorithms.searching;

/**
 * Logic for finding elements in an Iterable container
 *
 * @author Tarek Nawara
 */
public class LinearSearch {

    /**
     * Test if a target container contains element or not.
     *
     * @param iterable target container
     * @param e target element
     * @param <T> type of elements held by the container
     * @return true if target element is contained in the container, false otherwise
     */
    public static <T> boolean contains(Iterable<T> iterable, T e) {
        for (T x : iterable)
            if (x.equals(e)) return true;
        return false;
    }

    /**
     * Get the index of a target element in a given container.
     *
     * @param iterable target container
     * @param e target element
     * @param <T> type of elements held by the container
     * @return index of target element or {@code -1} if not found
     */
    public static <T> int indexOf(Iterable<T> iterable, T e) {
        int i = 0;
        for (T x : iterable) {
            if (x.equals(e)) return i;
            ++i;
        }
        return -1;
    }
}
