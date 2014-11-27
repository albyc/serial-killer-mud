package Commands;

import java.util.List;

import Controller.Client;
import Players.Player;

public class WhoCommand extends Command<Client>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8978150445909455283L;
	private List<Player> players;

	public WhoCommand(List<Player> players) {
		this.players = players;
	}

	@Override
	public void execute(Client executeOn) {
		executeOn.listWho(players);
	}

	
}
