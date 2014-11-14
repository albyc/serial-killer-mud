package Rooms;

import java.util.List;

import MOBs.MOB;
import Players.Player;

public abstract class Room {
	protected String name;
	protected String description;
	protected List<Player> players;
	protected List<MOB> mobs;
	protected RoomCollection roomCollection;
	
	public Room(String name, String description, List<Player> players, List<MOB> mobs, RoomCollection roomCollection){
		this.name = name;
		this.description = description;
		this.players = players;
		this.mobs = mobs;
		this.roomCollection = roomCollection;
		
	}
	
	
	
}
