package Rooms;
import java.util.List;

import Items.Item;
import Players.Player;


public abstract class Room {

	protected String name;
	protected String description;
	protected List<Item> items;
	protected List<Player> players;
	protected List<MOB> mobs;
	protected List<Room> references;
	
	public Room(String name, String description, List<Item> items, List<Player> players, List<MOB> mobs, List<Room> refs){
		this.name = name;
		this.description = description;
		this.items = items;
		this.players = players;
		this.mobs = mobs;
		this.references = refs;
	}
	
	public abstract void setNextRoom(Room room);
	
	public abstract void removePlayer(Player player);
		
	
	
	
}
