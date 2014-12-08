package Rooms;

import java.io.Serializable;
import java.util.*;

import Items.Item;
import MOBs.*;
import Players.*;

/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public abstract class Room implements Serializable
{
	private static final long serialVersionUID = -392554011670131427L;
	protected String name;
	protected String description;
	protected List<Player> players;
	protected List<MOB> mobs;
	protected List<Item> items;
	private Room northRoom, southRoom, eastRoom, westRoom;
	
	public Room(String name, String description)
	{
		this.name = name;
		this.description = description;
		this.players = new ArrayList<Player>();
		this.mobs = new ArrayList<MOB>();
		this.items = new ArrayList<Item>();
		
		// initially, a Room does not have any adjacent Rooms
		northRoom = null;
		southRoom = null;
		eastRoom = null;
		westRoom = null;
	}
	
	public String getRoomName() { return name; }
	
	public String getRoomDescription() { return description; }
	
	public List<Player> getPlayers() { return players; }
	
	public List<MOB> getMOBs() { return mobs; }
	
	public List<Item> getItems() { return items; }
	
	
	
	public void addPlayer(Player aPlayer) { players.add(aPlayer); }
	
	public void removePlayer(Player player) { players.remove(player); }	
	
	public void addMOB(MOB anMOB) { mobs.add(anMOB); }
	
	public void removeMOB(MOB anMOB) { mobs.remove(anMOB); }
	
	public void addItem(Item anItem) { items.add(anItem); }
	
	public void removeItem(Item anItem) { items.remove(anItem); }
	
	
	
	public void setNorthRoom(Room aRoom) { northRoom = aRoom; }
	
	public Room getNorthRoom() { return northRoom; }
	
	public void setSouthRoom(Room aRoom) { southRoom = aRoom; }
	
	public Room getSouthRoom() { return southRoom; }
	
	public void setEastRoom(Room aRoom) { eastRoom = aRoom; }
	
	public Room getEastRoom() { return eastRoom; }
	
	public void setWestRoom(Room aRoom) { westRoom = aRoom; }
	
	public Room getWestRoom() { return westRoom; }
	
	
	public boolean hasItem(Item i){
		if(items.contains(i))
			return true;
		return false;
	}
	
	
	public String getNamesOfPlayersInRoom(){
		String names = "";
		for(Player p : players){
			names += "\t";
			names += p.getUsername();
			names += "\n";
		}
		return names;
	}
	
	public String getNamesOfMOBsInRoom(){
		String names = "";
		for(MOB m : mobs){
			names += "\t";
			names += m.getIdentity();
			names += "\n";
		}
		return names;
	}

	public String getNamesOfItemsInRoom(){
		String names = "";
		for(Item i : items){
			names += "\t";
			names += i.getName();
			names += "\n";
		}
		return names;
	}
}