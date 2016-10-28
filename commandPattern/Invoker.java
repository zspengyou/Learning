package commandPattern;

public class Invoker {
	Command command;
	public Invoker(){
		command  = ()-> {System.out.println("this is empty command");};
	}
	public void setCommand(Command command){
		this.command = command;
	}
	public void invoke(){
		command.execute();
	}
}
