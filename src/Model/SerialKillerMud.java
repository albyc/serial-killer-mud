package Model;

import Rooms.*;
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
	private PlayerCollection players;
	private MOBCollection mobs;
	
	public SerialKillerMud()
	{
		rooms = new RoomCollection();
		players = new PlayerCollection();
		mobs = new MOBCollection();
	}

	public void setUpNewPlayer(String username)
	{
		// Create the player from the user's information
		Player player = new Player(username);
		
		// Add the new player to the collection of existing players
		players.addPlayer(player);
		
		// Add the player to the rooms. Initially, every new player
		// will start out in the same location. 
		rooms.addPlayerToRooms(player);
	}
	
} // end of class SerialKillerMud
