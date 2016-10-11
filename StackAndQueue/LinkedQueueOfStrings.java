package StackAndQueue;

public class LinkedQueueOfStrings {

	public static void main(String[] args) {
		LinkedQueueOfStrings test = new LinkedQueueOfStrings();
		System.out.println(test.isEmpty());
	}
	private Node first, last;
	private class Node {
		String item;
		Node next;
		public Node (String item){
			this.item = item;
		}
	}
	public boolean isEmpty(){
		return first == null;
	}
	public void enqueue(String item){
		Node oldLast = last;
		last = new Node(item);
		if(isEmpty()){
			first = last;
		}else{
			oldLast.next = last;
		}
		
		
	}
	public String dequeue(){
		if(isEmpty()) return null;
		Node oldFirst = first;
		first = first.next;
		if(isEmpty())
			last = null;		
		return oldFirst.item;		
	}

}
