package Model;

import Controller.Server;

public class QuitCommand extends Command<Server>{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2342200939362514475L;
	private String clientName;
	
	public QuitCommand(String clientName)
	{
		this.clientName = clientName;
	}

	@Override
	public void execute(Server executeOn) 
	{
		executeOn.disconnect(clientName);
		
	}
	
}
