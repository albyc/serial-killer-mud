package Rooms;
import java.util.List;

import Items.Item;
import MOBs.MOB;
import Players.Player;

/**
 * This class...
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public abstract class Room 
{
	protected String name; // name of the room
	protected String description; // description of the room
	protected List<Item> items; // list of items in the room
	protected List<Player> players; // list of players in the room
	protected List<MOB> mobs; // list of mobs in the room
	protected List<Room> references; // list of references?
	protected RoomCollection roomCollection;
	
	/**
	 * This constructor creates a new Room 
	 * 
	 * @param name
	 * @param description
	 * @param items
	 * @param players
	 * @param mobs
	 * @param refs
	 */
	public Room(String name, String description, List<Item> items, List<Player> players, List<MOB> mobs, List<Room> refs)
	{
		this.name = name;
		this.description = description;
		this.items = items;
		this.players = players;
		this.mobs = mobs;
		this.references = refs;
	} // end of constructor Room
	
	/**
	 * 
	 * @param room
	 */
	//do we really want this? or should we keep our room collection constant?
	public void setNextRoom(Room room, String direction){
		roomCollection.getRoomRow(room);
		roomCollection.getRoomCol(room);
		roomCollection.getRoomHeight(room);
		
		if(direction.equals("up")){
			
		}
	}
	
	/**
	 * 
	 * @param player
	 */
	public void removePlayer(Player player){
		players.remove(player);
	}
		
	
	
	
}
