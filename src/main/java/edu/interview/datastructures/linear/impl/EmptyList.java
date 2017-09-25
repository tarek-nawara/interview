package edu.interview.datastructures.linear.impl;

import edu.interview.datastructures.linear.api.ImmutableList;

import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmptyList<T> implements ImmutableList<T> {
    @Override
    public <U extends T> ImmutableList<T> add(U e) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T getOrElse(int index, T defaultValue) {
        return null;
    }

    @Override
    public <U> ImmutableList<U> map(Function<? super T, U> f) {
        return null;
    }

    @Override
    public <U> ImmutableList<U> flatMap(Function<? super T, ImmutableList<U>> f) {
        return null;
    }

    @Override
    public ImmutableList<T> append(T e) {
        return null;
    }

    @Override
    public <U extends T> ImmutableList<T> append(ImmutableList<U> other) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public ImmutableList<T> filter(Predicate<? super T> predicate) {
        return null;
    }

    @Override
    public <U> U foldLeft(U zero, BiFunction<? super U, ? super T, U> reducer) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public T apply(Integer integer) {
        return null;
    }
}
