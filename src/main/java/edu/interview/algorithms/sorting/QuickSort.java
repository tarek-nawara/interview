package edu.interview.algorithms.sorting;

import edu.interview.algorithms.sorting.utils.Utilities;

/**
 * Implementation of the quick sort algorithm.
 *
 * @author Tarek Nawara
 */
public class QuickSort {

    /**
     * Sort a sequence of elements in ascending order.
     *
     * @param a target array to sort
     * @param <T> type of elements held by the array.
     */
    public static <T extends Comparable<T>> void sort(T[] a) {
        quickSort(a, 0, a.length - 1);
    }

    /* ===========================
        Main sorting function
       ===========================
     */
    private static <T extends Comparable<T>> void quickSort(T[] a, int low, int high) {
        if (low < high) {
            int p = partition(a, low, high);
            quickSort(a, low, p - 1);
            quickSort(a, p + 1, high);
            assert(Utilities.isSorted(a, low, high));
        }
    }

    /* =======================================
        partition array based on some pivot
       =======================================
     */
    private static <T extends Comparable<T>> int partition(T[] a, int low, int high) {
        T pivot = a[high];
        int pIndex = low;
        for (int i = low; i <= high; ++i) {
            if (Utilities.less(a[i], pivot))
                Utilities.swap(a, i, pIndex++);
        }
        Utilities.swap(a, high, pIndex);
        return pIndex;
    }
}
