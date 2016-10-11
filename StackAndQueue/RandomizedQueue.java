package StackAndQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
	// construct an empty randomized queue
	   public RandomizedQueue(){
		   
	   }      
	// is the queue empty?
	   public boolean isEmpty(){
		return false;
		   
	   }     
	// return the number of items on the queue
	   public int size(){
		return 0;
		   
	   }     
	// add the item
	   public void enqueue(Item item){
			if(item == null)
				throw new NullPointerException("");
		   
	   }      
	   // remove and return a random item
	   public Item dequeue(){
			if(isEmpty()) 
				throw new NoSuchElementException("");
			return null;
		   
	   }   
	// return (but do not remove) a random item
	   public Item sample(){
			if(isEmpty()) 
				throw new NoSuchElementException("");
			return null;
		   
	   }  
	// return an independent iterator over items in random order
	   public Iterator<Item> iterator(){
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
	// unit testing
	   public static void main(String[] args){
		   
	   }   
	}
