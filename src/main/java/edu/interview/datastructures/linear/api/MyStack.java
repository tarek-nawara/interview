package edu.interview.datastructures.linear.api;

import java.util.Optional;

/**
 * Interface to define the needed operations for a stack.
 * <p>
 *     All the stack operations should be O(1) time and space complexity.
 * </p>
 *
 * @param <T> type of elements inside the stack
 */
public interface MyStack<T> extends Iterable<T> {

    /**
     * Push element on top of the stack.
     *
     * @param e element to push
     */
    void push(T e);

    /**
     * Remove and return the top element of the stack.
     *
     * @return top element on the stack.
     */
    T pop();

    /**
     * Get the top element on the stack.
     * <p>
     *     In case empty stack will {@throw IndexOutOfBoundException}
     * </p>
     *
     * @return top element on the stack.
     */
    T peek();

    /**
     * Get the top element on the stack.
     *
     * @return top element on the stack or {@code Optional.empty} in case of empty stack.
     */
    Optional<T> safePeek();

    /**
     * Return the size of the stack.
     *
     * @return size of the stack.
     */
    int size();

    /**
     * Get element in the stack at the given index.
     *
     * @param index target index.
     * @return element at the target index.
     */
    T get(int index);

    /**
     * Test wither the stack is empty or not.
     *
     * @return true if stack is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * test wither stack is not empty or not.
     *
     * @return true if stack is not empty, false otherwise.
     */
    default boolean nonEmpty() {
        return !isEmpty();
    }
}
