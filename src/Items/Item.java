package Items;
import Rooms.Room;

/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public abstract class Item {

	protected String name;
	protected String description;
	protected Room currentLocation;
	protected boolean isVisible;
	protected boolean isPickedUp;
	
	public Item(String name, String description, Room currentLocation, boolean isVisible, boolean isPickedUp){
		this.name = name;
		this.description = description;
		this.currentLocation = currentLocation;
		this.isPickedUp = isPickedUp;
	}
	
	public void setLocation(Room room){
		currentLocation = room;
	}
	
	public void hide(){
		isVisible = false;
	}
	
	public void reveal(){
		isVisible = true;
	}
}
