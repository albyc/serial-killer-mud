package Items;
import Rooms.Room;

/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public abstract class Item 
{
	protected String name;
	protected String description;
	protected Room currentLocation;
	protected boolean isVisible;
	protected boolean isPickedUp;
	
<<<<<<< HEAD
	/**
	 * 
	 * @param name Name of the item
	 * @param description Description of the item
	 * @param currentLocation The room in which the item is currently located
	 * @param isVisible Indicates whether item is currently visible
	 */
	public Item (String name, String description, Room currentLocation, boolean isVisible)
	{
=======
	public Item(String name, String description, Room currentLocation, boolean isVisible, boolean isPickedUp){
>>>>>>> d84c7b4567b93f1408103968792191f9976ebb2f
		this.name = name;
		this.description = description;
		this.currentLocation = currentLocation;
		this.isPickedUp = isPickedUp;
	}
	
	/**
	 * Sets the location of the item. 
	 * 
	 * @param room The room in which the item is currently located
	 */
	public void setLocation(Room room)
	{
		currentLocation = room;
	}
	
	/**
	 * Hides item from players.
	 */
	public void hide()
	{
		isVisible = false;
	}
	
	/**
	 * Allows players to see the item. 
	 */
	public void reveal()
	{
		isVisible = true;
	}
} // end of class Item
