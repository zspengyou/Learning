import java.util.Iterator;
import java.util.LinkedList;

public class Test {

	public static void main(String[] args) {
		System.out.println("this is a good keyboardboard board board board board board ");
		System.out.println("hello world");
		LinkedList <Integer> list = new LinkedList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		class MyIterator implements Iterable<Integer>{
			@Override
			public Iterator<Integer> iterator() {
				return list.descendingIterator();
			}
			
		}
		for(int num: new MyIterator()){
			System.out.println(num);
		}
		printResult(()->list.descendingIterator());


		
	}
	static <Item> void printResult(Iterable<Item> iterator){
		System.out.println("****************");
		for(Item string: iterator){
			System.out.println(string);
		}
		System.out.println("****************");
	}

}
