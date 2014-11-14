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
public class SceneRoom extends Room 
{
	
	private List<Item> items; // list of items in the room
	private List<SceneRoom> references; // list of references?
	
	
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
	public SceneRoom(String name, String description, List<Item> items, List<Player> players, List<MOB> mobs, List<SceneRoom> refs)
	{
		super(name, description, players, mobs);
		
		this.items = items;
		this.references = refs;
	} // end of constructor Room
	
	/**
	 * 
	 * @param room
	 */
	//do we really want this? or should we keep our room collection constant?
	public void setNextRoom(SceneRoom room, String direction)
	{
		roomCollection.getRoomRow(room);
		roomCollection.getRoomCol(room);
		roomCollection.getRoomHeight(room);
		
		if(direction.equals("up"))
		{
			
		}
	}
	
	/**
	 * 
	 * @param player
	 */
	
		
	
	
	
}
