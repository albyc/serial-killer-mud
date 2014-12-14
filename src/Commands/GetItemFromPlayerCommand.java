package Commands;

import Controller.Client;
import Controller.Server;

public class GetItemFromPlayerCommand extends Command<Server>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9056280413654856961L;
	private String item;
	private String player;
	private String clientName;
	
	public GetItemFromPlayerCommand(String item, String player, String clientName){
		this.item = item;
		this.player = player;
		this.clientName = clientName;
	}

	@Override
	public void execute(Server executeOn) {
		executeOn.getConfirmation(item, player, clientName);
	}

}
