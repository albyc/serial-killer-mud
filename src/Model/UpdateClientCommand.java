package Model;

import java.util.LinkedList;
import java.util.List;

import Controller.*;

/**
 * Updates a client with the current log of chat messages
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public class UpdateClientCommand extends Command<Client> 
{
	private static final long serialVersionUID = 4222014184904080846L;
	private List<String> messages;
	
	/**
	 * Creates a new UpdateClientCommand with the given log of messages
	 * 
	 * @param messages The current log of messages
	 */
	public UpdateClientCommand(List<String> messages)
	{
		this.messages = new LinkedList<String>(messages);
	}
	
	/**
	 * Updates the client
	 */
	public void execute(Client executeOn) 
	{
		executeOn.update(messages);
	}
}
