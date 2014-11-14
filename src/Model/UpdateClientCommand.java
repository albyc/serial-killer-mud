package Model;

import java.util.LinkedList;
import java.util.List;




import Controller.Client;
import Controller.Server;

public class UpdateClientCommand extends Command<Client> {
	private static final long serialVersionUID = 4222014184904080846L;
	private List<String> messages;
	
	public UpdateClientCommand(List<String> messages)
	{
		this.messages = new LinkedList<String>(messages);
	}
	@Override
	public void execute(Client executeOn) 
	{
		
		executeOn.update(messages);
	}
}
