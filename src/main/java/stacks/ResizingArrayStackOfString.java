package stacks;

public class ResizingArrayStackOfString {
    private String[] stack;
    private int size;

    public ResizingArrayStackOfString() {
        stack = new String[1];
    }

    public void push(String item) {
        if (size == stack.length) resize(stack.length * 2);
        stack[size++] = item;
    }

    public String pop() {
        String item = stack[--size];
        stack[size] = null;
        if (size > 0 && size == stack.length / 4) resize(stack.length / 2);
        return item;
    }

    private void resize(int newSize) {
        String[] copy = new String[newSize];
        for (int i = 0; i < size; i++) {
            copy[i] = stack[i];
        }
        stack = copy;
    }
}
