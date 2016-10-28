package commandPattern;

public class Receiver {

	public void action1(){
		System.out.println("this is action 1");
	}
	public void action2(){
		System.out.println("this is action 2");
	}
	public int actionWithParameter1(int i){
		System.out.println("in receiver actionWithParameter1");
		System.out.println("the parameter is: " + i);
		i++;
		return i;
	}
	public int actionWithParameter2(int i){
		System.out.println("in receiver actionWithParameter2");
		System.out.println("the parameter is: " + i);
		i++;
		return i;
	}
}
