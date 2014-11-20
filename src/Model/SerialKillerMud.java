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
	
	public PlayerCollection getPlayers() { return players; }
} // end of class SerialKillerMud
