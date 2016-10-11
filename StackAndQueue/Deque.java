package StackAndQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
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
		return false;

	}

	/**
	 * // return the number of items on the deque
	 * 
	 * @return
	 */
	public int size() {
		return 0;

	}

	/**
	 * add the item to the front
	 * @param item
	 * @throws NullPointerException  if the client attempts to add a null item
	 */
	public void addFirst(Item item){
		if(item == null)
			throw new NullPointerException("");

	}

	/**
	 * // add the item to the end
	 * 
	 * @param item
	 * @throws NullPointerException  if the client attempts to add a null item
	 */
	public void addLast(Item item){
		if(item == null)
			throw new NullPointerException("");

	}

	/**
	 * // remove and return the item from the front
	 * 
	 * @return
	 * @throws NoSuchElementException if the client attempts to remove an item from an empty deque;
	 */
	public Item removeFirst(){
		if(isEmpty()) 
			throw new NoSuchElementException("");
		return null;

	}

	/**
	 * // remove and return the item from the end
	 * 
	 * @return 	
	 */
	public Item removeLast() {
		if(isEmpty()) 
			throw new NoSuchElementException("");
		return null;

	}

	/**
	 * // return an iterator over items in order from front to end
	 */
	public Iterator<Item> iterator() {
		return new Iterator<Item>() {

			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			public Item next() {
				if(hasNext() == false)
					throw new NoSuchElementException(""); 
				return null;
			}
			
			public void remove(){
				throw new UnsupportedOperationException(""); 
			}

		};

	}

	public static void main(String[] args) {

	} // unit testing
}
