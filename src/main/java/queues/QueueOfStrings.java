package queues;

import linkedlists.Node;

public class QueueOfStrings {
    int size = 0;
    Node head;
    Node tail;

    public void enqueue(String item) {
        Node node = new Node(item, null);
        if (isEmpty()) {
            head = node;
            tail = head;
        } else {
            tail.setNext(node);
            tail = tail.getNext();
        }
        size++;
    }

    public String dequeue() {
        if (isEmpty()) throw new IllegalStateException("Cannot dequeue from an empty queue.");
        size--;
        String item = head.getItem();
        head = head.getNext();
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        QueueOfStrings queueOfStrings = new QueueOfStrings();
        queueOfStrings.enqueue("Hello");
        queueOfStrings.enqueue("My");
        queueOfStrings.enqueue("Name");
        queueOfStrings.enqueue("Is");
        queueOfStrings.enqueue("Daniel");
        queueOfStrings.enqueue("How");
        queueOfStrings.enqueue("Are");
        queueOfStrings.enqueue("You");
        while (!queueOfStrings.isEmpty()){
            System.out.println(queueOfStrings.dequeue());
        }
    }

}
