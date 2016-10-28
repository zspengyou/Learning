package commandPattern;

public class Invoker {
	Command command;
	CommandWithParameter commandWithParameter;
	public Invoker(){
		command  = ()-> {System.out.println("this is empty command");};
		commandWithParameter = (int i)->{ 
			System.out.println("this is empty command with parameter"); 
			return 0;};
	}
	public void setCommand(Command command){
		this.command = command;
	}
	public void setCommandWithParameter(CommandWithParameter commandWithParameter){
		this.commandWithParameter = commandWithParameter;
	}
	public void invoke(){
		command.execute();
	}
	public int invokeWithParameter(int i){
		int result = commandWithParameter.execute(i);
		return result;		
	}
}
