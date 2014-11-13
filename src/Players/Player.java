package Players;

import java.util.ArrayList;

import Items.Item;
import Rooms.Room;

/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public abstract class Player 
{
    private String username;
    private String password;
    private String gameName;
    private Room currentLocation;
    private ArrayList<Item> backpack;
     
    /**
     * 
     * @param userName
     * @param password
     * @param gameName
     */
    public Player(String userName, String password, String gameName)
    {
        this.username = username;
        this.password = password;
        this.gameName = gameName;
    }
     
    /**
     * 
     * @return
     */
    public String getUsername()
    {
        return username;
    }
     
    /**
     * 
     * @return
     */
    public String getPassword()
    {
        return password;
    }
     
    /**
     * 
     * @return
     */
    public String getGameName()
    {
        return gameName;
    }
    
    /**
     * 
     * @return
     */
    public Room getCurrentLocation()
    {
        return currentLocation;
    }
    
    /**
     * 
     * @return
     */
    public ArrayList getItemsList()
    {
        return backpack;
    }
    
    /**
     * 
     * @param newRoom
     */
    public void changeRoom(Room newRoom)
    {
        currentLocation = newRoom;
    }
    
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