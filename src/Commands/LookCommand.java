package Commands;

import Controller.*;

public class LookCommand extends Command<Client>
{
	private static final long serialVersionUID = 4750185401178793253L;

	public LookCommand(String argument)
	{
		// TODO Auto-generated constructor stub
	}

	public LookCommand()
	{
		// TODO Auto-generated constructor stub
	}

	public void execute(Client executeOn)
	{
		executeOn.listSurroundings();
	}
} // end of class LookCommand
