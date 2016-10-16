package StackAndQueue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Subset {
    public static void main(String[] args) {
        int k = Integer.valueOf(args[0]);
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        while (!StdIn.isEmpty()) {
            String input = StdIn.readString();
            queue.enqueue(input);
        }
        int count = 0;
        for (String input : queue) {
            count++;
            if (count > k)
                return;
            StdOut.println(input);
        }
    }
}
