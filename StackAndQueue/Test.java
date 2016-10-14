package StackAndQueue;

public class Test {

	public static void main(String[] args) {

	}
	static <Item> void printResult(Iterable<Item> iterator){
		System.out.println("****************");
		for(Item string: iterator){
			System.out.println(string);
		}
		System.out.println("****************");
	}

}
