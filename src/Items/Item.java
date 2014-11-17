package Items;
import Rooms.Room;
import Rooms.SceneRoom;

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
	
	/**
	 * 
	 * @param name Name of the item
	 * @param description Description of the item
	 * @param currentLocation The room in which the item is currently located
	 * @param isVisible Indicates whether item is currently visible
	 */

	public Item(String name, String description, Room currentLocation, boolean isVisible, boolean isPickedUp)
	{
		this.name = name;
		this.description = description;
		this.currentLocation = currentLocation;
		this.isPickedUp = isPickedUp;
		this.isVisible = isVisible;
	}
	
	/**
	 * Sets the location of the item. 
	 * 
	 * @param room The room in which the item is currently located
	 */
	public void setLocation(SceneRoom room)
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
	
	public abstract void use();
	
	public Room getLocation()
	{
		return currentLocation;
	}
	
	public void setLocation(Room room)
	{
		currentLocation = room;
	}
	
	public boolean getIsVisible()
	{
		return isVisible;
	}
	public boolean getIsPickedUp()
	{
		return isPickedUp;
	}
	
	public void setIsPickedUp(boolean isPickedUp)
	{
		this.isPickedUp = isPickedUp;
	}
		
	
	
} // end of class Item
