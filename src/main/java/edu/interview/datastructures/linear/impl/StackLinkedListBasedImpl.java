package edu.interview.datastructures.linear.impl;

import edu.interview.datastructures.linear.api.LinkedList;
import edu.interview.datastructures.linear.api.MyStack;

import java.util.Iterator;
import java.util.Optional;

/**
 * Implementation of the stack data structure based on single linked list.
 * <p>
 *     The time and space complexity of all the operations is O(1)
 * </p>
 *
 * @param <T> type of elements in the stack.
 */
public class StackLinkedListBasedImpl<T> implements MyStack<T> {

    private LinkedList<T> list;

    /**
     * Construct a stack.
     */
    public StackLinkedListBasedImpl() {
        list = new SingleLinkedList<>();
    }

    @Override
    public void push(T e) {
        list.add(e, 0);
    }

    @Override
    public T pop() {
        T data = list.apply(0);
        list.remove(0);
        return data;
    }

    @Override
    public T peek() {
        return list.apply(0);
    }

    @Override
    public Optional<T> safePeek() {
        if (list.isEmpty()) return Optional.empty();
        return Optional.of(list.apply(0));
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public T get(int index) {
        return list.apply(index);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        LinkedList<T> cloned = new SingleLinkedList<>();
        cloned.appendAll(this.list);
        cloned.reverse();
        return cloned.iterator();
    }
}
