package queues;

import edu.princeton.cs.algs4.StdIn;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> stringRandomizedQueue = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            stringRandomizedQueue.enqueue(StdIn.readString());
        }
        while (k-- > 0) {
            System.out.println(stringRandomizedQueue.dequeue());
        }
    }
}
