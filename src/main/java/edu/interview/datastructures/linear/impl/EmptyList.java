package edu.interview.datastructures.linear.impl;

import edu.interview.datastructures.linear.api.ImmutableList;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Implementation of empty list.
 *
 * @param <T> type of pointer pointing to that list
 */
public class EmptyList<T> implements ImmutableList<T> {
    @Override
    public <U extends T> ImmutableList<T> add(U e) {
        return new ConsList<>(e, this);
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public T getOrElse(int index, T defaultValue) {
        return defaultValue;
    }

    @Override
    public T get(int index) {
        throw new NoSuchElementException();
    }

    @Override
    public <U> ImmutableList<U> map(Function<? super T, U> f) {
        return new EmptyList<>();
    }

    @Override
    public <U> ImmutableList<U> flatMap(Function<? super T, ImmutableList<U>> f) {
        return new EmptyList<>();
    }

    @Override
    public ImmutableList<T> append(T e) {
        return new ConsList<>(e, this);
    }

    @Override
    public ImmutableList<T> append(ImmutableList<T> other) {
        return other;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public ImmutableList<T> filter(Predicate<? super T> predicate) {
        return this;
    }

    @Override
    public <U> U foldLeft(U zero, BiFunction<? super U, ? super T, U> reducer) {
        return zero;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E> E[] toArray(E[] a) {
        return (E[])java.lang.reflect.Array.newInstance(
                a.getClass().getComponentType(), 0);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                throw new NoSuchElementException();
            }
        };
    }

    @Override
    public T apply(Integer integer) {
        throw new NoSuchElementException();
    }
}
