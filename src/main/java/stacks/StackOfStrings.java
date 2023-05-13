package stacks;

import linkedlists.Node;

public class StackOfStrings {
    private Node head;
    private int size = 0;

    public void push(String item) {
        Node oldHead = head;
        head = new Node(item,oldHead);
        size++;
    }

    public String pop() {
        String item = head.getItem();
        head = head.getNext();
        size--;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean contains(String item){
        Node curr = head;
        while(curr != null){
            if(curr.getItem().equals(item)){
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    public static void main(String[] args) {
        StackOfStrings s = new StackOfStrings();
        s.push("Hello");
        s.push("World");
        s.push("Goodbye");
        s.push("Moonman");
        System.out.println(s.contains("World"));
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.contains("World"));
    }
}
