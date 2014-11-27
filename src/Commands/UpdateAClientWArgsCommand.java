package Commands;

import Controller.Client;
import Enums.Commands;

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
			executeOn.surroundingsArg(argument);
			break;
		case MOVE:
			executeOn.movePlayer(argument);
			break;
		case DROP:
			executeOn.dropItem(argument);
			break;
		case GET:
			executeOn.pickUp(argument);
			break;
		default:
			break;
		}
	}

	
}
