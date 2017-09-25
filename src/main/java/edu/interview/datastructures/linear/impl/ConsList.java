package edu.interview.datastructures.linear.impl;

import edu.interview.datastructures.linear.api.ImmutableList;

import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Cons implementation of immutable list
 *
 * @param <T> type of elements held by the container.
 * @author Tarek Nawara
 */
public class ConsList<T> implements ImmutableList<T> {
    private int size;
    private T head;
    private ImmutableList<T> tail;

    /**
     * Construct a Cons list.
     *
     * @param head element at the beginning of the list.
     * @param tail remaining of the list.
     */
    public ConsList(T head, ImmutableList<T> tail) {
        this.head = head;
        this.tail = tail;
        this.size = 1 + tail.size();
    }

    @Override
    public <U extends T> ImmutableList<T> add(U e) {
        return new ConsList<>(e, this);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T getOrElse(int index, T defaultValue) {
        if (index == 0) return head;
        else return tail.getOrElse(index - 1, defaultValue);
    }

    @Override
    public T get(int index) {
        return this.apply(index);
    }

    @Override
    public <U> ImmutableList<U> map(Function<? super T, U> f) {
        return new ConsList<>(f.apply(head), tail.map(f));
    }

    @Override
    public <U> ImmutableList<U> flatMap(Function<? super T, ImmutableList<U>> f) {
        return f.apply(head).append(tail.flatMap(f));
    }

    @Override
    public ImmutableList<T> append(T e) {
        return new ConsList<>(head, tail.append(e));
    }

    @Override
    public <U extends T> ImmutableList<T> append(ImmutableList<U> other) {
        return new ConsList<>(head, tail.append(other));
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableList<T> filter(Predicate<? super T> predicate) {
        if (predicate.test(head)) return new ConsList<>(head, tail.filter(predicate));
        else return tail.filter(predicate);
    }

    @Override
    public <U> U foldLeft(U zero, BiFunction<? super U, ? super T, U> reducer) {
        return tail.foldLeft(reducer.apply(zero, head), reducer);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E> E[] toArray(E[] a) {
        a = (E[]) java.lang.reflect.Array.newInstance(
                a.getClass().getComponentType(), size);
        Object[] result = a;
        Object currentHead = head;
        ImmutableList<?> currentTail = tail;
        int i = 0;
        while (currentTail instanceof ConsList) {
            result[i++] = currentHead;
            currentTail = ((ConsList<?>)currentTail).tail;
            currentHead = ((ConsList<?>)currentTail).head;
        }
        return a;
    }

    @Override
    public Iterator<T> iterator() {
        return new ConsIterator();
    }

    @Override
    public T apply(Integer index) {
        if (index == 0) return head;
        else return tail.apply(index - 1);
    }

    private class ConsIterator implements Iterator<T> {
        private Object[] a = ConsList.this.toArray(new Object[]{});
        private int top = 0;

        @Override
        public boolean hasNext() {
            return top < a.length;
        }

        @Override
        public T next() {
            return (T)a[top++];
        }
    }
}
