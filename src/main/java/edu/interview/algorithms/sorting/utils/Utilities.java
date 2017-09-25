package edu.interview.algorithms.sorting.utils;

/**
 * Class holding helper methods for sorting algorithms.
 * <p>
 *     This class is used inside the sorting methods.
 * </p>
 */
public class Utilities {

    /**
     * Swap elements of two target indices in an array.
     *
     * @param a target array
     * @param i first index
     * @param j second index
     */
    public static void swap(Object[] a, int i, int j) {
        Object tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     * Test wither a given element is smaller than other element.
     *
     * @param a target element
     * @param b other element
     * @param <T> type of the two elements, should extends {@code Comparable<T>}
     * @return true if first element is smaller than second element, false otherwise.
     */
    public static <T extends Comparable<T>> boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    /**
     * Test wither a given array is sorted or not.
     *
     * @param a array to test.
     * @param <T> type of elements in the given array.
     * @return true if the array is sorted, false otherwise
     */
    public static <T extends Comparable<T>> boolean isSorted(T[] a) {
        for (int i = 0; i < a.length - 1; ++i) {
            if (a[i].compareTo(a[i + 1]) > 0) return false;
        }
        return true;
    }

    /**
     * Test wither a given slice of an array is sorted or not.
     *
     * @param a target array
     * @param low beginning of the slice inclusive.
     * @param high end of the slice inclusive.
     * @param <T> type of elements held in the array
     * @return true if the slice is sorted, false otherwise.
     */
    public static <T extends Comparable<T>> boolean isSorted(T[] a, int low, int high) {
        for (int i = low; i < high; ++i) {
            if (a[i].compareTo(a[i + 1]) > 0) return false;
        }
        return true;
    }
}
