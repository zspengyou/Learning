package StackAndQueue;

public class QueueWithArray {
	private String [] queue;
	private int first;
	private int last;
	private int capacity;
	private int size;
	public static void main(String[] args) {

	}
	public QueueWithArray(int capacity){
		queue = new String [capacity];
		this.capacity = capacity;
		first = 1;
		last = 0;
		size = 0;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public boolean isFull(){
		return size == capacity;
	}	
	public void enqueue(String item) throws Exception{
		if(isFull()) throw new Exception("isFull");
		queue[++last] = item;
		size ++;
	}
	public String dequeue()throws Exception{
		if(isEmpty()) throw new Exception("isEmpty");
		String item = queue[first++];
		size --;
		return item;
	}
	
}
