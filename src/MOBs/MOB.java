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

public class MOB {
	private String identity;
	private ArrayList<Item> pocket;
	private Room currentLocation;
	private ArrayList<String> speeches;
	private int health;
	private Random randomGenerator;
	private final static int MAXHEALTH = 100;
    private final static int MAX_ITEMS = 5;

	public MOB(String identity, ArrayList<Item> items, ArrayList<String> stuffToSay) {
		randomGenerator = new Random();
		this.identity = identity;
		pocket = new ArrayList<Item>();
		this.speeches = stuffToSay;
		health = 100;
	}

//	public abstract void action1();
//
//	public abstract void action2();
//
//	public abstract void action3();
//	
//	public abstract void action4();
//	
//	public abstract void action5();
	
	
	public String getIdentity(){ return identity; }

	public void speak(int x) { System.out.println(speeches.get(x)); }

	public void addItemToPocket(Item newItem) { pocket.add(newItem); }

	public void removeItemFromPocket(Item toBeRemoved) { pocket.remove(toBeRemoved); }

	public void changeRoom(Room newRoom) {
		currentLocation = newRoom;
		// erase self from room and add self to new room
	}

	public Room getCurrentLocation() { return currentLocation; }

	public void giveItemToPlayer(Item item) {
		// give item to player
	}

	public void attack(Player thePlayer) {
		int points = randomGenerator.nextInt(10);
		thePlayer.incrementHealth(points);
		
	}

	public void run() {
		//exit to next nearest room
//		if(currentLocation.getNorthRoom() != null)
//			change
	}
	
	public void incrementHealth(int amount){
		health += amount;
		if(health <= 0)
			death();
	}
	
	public void whoAmI() {
		System.out.println("I am" + identity);
	}
	
	public void death(){
		//drop all holding items
		for(Item item : pocket)
			currentLocation.addItem(item);
		pocket = null;
		
		
		//leave note telling last words/curses/additional information still useful
		
	}
	
	public void interactWithPlayer(Player player){
		//speak to player
		//choose whether to fight to sit back
	}

}
