package Commands;

import Controller.Client;

public class GetCommand extends Command<Client>
{
	private static final long serialVersionUID = 853680469911913921L;
	private String argument;
	
	public GetCommand(String argument)
	{
		this.argument = argument;
	}

	@Override
	public void execute(Client executeOn)
	{
		executeOn.pickUp(argument);
	}
} // end of class GetCommand
