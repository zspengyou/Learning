package StackAndQueue;

public class RandomizedQueueTest {

	public static void main(String[] args) {
		RandomizedQueue<String> queue = new RandomizedQueue<String>();
		queue.enqueue("first");
		queue.enqueue("second");
		queue.enqueue("third");
		Test.printResult(queue);
		System.out.println("dequeue: " + queue.dequeue());
		Test.printResult(queue);
		queue.enqueue("fourth");
		Test.printResult(queue);
	}
}
