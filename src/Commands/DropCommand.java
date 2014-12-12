package Commands;

import Controller.*;

public class DropCommand extends Command<Client>
{
	private static final long serialVersionUID = -6239777504515291261L;
	private String argument; 
	
	public DropCommand(String argument)
	{
		this.argument = argument;
	}
	
	public void execute(Client executeOn)
	{
		executeOn.dropItem(argument);
	}
} // end of class DropCommand
