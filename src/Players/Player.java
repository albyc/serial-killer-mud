package Players;

import java.util.ArrayList;

import Items.Item;
import Rooms.SceneRoom;

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
    private SceneRoom currentLocation;
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
<<<<<<< HEAD
    
    /**
     * 
     * @return
     */
    public Room getCurrentLocation()
    {
=======
     
    public SceneRoom getCurrentLocation(){
>>>>>>> 9df47dc168dc11191d7b5deff0d61b4b0d58b35f
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
<<<<<<< HEAD
    
    /**
     * 
     * @param newRoom
     */
    public void changeRoom(Room newRoom)
    {
=======
     
    public void changeRoom(SceneRoom newRoom){
>>>>>>> 9df47dc168dc11191d7b5deff0d61b4b0d58b35f
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
