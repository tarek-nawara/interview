package edu.interview.algorithms.sorting;

import edu.interview.algorithms.sorting.utils.Utilities;

/**
 * Implementation of the three way quick sort algorithm.
 *
 * @author Tarek Nawara
 */
public class ThreeWayQuickSort {

    /**
     * Sort a sequence of elements in ascending order.
     *
     * @param a target array to sort.
     * @param <T> type of elements held in the array.
     */
    public static <T extends Comparable<T>> void sort(T[] a) {
        threeWayQuickSort(a, 0, a.length - 1);
    }

    /* =====================================
        Main implementation of the three
        way quick sort.
       =====================================
     */
    private static <T extends Comparable<T>> void threeWayQuickSort(T[] a, int low, int high) {
        if (high <= low) return;
        int lt = low, gt = high;
        T pivot = a[low];
        int i = low;
        while (i <= gt) {
            int cmp = a[i].compareTo(pivot);
            if (cmp < 0) Utilities.swap(a, lt++, i++);
            else if (cmp > 0) Utilities.swap(a, i, gt--);
            else ++i;
        }
        threeWayQuickSort(a, low, lt - 1);
        threeWayQuickSort(a, gt + 1, high);
        assert(Utilities.isSorted(a, low, high));
    }
}
