package Commands;

import Controller.Client;

public class GetItemFromPlayerCommand extends Command<Client>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9056280413654856961L;
	private String item;
	private String player;
	
	public GetItemFromPlayerCommand(String item, String player){
		this.item = item;
		this.player = player;
	}

	@Override
	public void execute(Client executeOn) {
		//executeOn.getConfirmation(item, player);
	}

}
