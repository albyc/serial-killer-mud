package Model;

import View.Commands;
import Controller.Server;

public class ShutdownCommand extends Command<Server>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4085373661065068412L;
	private String clientName;
	private Commands command;
	
	public ShutdownCommand(String clientName, Commands command)
	{
		this.clientName = clientName;
		this.command = command;
	}

	@Override
	public void execute(Server executeOn) {
		executeOn.closeServer(clientName);
	}

}
