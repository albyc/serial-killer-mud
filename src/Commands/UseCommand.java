package Commands;

import Controller.*;

public class UseCommand extends Command<Client>
{
	private static final long serialVersionUID = -3475690984149712433L;
	private String argument;
	
	public UseCommand(String argument)
	{
		this.argument = argument;
	}
	
	public void execute(Client executeOn)
	{
		executeOn.useItem(argument);
	}
} // end of class UseCommand
