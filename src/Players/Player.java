package Players;

import java.io.*;
import java.util.*;

import Items.*;
import MOBs.MOB;
import Rooms.*;

/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public class Player implements Serializable
{
	private static final long serialVersionUID = 273382826880053009L;
	private String username;
    private String password;
    private Room currentLocation;
    private List<Item> backpack;
    private int health;
    private final static int MAXHEALTH = 100;
    private final static int MAX_ITEMS = 5;
    
     
    public Player(String username, String password)
    {
        this.username = username;
        this.password = password;
        backpack = new ArrayList<Item>();
        health = 50;
    }
    
    public void setLocation(Room aRoom)
    {
    	currentLocation = aRoom;
    }
    
	public boolean matches(char[] entered)
	{
		return new String(entered).equals(password); 
	}
    
    public String getUsername() { return username; }
     
    public void changeRoom(Room room){
    	//erase self from room and add self to new room
        currentLocation = room;
    }
    
    public Room getLocation() { return currentLocation; }
    
    public List<Item> getItems() { return backpack; }
    
    public int getHealth() { return health; }
    
    public void incrementHealth(int amount){
    	int newHealth = health + amount;
    	if(newHealth > MAXHEALTH)
    		health = 100;
    	else if(newHealth <= 0)
    		death();
    	else
    		health = newHealth;
    }
    
    public void death(){
    	//create window to state death //deactivate button listener for commands
    }
    
    /**
     * 
     * @param newItem
     */
    public boolean pickUpItem(Item newItem)
    {
    	if(backpack.size() < MAX_ITEMS){
    		backpack.add(newItem);
    		return true;
    	}
    	return false;
    }
    
    /**
     * 
     * @param itemToGetRidOf
     */
    public boolean dropItem(Item itemToGetRidOf)
    {
    	if(backpack.contains(itemToGetRidOf)){
    		backpack.remove(itemToGetRidOf);
    		return true;
    	}
    	return false;
    }
    
    /**
     * 
     */
    public void interactWithOtherPlayer(Player thePlayer)
    {
         //talk to other player determine if going to fight or what
    	//fight()
    }
    
    /**
     * 
     */
    public void InteractWithMOB(MOB theMOB)
    {
         //mob talks and states what items it holds, good or bad, etc
    	//fight()
    }
    
    /**
     * 
     */
    public void fight()
    {
         
    }
    
    /**
     * 
     */
    public void defend()
    {
         
    }
    
    /**
     * 
     */
    public void run()
    {
         
    }
    
//    public void setBackpack(List<Item> list)
//    {
//    	backpack = list;
//    }

//	public void setHealth(int health) {
//		this.health = health;
//	}
}//end of class Player
