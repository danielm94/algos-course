package linkedlists;

import java.util.Iterator;

public class Node<T> implements Iterable<T> {
    private T item;
    private Node<T> next;

    public Node() {
        this.item = null;
        this.next = null;
    }

    public Node(T item, Node<T> next) {
        this.item = item;
        this.next = next;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public Iterator<T> iterator() {
        return new NodeIterator();
    }

    private class NodeIterator implements Iterator<T> {
        private Node<T> head = Node.this;

        @Override
        public boolean hasNext() {
            return head != null;
        }

        @Override
        public T next() {
            T item = head.item;
            head = head.next;
            return item;
        }
    }
}
