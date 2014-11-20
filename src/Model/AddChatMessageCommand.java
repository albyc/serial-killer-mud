package Model;

import Controller.*;

/**
 * Adds a message to the server's chat log
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public class AddChatMessageCommand extends Command<Server>
{
	private static final long serialVersionUID = 9182181964927575026L;
	private String message; // text message from the client
	
	/**
	 * Creates an AddMessageCommand with the given message.
	 * 
	 * @param message Message to add to the chat log
	 */
	public AddChatMessageCommand(String message)
	{
		this.message = message;
	}
	
	/**
	 * Executes the AddMessageCommand on the given argument.
	 * 
	 * @param executeOn Server object to execute command on
	 */
	public void execute(Server executeOn) 
	{
		executeOn.addMessage(message);
	}
} // end of class AddMessageCommand
