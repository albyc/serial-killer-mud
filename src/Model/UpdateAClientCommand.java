package Model;

import View.Commands;
import Controller.Client;
import Controller.Server;

public class UpdateAClientCommand extends Command<Client>
{
	private Commands command;

	/**
	 * 
	 */
	private static final long serialVersionUID = 2391737253487805634L;

	
	public UpdateAClientCommand(Commands command)
	{
		this.command = command;
	}

	@Override
	public void execute(Client executeOn) 
	{
		switch(command)
		{
		case SCORE:
			break;
		case INVENTORY:
			executeOn.listInventory();
			break;
		case COMMANDS:
			executeOn.listCommands();
			break;
		case WHO:
			executeOn.listWho();
			break;
		case QUIT:
			executeOn.closeByInput();
			break;
		default:
			break;
		}
	}
}
