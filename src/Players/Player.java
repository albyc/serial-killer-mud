package Players;

import java.io.*;
import java.util.*;

import Items.*;
import Rooms.*;

/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public class Player
{
    private String username;
    private String password;
    private Room currentLocation;
    private List<Item> backpack;
    private int health; //max health is 100
     
    public Player(String username, String password, List<Item> backpack)
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
     
    public void changeRoom(SceneRoom newRoom){
    	//erase self from room and add self to new room
        currentLocation = newRoom;
    }

    // public String getPassword() { return password; }
    
    public Room getLocation() { return currentLocation; }
    
    public List<Item> getItems() { return backpack; }
    
    public int getHealth() { return health; }
    
    /**
     * 
     * @param newItem
     */
    public void pickUpItem(Item newItem)
    {
        backpack.add(newItem);
    }
    
    /**
     * 
     * @param itemToGetRidOf
     */
    public void dropItem(Item itemToGetRidOf)
    {
        backpack.remove(itemToGetRidOf);
    }
    
    /**
     * 
     */
    public void interactWithOtherPlayer()
    {
         
    }
    
    /**
     * 
     */
    public void InteractWithMOB()
    {
         
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
}//end of class Player
