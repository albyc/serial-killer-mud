package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;

import Rooms.*;
import Items.Item;
import MOBs.*;
import Players.*;

/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public class SerialKillerMud
{
	private RoomCollection roomCollection;
	private transient List<Player> playersOnline;
	private transient List<Player> administrators;
	private transient MOBCollection mobc;
	private transient List<MOB> mobs;
	
	public SerialKillerMud()
	{
		roomCollection = new RoomCollection();
		playersOnline = new ArrayList<Player>();
		administrators = new ArrayList<Player>();
		mobc = new MOBCollection();
		mobs = mobc.getAllMOBS();
		addAdmins();
	}

	private void addAdmins()
	{
		Player admin = new Player("admin", "0000");
		
		administrators.add(admin);
	}

	public void addPlayerToGame(Player player)
	{		
		// Add the new player to the collection of existing players
		playersOnline.add(player);
		
		// Add the player to the rooms. Initially, every new player
		// will start out in the same location. 
		roomCollection.addNewPlayerToRooms(player);
	}
	
	public List<Player> getPlayersOnline()
	{
		return playersOnline;
	}
	
	public List<Player> getAdministrators()
	{
		return administrators;
	}
	
	public RoomCollection getRoomCollection()
	{
		return roomCollection;
	}
	
	public MOBCollection getMOBCollection()
	{	
		return mobc;
	}
	
	public List<MOB> getListOfMOBs()
	{
		return mobs;
	}

	public TimerTask updateMOBsOnTimer() {
		Random random = new Random();
		for(MOB m : mobs){
			System.out.println(m.getIdentity());
			int direction = random.nextInt(4);
			switch(direction){
			case 0:
				try{
					m.changeRoom(m.getCurrentLocation().getEastRoom());
				}catch(Exception e){
					e.printStackTrace();
				}
				break;
			case 1:
				try{
					m.changeRoom(m.getCurrentLocation().getWestRoom());
				}catch(Exception e){
					e.printStackTrace();
				}
				break;
			case 2:
				try{
					m.changeRoom(m.getCurrentLocation().getNorthRoom());
				}catch(Exception e){
					e.printStackTrace();
				}
				break;
			case 3:
				try{
					m.changeRoom(m.getCurrentLocation().getSouthRoom());
				}catch(Exception e){
					e.printStackTrace();
				}
				break;
			default:
				try{
					m.changeRoom(m.getCurrentLocation().getNorthRoom());
				}catch(Exception e){
					e.printStackTrace();
				}
				break;
			}
			
		}
		return null;
	}
	
} // end of class SerialKillerMud
