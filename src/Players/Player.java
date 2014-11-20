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
public abstract class Player
{
    private String username;
    private String password;
    private Room currentLocation;
    private List<Item> backpack;
     
    public Player(String username, String password)
    {
        this.username = username;
        this.password = password;
        backpack = new ArrayList<Item>();
    }
    
	public boolean matches(char[] entered)
	{
		return new String(entered).equals(password); 
	}
    
    public String getUsername() { return username; }
     
    // public String getPassword() { return password; }
    
    public Room getCurrentLocation() { return currentLocation; }
    
    public List<Item> getItems() { return backpack; }
    
    public void changeCurrRoom(Room aRoom) { currentLocation = aRoom; }
    
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
