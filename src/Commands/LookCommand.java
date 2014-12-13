package Commands;

import Controller.*;

public class LookCommand extends Command<Client>
{
	private static final long serialVersionUID = 4750185401178793253L;
	private String argument;

	public LookCommand(String argument)
	{
		this.argument = argument;
		
	}

	public LookCommand()
	{
		// TODO Auto-generated constructor stub
	}

	public void execute(Client executeOn)
	{
		if(argument == null){
			executeOn.listSurroundings();
		}
		else{
			executeOn.lookDescription(argument);
		}
	}
} // end of class LookCommand
