package commandPattern;

public class Client {

	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		Invoker invoker = new Invoker();
		//method reference
		invoker.invoke();
		invoker.setCommand(receiver::action1);
		invoker.invoke();
		//lambda expression
		invoker.setCommand(()->{receiver.action2();});
		invoker.invoke();
		System.out.println("end of client");		
		invoker.invokeWithParameter(100);
		invoker.setCommandWithParameter(receiver::actionWithParameter1); 
		int result = invoker.invokeWithParameter(100);
		System.out.println("result after invoker: " + result);
		invoker.setCommandWithParameter((int i)->{
			 return receiver.actionWithParameter2(i);
		}); 
		result = invoker.invokeWithParameter(100);
		System.out.println("result after invoker: " + result);
		
		System.out.println("end of command with parameter" );
	}

}
