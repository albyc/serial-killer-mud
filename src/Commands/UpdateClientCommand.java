package Commands;

import java.util.List;

import Controller.Client;

public class UpdateClientCommand extends Command<Client>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3570678458631454030L;
	private List<String> messages;
	private String receiver;
	private String sender;
	public UpdateClientCommand(List<String> messages, String receiver, String sender)
	{
		this.messages = messages;
		this.receiver = receiver;
		this.sender = sender;
	}

	@Override
	public void execute(Client executeOn) {
		executeOn.updateOne(messages, receiver, sender);
		
	}

}
