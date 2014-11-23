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
		//change password
		String password = "";
		List<Item> backpack = new ArrayList<Item>(5);
		Player player = new Player(username, password, backpack);
		
		// Add the new player to the collection of existing players
		players.addPlayer(player);
		
		// Add the player to the rooms. Initially, every new player
		// will start out in the same location. 
		rooms.addPlayerToRooms(player);
	}
	
} // end of class SerialKillerMud
