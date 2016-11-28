package javaKnowledge;

public class TestVarargus {

	public static void main(String[] args) {
		String a = "a";
		String b = "b";
		String c = "c";
		printResult(a,b,c);
	}
	public static void printResult(String... args){
		for(String arg: args){
			System.out.println(arg);
		}
	}

}
