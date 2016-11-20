import java.util.Iterator;
import java.util.LinkedList;

public class Test {
	private enum Direction{
		up(1),left(2),down(3),right(4);
		int val;
		Direction(int val){
			this.val = val;
		}
		public int getVal(){
			return val;
		}
	}

	public static void main(String[] args) {
	    Double d = 2.0;
	    d = changeValue(d);
	    System.out.println(d);
	    boolean stop = true;
	    if(stop) return ;
		Direction up = Direction.up;
		Direction down = Direction.down;
		Direction left = Direction.left;
		Direction right = Direction.right;
		int distance ;
		distance = Math.abs(up.getVal() - down.getVal());
		System.out.println(distance);
		distance = Math.abs(up.getVal() - left.getVal());
		System.out.println(distance);
		distance = Math.abs(up.getVal() - right.getVal());
		System.out.println(distance);
		distance = Math.abs(up.getVal() - up.getVal());
		System.out.println(distance);
		
		
	}
	static double changeValue(Double d){
	    d =new Double(3.0);
	    return d;
	}
	static <Item> void printResult(Iterable<Item> iterator){
		System.out.println("****************");
		for(Item string: iterator){
			System.out.println(string);
		}
		System.out.println("****************");
		
	}
	static void testIterator(){
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

}
