package edu.interview.algorithms.sorting;

import edu.interview.algorithms.sorting.utils.Utilities;

/**
 * Implementation of insertion sort algorithm.
 *
 * @author Tarek Nawara
 */
public final class InsertionSort {

    // this class shouldn't be instantiated
    private InsertionSort() { }

    /**
     * Sort an array of comparable elements.
     *
     * @param a array to sort
     * @param <T> type of elements in the array.
     */
    public static <T extends Comparable<T>> void sort(T[] a) {
        int n = a.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i; j > 0 && Utilities.less(a[j], a[j - 1]); --j) {
                Utilities.swap(a, j, j - 1);
            }
        }
    }
}
