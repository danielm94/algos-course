package stacks;

import linkedlists.Node;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private Node<T> head;
    private int count = 0;

    public boolean isEmpty() {
        return head == null;
    }

    public void push(T item) {
        Node<T> oldHead = head;
        head = new Node<>(item, oldHead);
        count++;
    }

    public T pop(){
        T item = head.getItem();
        head = head.getNext();
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return head.iterator();
    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        s.push("Hello");
        s.push("World");
        s.push("Goodbye");
        s.push("Moonman");
        for(String str: s){
            System.out.println(str);
        }
    }
}
