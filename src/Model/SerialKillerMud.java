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
		mobs = new MOBCollection(null); 		//note: trouble
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
