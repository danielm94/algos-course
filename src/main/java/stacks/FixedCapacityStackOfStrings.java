package stacks;

public class FixedCapacityStackOfStrings {
    private final String[] s;
    private int n = 0;

    public FixedCapacityStackOfStrings(int capacity) {
        this.s = new String[capacity];
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public void push(String item){
        s[n++] = item;
    }

    public String pop(){
        return s[--n];
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings f = new FixedCapacityStackOfStrings(10);
        f.push("Hello");
        f.push("World");
        System.out.println(f.pop());
    }
}
