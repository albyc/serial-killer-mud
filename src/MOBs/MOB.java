package MOBs;

<<<<<<< HEAD
import java.awt.List;
import java.util.ArrayList;

import Items.Item;

import com.sun.tools.javac.jvm.Items;

=======
import java.util.List;

import Items.Item;

>>>>>>> 0e6dbad85a1e0692ff665f6d4febe37ac91a0826
/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 * 
 */
<<<<<<< HEAD
public abstract class MOB {
	private String identity;
	private ArrayList<Item> pocket;
	private Room currentLocation;
	private ArrayList<String> speeches;

	public MOB(String identity, ArrayList<Item> items, ArrayList<String> stuffToSay) {
		this.identity = identity;
		pocket = new ArrayList<Item>();
		this.speeches = stuffToSay;
	}

	public abstract void action1();

	public abstract void action2();

	public abstract void action3();
	
	public abstract void action4();
	
	public abstract void action5();

	public void speak(int x) {
		System.out.println(speeches.get(x));
	}

	public void addItemToPocket(Item newItem) {
		pocket.add(newItem);
	}

	public void removeItemFromPocket(Item toBeRemoved) {
		pocket.remove(toBeRemoved);
=======
public abstract class MOB 
{
	private String name;
	private String description;
	private List<Item> items;
	private int health; // ??
	
	/**
	 * 
	 * @param name
	 * @param description
	 */
	public MOB(String name, String description)
	{
		this.name = name;
	}
	
	/**
	 * 
	 * @param anItem
	 */
	public void addItem(Item anItem)
	{
		
>>>>>>> 0e6dbad85a1e0692ff665f6d4febe37ac91a0826
	}

	public void changeRoom(Room newRoom) {
		currentLocation = newRoom;
		// erase self from room and add self to new room
	}

	public Room getCurrentLocation() {
		return currentLocation;
	}

	public void giveItemToPlayer() {
		// give item to player
	}

	public void attack() {

	}

	public void run() {

	}

}
