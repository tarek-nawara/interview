package edu.interview.datastructures.trees;


import java.util.Optional;

/**
 * The {@code BTree} class represents an ordered symbol table of generic
 * key-value pairs.
 * It supports the <em>put</em>, <em>get</em>, <em>contains</em>, <em>size</em>
 * and <em>is-empty</em> operations
 *
 * @param <Key> the types of keys inside the table, should extends {@code Comparable}
 * @param <Value> the types of values inside the symbolic table.
 *
 * @author Tarek Nawara
 */
public class BTree<Key extends Comparable<Key>, Value> {
    private static final int M = 4;

    private Node root;
    private int height;
    private int n;

    private static final class Node {
        private int m;
        private Entry[] children = new Entry[M];

        private Node(int k) {
            m = k;
        }
    }

    private static final class Entry {
        private Comparable key;
        private final Object val;
        private Node next;

        public Entry(Comparable key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Construct an instance of {@code B-Tree}
     */
    public BTree() {
        root = new Node(0);
    }

    /**
     * Test wither the tree is empty or not.
     *
     * @return true if the tree is empty, false otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Return the number of key-value pairs in the tree.
     *
     * @return number of key
     */
    public int size() {
        return n;
    }

    public int height() {
        return height;
    }

    public Optional<Value> get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        return search(root, key, height);
    }

    private Optional<Value> search(Node x, Key key, int ht) {
        final Entry[] children = x.children;
        if (ht == 0) {
            for (int j = 0; j < x.m; ++j) {
                if (eq(key, children[j].key)) return Optional.of((Value) children[j].val);
            }
        } else {
            for (int j = 0; j < x.m; ++j) {
                if (j + 1 == x.m || less(key, children[j + 1].key))
                    return search(children[j].next, key, ht - 1);
            }
        }
        return Optional.empty();
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("argument key to put() is null");
        Node u = insert(root, key, val, height);
    }

    private Node insert(Node h, Key key, Value val, int ht) {
        int j;
        Entry t = new Entry(key, val, null);
        if (ht == 0) {
            for (j = 0; j < h.m; ++j) {
                if (less(key, h.children[j].key)) break;
            }
        } else {
            for (j = 0; j < h.m; ++j) {
                if ((j + 1 == h.m) || less(key, h.children[j + 1].key)) {
                    Node u = insert(h.children[j++].next, key, val, ht - 1);
                    if (u == null) return null;
                    t.key = u.children[0].key;
                    t.next = u;
                    break;
                }
            }
        }

        for (int i = h.m; i > j; --i) {
            h.children[i] = h.children[i - 1];
        }
        h.children[j] = t;
        h.m++;
        if (h.m < M) return null;
        else return split(h);
    }

    private Node split(Node h) {
        Node t = new Node(M / 2);
        h.m = M / 2;
        for (int j = 0; j < M / 2; ++j) {
            t.children[j] = h.children[M / 2 + j];
        }
        return t;
    }

    private boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private boolean eq(Comparable a, Comparable b) {
        return a.compareTo(b) == 0;
    }

    @Override
    public String toString() {
        return toString(root, height, "") + "\n";
    }

    private String toString(Node h, int ht, String indent) {
        StringBuilder sb = new StringBuilder();
        Entry[] children = h.children;
        if (ht == 0) {
            for (int j = 0; j < h.m; ++j) {
                sb.append(indent + children[j].key + " " + children[j].val + "\n");
            }
        } else {
            for (int j = 0; j < h.m; ++j) {
                if (j > 0) sb.append(indent + "(" + children[j].key + ")\n");
                sb.append(toString(children[j].next, ht - 1, indent + "     "));
            }
        }
        return sb.toString();
    }
}
