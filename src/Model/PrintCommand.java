package Model;

import View.Commands;
import Controller.Server;

public class PrintCommand extends Command<Server>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4617032470436109312L;
	private String clientName;
	private Commands command;
	
	public PrintCommand(String clientName, Commands command)
	{
		this.clientName = clientName;
		this.command = command;
	}

	@Override
	public void execute(Server executeOn) 
	{
		executeOn.PrintToClient(clientName, command);
		
	}

	
}
