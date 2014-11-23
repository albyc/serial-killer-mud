package Model;

import View.*;
import Controller.*;

/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public class ForServerCommand extends Command<Server>
{
	private static final long serialVersionUID = -4617032470436109312L;
	private String clientName;
	private Commands command;
	
	public ForServerCommand(String clientName, Commands command)
	{
		this.clientName = clientName;
		this.command = command;
	}

	public void execute(Server executeOn) 
	{
		executeOn.PrintToClient(clientName, command);
	}
} // end of class ForServerCommand
