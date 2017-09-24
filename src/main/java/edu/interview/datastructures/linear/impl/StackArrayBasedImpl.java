package edu.interview.datastructures.linear.impl;

import edu.interview.datastructures.linear.api.MyStack;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;

/**
 * Array based implementation of the stack data structure.
 * <p>
 *     In case of reaching the stack size we resize the stack
 *     by doubling its size.
 *     <t>The Amortized running time of all the operations is O(1)</t>
 * </p>
 *
 * @param <T> type of elements inside the stack.
 */
public class StackArrayBasedImpl<T> implements MyStack<T> {
    private int capacity = 100;
    private Object[] a = new Object[capacity];
    private int top = -1;

    /**
     * Stack Iterator.
     * <p>
     *     This iterator copies the entire stack to protect the
     *     iteration process from modifications of the stack at iteration time.
     * </p>
     */
    private class StackArrayBasedImplIterator implements Iterator<T> {
        private Object[] cloned = new Object[a.length];
        private int index = 0;

        StackArrayBasedImplIterator() {
            System.arraycopy(a, 0, cloned, 0, a.length - 1);
        }

        @Override
        public boolean hasNext() {
            return index < cloned.length;
        }

        @Override
        public T next() {
            return (T) cloned[index++];
        }
    }

    @Override
    public void push(T e) {
        ++top;
        if (top == capacity) this.resize();
        a[top] = e;
    }

    @Override
    public T pop() {
        assert(top >= 0);
        return (T) a[top--];
    }

    @Override
    public T peek() {
        assert(top >= 0);
        return (T) a[top];
    }

    @Override
    public Optional<T> safePeek() {
        if (top < 0) return Optional.empty();
        return Optional.of((T)a[top]);
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public T get(int index) {
        assert(index >= 0 && index <= top);
        return (T) a[index];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackArrayBasedImplIterator();
    }

    private void resize() {
        this.capacity *= 2;
        Object[] tmp = a;
        this.a = new Object[this.capacity];
        for (int i = 0; i < tmp.length; ++i) {
            a[i] = tmp[i];
        }
    }

    @Override
    public String toString() {
        return "StackArrayBasedImpl{" +
                "capacity=" + capacity +
                ", a=" + Arrays.toString(a) +
                ", top=" + top +
                '}';
    }
}
