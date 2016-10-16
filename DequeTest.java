

import java.util.Iterator;

public class DequeTest {

	public static void main(String[] args) {
		test3();
//		simpleTest();

	}
	private static void simpleTest(){
		Deque<String> deque = new Deque<String> ();
		deque.addFirst("second");
		deque.addFirst("first");
		deque.addLast("third");
		Test.printResult(deque);
		System.out.println(deque.size());
		deque.addLast("fourth");
		Test.printResult(deque);
		System.out.println(deque.size());
		deque.removeFirst();
		Test.printResult(deque);
		System.out.println(deque.size());
		deque.removeLast();
		Test.printResult(deque);
		System.out.println(deque.size());
		
		
		
		
	}
	private static void test3(){
		Deque<String> deque = new Deque<String> ();
		deque.addFirst("second");
		deque.addFirst("First");
		Test.printResult(deque);
		System.out.println("remove: "+deque.removeLast());
		Test.printResult(deque);
		System.out.println("remove: "+deque.removeLast());
		Test.printResult(deque);
	}


}
