package Items;
import Rooms.Room;

/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public abstract class Item {

	private String name;
	private String description;
	
	public Item(String name, String description){
		this.name = name;
		this.description = description;
	}
	
	public abstract void setLocation(Item item, Room room);
	
	public abstract void hide(Item item);
	
	public abstract void reveal(Item item);
}
