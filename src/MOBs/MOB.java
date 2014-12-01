package MOBs;

//import java.awt.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Random;

import Items.Item;
import Items.Item;
import Players.Player;
import Rooms.Room;

/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 * 
 */

public abstract class MOB {
	private String identity;
	private ArrayList<Item> pocket;
	private Room currentLocation;
	private ArrayList<String> speeches;
	private int health;
	private Random randomGenerator;

	public MOB(String identity, ArrayList<Item> items, ArrayList<String> stuffToSay, Room startLocation) {
		randomGenerator = new Random();
		this.identity = identity;
		pocket = new ArrayList<Item>();
		this.speeches = stuffToSay;
		currentLocation = startLocation;
	}

	public abstract void action1();

	public abstract void action2();

	public abstract void action3();
	
	public abstract void action4();
	
	public abstract void action5();
	
	public abstract boolean isKiller();
	
	public String getIdentity(){
		return identity;
	}

	public void speak(int x) {
		System.out.println(speeches.get(x));
	}

	public void addItemToPocket(Item newItem) {
		pocket.add(newItem);
	}

	public void removeItemFromPocket(Item toBeRemoved) {
		pocket.remove(toBeRemoved);
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

	public void attack(Player thePlayer) {
		int points = randomGenerator.nextInt(10);
		thePlayer.incrementHealth(points);
	}

	public void run() {
		//exit to next nearest room
	}
	
	public void whoAmI() {
		// TODO Auto-generated method stub
		System.out.println("I am" + identity);
	}

}
