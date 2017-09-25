package edu.interview.datastructures.linear.api;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Immutable List API.
 *
 * @param <T> type of elements held in the container.
 * @author Tarek Nawara
 */
public interface ImmutableList<T> extends Function<Integer, T>, Iterable<T> {

    /**
     * Add element to the head of the list.
     * <p>
     *     This operation is immutable, calling it will return another list without
     *     affecting the underlying list.
     * </p>
     *
     * @param e element to add.
     * @param <U> type of the element to add. should be {@code T} or subtype of {@code T}
     * @return a new list with the given element at its head.
     */
    <U extends T> ImmutableList<T> add(U e);

    /**
     * Test wither the given list is empty or not.
     *
     * @return true if the given list is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Get the element at the given index
     * <p>
     *     If the given index is larger than the size of the underlying list
     *     the default value is returned
     * </p>
     * @param index
     * @return
     */
    T getOrElse(int index, T defaultValue);

    /**
     * Apply a transformation function over the list.
     *
     * @param f transformation function to apply.
     * @param <U> Type of the new list.
     * @return a new list with the transformed elements.
     */
    <U> ImmutableList<U> map(Function<? super T, U> f);

    /**
     * Apply a transformation function over the list
     * <p>
     *     This function will first apply the transformation function
     *     over the list elements, after that will flatten the list
     * </p>
     *
     * @param f transformation function to apply.
     * @param <U> type of the new elements
     * @return a new list after applying the transformation function
     *         and flattening the list.
     */
    <U> ImmutableList<U> flatMap(Function<? super T, ImmutableList<? extends U>> f);

    /**
     * Append the given element to the end of the list.
     *
     * @param e element to append.
     * @return a new list with the new element at the end.
     */
    ImmutableList<T> append(T e);

    /**
     * Append another list to the end of this one.
     *
     * @param other other list to append
     * @return new list with this one at the beginning and {@code other} at the end.
     */
    ImmutableList<T> append(ImmutableList<T> other);

    /**
     * Get the size of the list.
     * <p>
     *     this operation should have O(1) time complexity
     * </p>
     *
     * @return size of the list
     */
    int size();

    /**
     * Apply a predicate over the elements of the list and
     * return a list containing only the elements satisfying the predicate.
     *
     * @param predicate test predicate.
     * @return list of element satisfying the predicate.
     */
    ImmutableList<T> filter(Predicate<? super T> predicate);

    /**
     * Reduce the list to a single element with same type of the zero element.
     *
     * @param zero element to start the reduction with.
     * @param reducer reducer function.
     * @param <U> type of the result.
     * @return the result after the reduction.
     */
    <U> U foldLeft(U zero, BiFunction<? super U, ? super T, U> reducer);

    /**
     * Test wither the list is not empty or not.
     *
     * @return true if the list is not empty, false otherwise.
     */
    default boolean nonEmpty() {
        return !isEmpty();
    }
}
