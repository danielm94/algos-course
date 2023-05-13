package queues;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> head;
    private Node<Item> tail;
    private int size;

    // construct an empty deque
    public Deque() {
        this.size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException("Item cannot be null!");
        Node<Item> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException("Item cannot be null!");
        Node<Item> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (head == null) throw new NoSuchElementException("Cannot remove first element from an empty deque.");
        Item item = head.item;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (head == null) throw new NoSuchElementException("Cannot remove last element from an empty deque.");
        Item item = tail.item;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
        size--;
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node<Item> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                if (!hasNext()) throw new NoSuchElementException("No more items to return.");
                Item item = current.item;
                current = current.next;
                return item;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("You cannot remove elements from this iterator.");
            }
        };
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> d = new Deque<>();
        d.addFirst("Hello2");
        d.addLast("Goodbye1");
        d.addFirst("Hello1");
        d.addLast("Goodbye2");

        StdOut.println("Here are all of the items inside of the deque from head to tail:");
        for (String s : d) {
            StdOut.println("- " + s);
        }

        StdOut.printf("removeFirst() method returns Hello1 - %s\n", d.removeFirst().equals("Hello1"));
        StdOut.printf("removeLast() method returns Goodbye2 - %s\n", d.removeLast().equals("Goodbye2"));

        while (d.size() != 0) {
            d.removeLast();
        }
        StdOut.printf("Is the deque empty now that the size is equal to 0? - %s\n", d.isEmpty());
        d.addFirst("Now to see what happens when we go from empty to non empty again.");
        StdOut.println(d.removeLast());
    }

    private static class Node<Item> {
        private final Item item;
        private Node<Item> next;
        private Node<Item> prev;

        private Node(Item item) {
            this.item = item;
            this.next = null;
            this.prev = null;
        }

        private Node(Item item, Node<Item> next) {
            this.item = item;
            this.next = next;
            this.prev = null;
        }

        private Node(Item item, Node<Item> next, Node<Item> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
