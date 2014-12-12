package Commands;

import java.util.List;

import Controller.*;
import Players.*;

public class WhoCommand extends Command<Client>
{
	private static final long serialVersionUID = -8978150445909455283L;
	private List<Player> players;

	public WhoCommand(List<Player> players) 
	{
		this.players = players;
	}

	public void execute(Client executeOn) 
	{
		executeOn.listWho(players);
	}
} // end of class WhoCommand
