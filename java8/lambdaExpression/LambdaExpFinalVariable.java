package java8.lambdaExpression;

public class LambdaExpFinalVariable {
	static String salutation = "static String! ";
	public static void main(String[] args) {
		String s = "hello";
		s = "hello2";
		LambdaExpFinalVariable.salutation="changed";
		GreetingService hello = a -> System.out.println(salutation + a);
		hello.show(s);
	}

	interface GreetingService {
		void show(String message);
	}

}
