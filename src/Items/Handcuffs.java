package Items;

import Rooms.Room;

/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
<<<<<<< HEAD
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
=======
public class Handcuffs extends Item{

	public Handcuffs(String name, String description, Room currentLocation, boolean isVisible, boolean isPickedUp){
		super(name, description, currentLocation, isVisible, isPickedUp);
>>>>>>> d84c7b4567b93f1408103968792191f9976ebb2f
	}

	//add unique methods here
} // end of class Handcuffs
