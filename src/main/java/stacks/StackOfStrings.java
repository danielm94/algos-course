package stacks;

import java.util.LinkedList;
import java.util.List;

public class StackOfStrings {
    private final LinkedList<String> stack;

    public StackOfStrings() {
        this.stack = new LinkedList<>();
    }

    public void push(String item) {
        stack.addLast(item);
    }

    public String pop() {
        return stack.removeLast();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public static void main(String[] args) {
        StackOfStrings stackOfStrings = new StackOfStrings();
        stackOfStrings.push("Hello");
        System.out.println(stackOfStrings.pop());
        stackOfStrings.push("abc");
        stackOfStrings.push("World");
        System.out.println(stackOfStrings.pop());
    }
}
