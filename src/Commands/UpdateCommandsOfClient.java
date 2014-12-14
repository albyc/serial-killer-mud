package Commands;

import Controller.*;

public class UpdateCommandsOfClient extends Command<Client>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -945667599506379123L;
	private String item;
	private String player;
	private String clientName;
	
	public UpdateCommandsOfClient(String item, String player, String clientName){
		this.item = item;
		this.player = player;
		this.clientName = clientName;
	}

	@Override
	public void execute(Client executeOn) {
		executeOn.addConfirmationCommand(item, player, clientName);
	}

}
