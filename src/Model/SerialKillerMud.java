package Model;

import java.util.ArrayList;
import java.util.List;

import Rooms.*;
import Items.Item;
import MOBs.*;
import Players.*;

/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public class SerialKillerMud
{
	private RoomCollection rooms;
	private transient List<Player> players;
	private MOBCollection mobs;
	
	public SerialKillerMud()
	{
		rooms = new RoomCollection();
		players = new ArrayList<Player>();
		//mobs = new MOBCollection(null); 		// note: trouble
		addAdmins();
	}

	private void addAdmins()
	{
		Player adminZero = new Player("Damaris", "0000");
		Player adminOne = new Player("Alby", "1111");
		Player adminThree = new Player("Alexa", "3333" );
		Player adminNine = new Player("Lisa", "9999");
		
		players.add(adminZero);
		players.add(adminOne);
		players.add(adminThree);
		players.add(adminNine);
	}

	public void addPlayerToGame(Player player)
	{		
		// Add the new player to the collection of existing players
		players.add(player);
		
		// Add the player to the rooms. Initially, every new player
		// will start out in the same location. 
		rooms.addPlayerToRooms(player);
	}
	
	public List<Player> getPlayers()
	{
		return players;
	}
} // end of class SerialKillerMud
