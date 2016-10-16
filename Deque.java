

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int size;

	private class Node {
		Item item;
		Node next;
		Node previous;

		public Node(Item item) {
			this.item = item;
		}
	}

	/**
	 * construct an empty deque
	 */
	public Deque() {
	}

	/**
	 * // is the deque empty?
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * return the number of items on the deque
	 * 
	 * @return
	 */
	public int size() {
		return size;

	}

	/**
	 * add the item to the front
	 * 
	 * @param item
	 * @throws NullPointerException
	 *             if the client attempts to add a null item
	 */
	public void addFirst(Item item) {
		if (item == null)
			throw new NullPointerException("");
		boolean empty = isEmpty();
		size++;
		Node oldFirst = first;
		first = new Node(item);
		if (empty) {
			last = first;
		} else {
			first.next = oldFirst;
			oldFirst.previous = first;
		}
	}

	/**
	 * // add the item to the end
	 * 
	 * @param item
	 * @throws NullPointerException
	 *             if the client attempts to add a null item
	 */
	public void addLast(Item item) {
		if (item == null)
			throw new NullPointerException("");
		boolean empty = isEmpty();
		size++;
		Node oldLast = last;
		last = new Node(item);
		if (empty) {
			first = last;
		} else {
			oldLast.next = last;
			last.previous = oldLast;
		}

	}

	/**
	 * // remove and return the item from the front
	 * 
	 * @return
	 * @throws NoSuchElementException
	 *             if the client attempts to remove an item from an empty deque;
	 */
	public Item removeFirst() {
		if (isEmpty())
			throw new NoSuchElementException("");
		size--;
		boolean empty = isEmpty();
		Node oldFirst = first;
		if (empty) {
			last = null;
		} else {
			first = first.next;
			oldFirst.next = null;
			first.previous = null;
		}
		return oldFirst.item;

	}

	/**
	 * // remove and return the item from the end
	 * 
	 * @return
	 */
	public Item removeLast() {
		if (isEmpty())
			throw new NoSuchElementException("");
		size--;
		boolean empty = isEmpty();
		Node oldLast = last;
		if (empty) {
			first = null;
			last = null;
		} else {
			last = last.previous;
			last.next = null;
			oldLast.previous = null;
		}
		return oldLast.item;

	}

	/**
	 * // return an iterator over items in order from front to end
	 */
	public Iterator<Item> iterator() {
		return  new DequeIterator<Item>();

	}

	private class DequeIterator<Item> implements Iterator<Item> {
		int size;
		Node first;

		public DequeIterator() {
			this.size = Deque.this.size;
			this.first = Deque.this.first;
		}

		@Override
		public boolean hasNext() {
			return size > 0;
		}

		@Override
		public Item next() {
			if (hasNext() == false)
				throw new NoSuchElementException("");
			size--;
			Item item = (Item) first.item;
			first = first.next;
			return item;
		}

		public void remove() {
			throw new UnsupportedOperationException("");
		}

	};

	/**
	 * unit testing
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

	}
}
