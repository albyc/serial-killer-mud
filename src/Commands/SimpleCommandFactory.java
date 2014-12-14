package Commands;

import java.util.ArrayList;
import java.util.List;

import Controller.*;
import Enums.*;
import Model.*;
import Players.Player;

public class SimpleCommandFactory
{
	public Command<Client> createCommand(SerialKillerMud mud, Commands command, String argument)
	{
		Command<Client> result = null;
		
		List<Player> temp = mud.getPlayersOnline();
		List<Player> players = new ArrayList<Player>();
		players.addAll(temp);
		
		switch(command)
		{
		case MAP:
			result = new MapCommand();
			break;
		case MOVE:
			result = new MoveCommand(argument);
			break;
		case LOOK: // not done yet - still needs to an argument
			
			if (argument.equals(""))
				result = new LookCommand();
			
			else
				result = new LookCommand(argument);
			break;
		case COMMANDS:
			result = new CommandsCommand();
			break;
		case WHO:
			result = new WhoCommand(players);
			break;
		case SAY:
			break;
		case TELL: // not done yet - still needs to take arguments
			break;
		case SCORE:
			result = new ScoreCommand();
			break;
		case GIVE: // not done yet - still needs to take arguments
			break;
		case GET: // not done yet - still needs to take two arguments
			result = new GetCommand(argument);
			break;
		case INVENTORY:
			result = new InventoryCommand();
			break;
		case DROP:
			result = new DropCommand(argument);
			break;
		case USE: // 
			result = new UseCommand(argument);
			break;
		case QUIT:
			result = new QuitCommand();
			break;
		case FIGHT:
			result = new FightCommand(argument);
			break;
		
		default:
			break;
		}
		
		return result;
	}
}
