package Items;
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
	protected SceneRoom currentLocation;
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

	public Item(String name, String description, Room currentLocation, boolean isVisible, boolean isPickedUp)
	{
=======
	public Item(String name, String description, SceneRoom currentLocation, boolean isVisible, boolean isPickedUp){
>>>>>>> 9df47dc168dc11191d7b5deff0d61b4b0d58b35f
		this.name = name;
		this.description = description;
		this.currentLocation = currentLocation;
		this.isPickedUp = isPickedUp;
	}
	
<<<<<<< HEAD
	/**
	 * Sets the location of the item. 
	 * 
	 * @param room The room in which the item is currently located
	 */
	public void setLocation(Room room)
	{
=======
	public void setLocation(SceneRoom room){
>>>>>>> 9df47dc168dc11191d7b5deff0d61b4b0d58b35f
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
