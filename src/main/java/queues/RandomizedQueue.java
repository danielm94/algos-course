package queues;

import java.util.ArrayList;
import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private static final int DEFAULT_QUEUE_SIZE = 1;

    private Item[] queue;
    private int size = 0;

    // construct an empty randomized queue
    public RandomizedQueue() {
        this.queue = (Item[]) new Object[DEFAULT_QUEUE_SIZE];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return false;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {

    }

    // remove and return a random item
    public Item dequeue() {
        return null;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        return null;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Item next() {
                return null;
            }
        };
    }

    // unit testing (required)
    public static void main(String[] args) {

    }

}