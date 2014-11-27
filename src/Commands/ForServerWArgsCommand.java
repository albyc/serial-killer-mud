package Commands;

import Controller.*;
import Enums.Commands;
import View.*;

/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public class ForServerWArgsCommand extends Command<Server>
{
	private static final long serialVersionUID = 2905888151191273334L;
	private String clientName;
	private String argument;
	private Commands command;
	
	public ForServerWArgsCommand(String clientName, String argument, Commands command)
	{
		this.clientName = clientName;
		this.argument = argument;
		this.command = command;
	}

	@Override
	public void execute(Server executeOn) 
	{
		executeOn.PrintToClientWArgs(clientName, argument, command);
	}
} // end of class ForServerWArgsCommand
