package Commands;

import Controller.Server;
import Players.Player;

public class AddPlayerCommand extends Command<Server>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6870922761647727272L;
	private Player player;
	
	public AddPlayerCommand(Player player){
		this.player = player;
	}
	@Override
	public void execute(Server executeOn) {
		executeOn.addPlayer(player);
	}

}
