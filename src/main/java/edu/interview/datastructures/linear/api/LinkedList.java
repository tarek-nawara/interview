package edu.interview.datastructures.linear.api;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Interface for representing linked lists.
 * <p>
 * Implementations of this interface must be immutable because of the covariant
 * nature of this interface.
 * </p>
 *
 * @param <T> type of element inside the list
 * @author Tarek Nawara
 */
public interface LinkedList<T> extends Function<Integer, T>, Iterable<T> {

    /**
     * Add element to the list.
     *
     * @param e element to add
     */
    <U extends T> void add(U e);

    /**
     * Add element at a given index to the list
     * <p>
     * the element's index will be the given index
     * </p>
     *
     * @param e     element to add
     * @param index index of the added element
     */
    <U extends T> void add(U e, int index);

    /**
     * Remove element from a given index
     *
     * @param index index of the target element
     * @return the removed element
     */
    T remove(int index);

    /**
     * Make the list a complete function.
     * <p>
     * When the list is called with an invalid index this value will
     * be returned if set.
     * </p>
     *
     * @param v default value
     */
    <U extends T> void withDefaultValue(U v);

    /**
     * Get the value at the given index or return the given value
     * if the index is not valid.
     *
     * @param index target index
     * @param v     default value in case of invalid index.
     * @return element at the given index or default value.
     */
    <U extends T> T getOrElse(int index, U v);

    /**
     * Get the size of the list
     *
     * @return size of the list
     */
    int size();

    /**
     * Test if the list is empty.
     *
     * @return true if the list is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Apply a transformation on the given list.
     *
     * @param f   transformation function
     * @param <U> the new type of the elements in the list
     * @return a new list after applying the transformation function.
     */
    <U> LinkedList<U> map(Function<? super T, ? extends U> f);

    /**
     * Apply a transformation over the given list, then flatten the nested
     * lists to a single list.
     *
     * @param f   transformation function.
     * @param <U> type of the new elements after the flatting.
     * @return a new list after applying the transformation and flatting.
     */
    <U> LinkedList<U> flatMap(Function<? super T, LinkedList<? extends U>> f);

    /**
     * Filter the elements in the list based on some criteria.
     *
     * @param predicate filter function.
     * @return list of elements holding this criteria.
     */
    LinkedList<T> filter(Predicate<? super T> predicate);

    /**
     * Append the given value to the end of list.
     * <p>
     * This operation is O(1)
     * </p>
     *
     * @param e element to append
     */
    <U extends T> void append(U e);

    /**
     * Append multiple elements to the end of the list.
     *
     * @param iterable multiple elements to add.
     */
    void appendAll(Iterable<T> iterable);

    /**
     * Reverse the underlying linked list
     */
    void reverse();

    /**
     * Convert the linked list to an array
     *
     * @param array empty array, used to get the type at runtime.
     * @return array containing all the elements of the linked list
     */
    <E> E[] toArray(E[] array);

    /**
     * Test if the list is not empty.
     *
     * @return true if the list is not empty, false otherwise
     */
    default boolean nonEmpty() {
        return !isEmpty();
    }
}
