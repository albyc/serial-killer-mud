package Commands;

import Controller.Client;
import Controller.Server;
import Enums.Commands;

public class TellMessageCommand extends Command<Client>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5388575592436239030L;
	
	private String clientName;
	private String messageReceiver;
	private String message;
	private Commands command;
	
	public TellMessageCommand(String clientName, String argument, Commands command){
		int index = argument.indexOf(" ");
		this.messageReceiver = argument.substring(0, index);
		this.message = argument.substring(index + 1);
		this.clientName = clientName;
		this.command = command;
	}

	/*@Override
	public void execute(Server executeOn) {
		executeOn.addTellMessage(clientName, messageReceiver, message);
		System.out.println("We made it to tellmessagecommand");
	}*/

	@Override
	public void execute(Client executeOn) {
		System.out.println("Maybe this time it will work?");
		executeOn.addTellMessage(clientName, messageReceiver, message);
	}

}
