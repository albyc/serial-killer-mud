package Model;

import Controller.Server;
import View.Commands;

public class PrintWArgsCommand extends Command<Server>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2905888151191273334L;
	private String clientName;
	private String argument;
	private Commands command;
	
	public PrintWArgsCommand(String clientName, String argument, Commands command)
	{
		this.clientName = clientName;
		this.argument = argument;
		this.command = command;
	}



	@Override
	public void execute(Server executeOn) {
		executeOn.PrintToClientWArgs(clientName, argument, command);
	}

	
}
