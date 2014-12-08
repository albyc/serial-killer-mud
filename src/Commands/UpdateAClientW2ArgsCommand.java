package Commands;

import Controller.Client;
import Enums.Commands;

public class UpdateAClientW2ArgsCommand extends Command<Client> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3679784890048614079L;
	private Commands command;
	private String argument1;
	private String argument2;
	
	public UpdateAClientW2ArgsCommand(Commands command, String argument1, String argument2)
	{
		this.command = command;
		this.argument1 = argument1;
		this.argument2 = argument2;
	}

	@Override
	public void execute(Client executeOn) {
		switch(command)
		{
		/*case TELL:
			executeOn.tellMessage(argument1, argument2);
			break;*/
		case GET:
			break;
		case GIVE:
			break;
		default:
			break;
		}
	}

}
