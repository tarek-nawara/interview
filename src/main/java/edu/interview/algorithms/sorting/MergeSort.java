package edu.interview.algorithms.sorting;

import edu.interview.algorithms.sorting.utils.Utilities;

/**
 * Implementation of merge sort algorithm.
 *
 * @author Tarek Nawara
 */
public class MergeSort {

    /**
     * Sort a sequence of elements in ascending order.
     *
     * @param a target array to sort.
     * @param <T> type of elements held by the given array.
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void sort(T[] a) {
        T[] tmp = (T[]) java.lang.reflect.Array.newInstance(
                a.getClass().getComponentType(), a.length);
        mergeSort(a, tmp, 0, a.length - 1);
    }

    // ==============================
    // Main sorting function
    // ==============================
    private static <T extends Comparable<T>> void mergeSort(T[] a, T[] tmp, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(a, tmp, low, mid);
            mergeSort(a, tmp, mid + 1, high);
            merge(a, tmp, low, mid, high);
        }
    }

    // ===========================================
    // Helper method to merge two sorted arrays
    // ===========================================
    private static <T extends Comparable<T>> void merge(T[] a, T[] tmp, int low, int mid, int high) {
        for (int i = low; i <= high; ++i) {
            tmp[i] = a[i];
        }
        int i = low, j = mid + 1;
        for (int k = low; k <= high; ++k) {
            if (i > mid) a[k] = tmp[j++];
            else if (j > high) a[k] = tmp[i++];
            else if (Utilities.less(tmp[j], tmp[i])) a[k] = tmp[j++];
            else a[k] = tmp[i++];
        }
    }
}
