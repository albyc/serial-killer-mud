package Commands;

import Controller.*;

public class MoveCommand extends Command<Client>
{
	private static final long serialVersionUID = -1921247521510499218L;
	private String argument;
	
	public MoveCommand(String argument)
	{
		this.argument = argument;
	}
	
	public void execute(Client executeOn)
	{
		executeOn.movePlayer(argument);
	}
} // end of class MoveCommand
