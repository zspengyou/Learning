package commandPattern;

public class Client {

	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		Invoker invoker = new Invoker();
		//method reference
		invoker.setCommand(receiver::action1);
		invoker.invoke();
		//lambda expression
		invoker.setCommand(()->{receiver.action2();});
		invoker.invoke();
		System.out.println("end of client");		
	}

}
