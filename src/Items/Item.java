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
	
	public Item(String name, String description, Room currentLocation, boolean isVisible){
		this.name = name;
		this.description = description;
		this.currentLocation = currentLocation;
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
