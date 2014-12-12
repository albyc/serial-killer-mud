package Commands;

import Controller.*;
import Enums.Commands;
import View.*;

/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public class ForServerCommand extends Command<Server>
{
	private static final long serialVersionUID = 2905888151191273334L;
	private String clientName;
	private String argument;
	private Commands command;
	

	public ForServerCommand(String clientName, Commands command, String argument)
	{
		this.clientName = clientName;
		this.argument = argument;
		this.command = command;
		this.argument = argument;
	}

	@Override
	public void execute(Server executeOn) 
	{

		executeOn.PrintToClient(clientName, command, argument);
	}
} // end of class ForServerWArgsCommand
