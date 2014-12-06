package Commands;

import Controller.Server;
import Enums.Commands;

public class TellMessageCommand extends Command<Server>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5388575592436239030L;
	
	private String clientName;
	private String messageReceiver;
	private String message;
	private Commands command;
	
	public TellMessageCommand(String clientName, String argument1, String argument2, Commands command){
		this.clientName = clientName;
		this.messageReceiver = argument1;
		this.message = argument2;
		this.command = command;
	}

	@Override
	public void execute(Server executeOn) {
		executeOn.addTellMessage(clientName, messageReceiver, message);
	}

}
