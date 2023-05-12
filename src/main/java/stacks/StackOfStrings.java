package stacks;

public class StackOfStrings {
    private Node head;
    private int size = 0;

    public void push(String item) {
        Node oldHead = head;
        head = new Node(item,oldHead);
        size++;
    }

    public String pop() {
        String item = head.item;
        head = head.next;
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
            if(curr.item.equals(item)){
                return true;
            }
            curr = curr.next;
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
    private class Node{
        String item;
        Node next;

        public Node() {
            this.item = null;
            this.next = null;
        }

        public Node(String item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
