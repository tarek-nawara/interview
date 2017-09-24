package edu.interview.datastructures.linear.impl;

import edu.interview.datastructures.linear.api.LinkedList;

import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Implementation of the linked list using single pointer to the node
 * next to you.
 *
 * @param <T> type of elements in the container.
 */
public class SingleLinkedList<T> implements LinkedList<T>, Cloneable {

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this(data, null);
        }

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private class SingleLinkedListIterator implements Iterator<T> {
        SingleLinkedList<T> cloned = null;
        Node current;

        SingleLinkedListIterator() {
            cloned = new SingleLinkedList<>();
            Node listHead = SingleLinkedList.this.head;
            while (listHead != null) {
                cloned.append(listHead.data);
                listHead = listHead.next;
            }
            current = cloned.head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T data = current.data;
            current = current.next;
            return data;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new SingleLinkedListIterator();
    }

    private Node head;
    private Node tail;
    private int size;
    private T defaultValue;

    @Override
    public <U extends T> void add(U e) {
        Node prevHead = head;
        head = new Node(e, head);
        if (prevHead == null) tail = head;
        ++size;
    }

    @Override
    public <U extends T> void add(U e, int index) {
        assert(index >= 0 && index <= size);
        if (index == 0) {
            this.add(e);
            return;
        }
        Node current = this.getNode(index - 1);
        current.next = new Node(e, current.next);
        ++size;
        if (index == size - 1) tail = current.next;
    }

    @Override
    public T remove(int index) {
        assert(index >= 0 && index < size);
        Node current = this.getNode(index - 1);
        T data = current.next.data;
        current.next = current.next.next;
        --size;
        if (index == size) tail = this.getNode(size - 1);
        return data;
    }

    @Override
    public <U extends T> void withDefaultValue(U v) {
        this.defaultValue = v;
    }

    @Override
    public <U extends T> T getOrElse(int index, U v) {
        assert(index >= 0);
        if (index >= size) return v;
        Node current = this.getNode(index);
        return current.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public <U> LinkedList<U> map(Function<? super T, ? extends U> f) {
        LinkedList<U> newList = new SingleLinkedList<>();
        Node current = head;
        for (int i = 0; i < size; ++i) {
            newList.append(f.apply(current.data));
            current = current.next;
        }
        return newList;
    }

    @Override
    public <U> LinkedList<U> flatMap(Function<? super T, LinkedList<? extends U>> f) {
        LinkedList<U> newList = new SingleLinkedList<>();
        Node current = head;
        for (int i = 0; i < size; ++i) {
            for (U elem : f.apply(current.data)) {
                newList.append(elem);
            }
            current = current.next;
        }
        return newList;
    }

    @Override
    public LinkedList<T> filter(Predicate<? super T> predicate) {
        LinkedList<T> newList = new SingleLinkedList<>();
        for (T e : this) {
            if (predicate.test(e)) newList.append(e);
        }
        return newList;
    }

    @Override
    public <U extends T> void append(U e) {
        Node newNode = new Node(e);
        if (tail != null) {
            tail.next = newNode;
            tail = newNode;
        } else {
            tail = newNode;
            head = newNode;
        }
        ++size;
    }

    @Override
    public void appendAll(Iterable<T> iterable) {
        for (T e : iterable) this.append(e);
    }

    @Override
    public T apply(Integer index) {
        assert(index >= 0);
        return this.getOrElse(index, defaultValue);
    }

    private Node getNode(int index) {
        assert(index >= 0 && index < size);
        Node current = head;
        for (int i = 0; i < index; ++i)
            current = current.next;
        return current;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        LinkedList<T> cloned = (LinkedList<T>) super.clone();
        cloned.appendAll(this);
        return cloned;
    }
}
