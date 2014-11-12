package Rooms;
import java.util.List;

import Items.Item;
import Players.Player;


public abstract class Room {

	private String name;
	private String description;
	private List<Item> items;
	private List<Player> players;
	private List<MOB> mobs;
	private List<Room> references;
	
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
