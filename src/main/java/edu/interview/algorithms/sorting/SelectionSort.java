package edu.interview.algorithms.sorting;

import edu.interview.algorithms.sorting.utils.Utilities;

/**
 * Implementation of the selection sort algorithm
 *
 * @author Tarek Nawara
 */
public class SelectionSort {
    private SelectionSort() { }

    /**
     * Sort array of comparable elements.
     *
     * @param a target array to sort.
     * @param <T> type of elements in the array.
     */
    public static <T extends Comparable<T>> void sort(T[] a) {
        for (int i = 0; i < a.length; ++i) {
            int minIdx = i;
            for (int j = i; j < a.length; ++j) {
                if (Utilities.less(a[j], a[minIdx])) minIdx = j;
            }
            Utilities.swap(a, i, minIdx);
        }
    }
}
