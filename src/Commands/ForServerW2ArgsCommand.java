package Commands;

import Controller.Server;
import Enums.Commands;

public class ForServerW2ArgsCommand extends Command<Server>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8937721989615422540L;
	private String clientName;
	private String argument1;
	private String argument2;
	private Commands command;
	
	public ForServerW2ArgsCommand(String clientName, String argument1, String argument2, Commands command)
	{
		this.clientName = clientName;
		this.argument1 = argument1;
		this.argument2 = argument2;
		this.command = command;
	}

	@Override
	public void execute(Server executeOn) 
	{
		executeOn.PrintToClientW2Args(clientName, argument1, argument2, command);
	}

}
