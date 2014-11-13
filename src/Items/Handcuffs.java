package Items;

import Rooms.Room;

/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public class Handcuffs extends Item
{
	/**
	 * 
	 * @param name Name of the item
	 * @param description Description of the item
	 * @param currentLocation The room in which the item is currently located
	 * @param isVisible Indicates whether item is currently visible
	 */
	public Handcuffs(String name, String description, Room currentLocation, boolean isVisible)
	{
		super(name, description, currentLocation, isVisible);
	}

	//add unique methods here
} // end of class Handcuffs
