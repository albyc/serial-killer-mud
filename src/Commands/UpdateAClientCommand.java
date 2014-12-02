package Commands;

import Controller.Client;
import Controller.Server;
import Enums.Commands;

public class UpdateAClientCommand extends Command<Client>
{
	private Commands command;
	private String clientName;

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
			executeOn.listScore();
			break;
		case INVENTORY:
			executeOn.listInventory();
			break;
		case COMMANDS:
			executeOn.listCommands();
			break;
		case QUIT:
		case SHUTDOWN: 
			executeOn.closeByInput();
			break;
		case LOOK:
			executeOn.listSurroundings();
			break;
		case MAP:
			executeOn.showMap();
			break;
		default:
			break;
		}
	}
}
