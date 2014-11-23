package Model;

import View.Commands;
import Controller.Client;

public class UpdateAClientWArgsCommand extends Command<Client> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4952452374881114536L;
	private Commands command;
	private String argument;
	
	public UpdateAClientWArgsCommand(Commands command, String argument)
	{
		this.command = command;
		this.argument = argument;
	}

	@Override
	public void execute(Client executeOn) {
		switch(command)
		{
		case LOOK:
			
			break;
		case MOVE:
			break;
		case DROP:
			executeOn.dropItem(argument);
			break;
		case GET:
			break;
		default:
			break;
		}
	}

	
}
