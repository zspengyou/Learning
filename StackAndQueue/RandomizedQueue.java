package StackAndQueue;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item queue[];
    private int capacity;
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
        queue = (Item[]) new Object[1];
        capacity = 1;
        size = 0;
    }

    // is the queue empty?
    public boolean isEmpty() {
        return size == 0;

    }

    // return the number of items on the queue
    public int size() {
        return size;

    }

    // add the item
    public void enqueue(Item item) {
        if (item == null)
            throw new NullPointerException("");
        if (size >= capacity) {
            doubleCapacity();
        }
        queue[size++] = item;

    }

    private void doubleCapacity() {
        Item[] oldQueue = queue;
        queue = (Item[]) new Object[capacity * 2];
        for (int i = 0; i < capacity; i++)
            queue[i] = oldQueue[i];
        capacity *= 2;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("");
        int pos = StdRandom.uniform(size);
        Item result = queue[pos];
        size--;
        queue[pos] = queue[size];
        queue[size] = null;
        if (size < capacity / 4) {
            shrinkCapacity();
        }
        return result;

    }

    private void shrinkCapacity() {
        Item[] oldQueue = queue;
        capacity /= 2;
        queue = (Item[]) new Object[capacity];
        for (int i = 0; i < capacity; i++)
            queue[i] = oldQueue[i];
    }

    // return (but do not remove) a random item
    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException("");
        int pos = StdRandom.uniform(size);
        return queue[pos];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedIterator();

    }

    private class RandomizedIterator implements Iterator<Item> {
        Item[] iteratorQueue;
        int pos;

        public RandomizedIterator() {
            iteratorQueue = Arrays.copyOfRange(RandomizedQueue.this.queue, 0, RandomizedQueue.this.size);
            StdRandom.shuffle(iteratorQueue);
            int pos = 0;
        }

        @Override
        public boolean hasNext() {
            return pos < iteratorQueue.length;
        }

        @Override
        public Item next() {
            if (hasNext() == false)
                throw new NoSuchElementException("");
            return iteratorQueue[pos++];
        }

        public void remove() {
            throw new UnsupportedOperationException("");
        }

    }

    // unit testing
    public static void main(String[] args) {

    }
}
