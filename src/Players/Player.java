package Players;

import java.util.ArrayList;

import Items.Item;
import Rooms.SceneRoom;

/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public abstract class Player {
 
    private String username;
    private String password;
    private String gameName;
    private SceneRoom currentLocation;
    private ArrayList<Item> backpack;
     
    public Player(String userName, String password, String gameName){
        this.username = username;
        this.password = password;
        this.gameName = gameName;
    }
     
    public String getUsername(){
        return username;
    }
     
    public String getPassword(){
        return password;
    }
     
    public String getGameName(){
        return gameName;
    }
     
    public SceneRoom getCurrentLocation(){
        return currentLocation;
    }
     
    public ArrayList getItemsList(){
        return backpack;
    }
     
    public void changeRoom(SceneRoom newRoom){
        currentLocation = newRoom;
    }
     
    public void pickUpItem(Item newItem){
        backpack.add(newItem);
    }
     
    public void dropItem(Item itemToGetRidOf){
        backpack.remove(itemToGetRidOf);
    }
     
    public void interactWithOtherPlayer(){
         
    }
     
    public void InteractWithMOB(){
         
    }
     
    public void fight(){
         
    }
     
    public void defend(){
         
    }
     
    public void run(){
         
    }
     
}//end Player class