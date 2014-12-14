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
	
	public boolean hasNorth(){
		if(northRoom != null)
			return true;
		return false;
	}
	
	public boolean hasSouth(){
		if(southRoom != null)
			return true;
		return false;
	}
	
	public boolean hasWest(){
		if(westRoom != null)
			return true;
		return false;
	}
	
	public boolean hasEast(){
		if(eastRoom != null)
			return true;
		return false;
	}
	
	
	
	public boolean hasMOB(String name) {
		name = name.toLowerCase();
		for(MOB m : mobs){
			if(m.getIdentity().equals(name))
				return true;
		}
		return false;
	}
	
	public MOB getMobByName(String name) {
		for(MOB m : mobs){
			if(m.getIdentity().equals(name))
				return m;
		}
		return null;
	}
	
	
	public Item getItemByName(String name){
		name = name.toLowerCase();
		for(Item i : items){
			if(i.getName().equals(name))
				return i;
		}
		return null;
	}
	
	
	
	public String getNamesOfPlayersInRoom(){
		String names = "";
		for(Player p : players){
			names += "\n  ";
			names += p.getUsername();
		}
		return names;
	}
	
	public String getNamesOfMOBsInRoom(){
		String names = "";
		for(MOB m : mobs){
			names += "\n  ";
			names += m.getIdentity();
		}
		return names;
	}

	public String getNamesOfItemsInRoom(){
		String names = "";
		for(Item i : items){
			names += "\n  ";
			names += i.getName();
		}
		return names;
	}
	
	public String getNamesOfAdjacentRooms(){
		String theRooms = "";
		if(hasNorth())
			theRooms += "\n  to the north -- " + getNorthRoom().getRoomName();
		if(hasSouth())
			theRooms += "\n  to the south -- " + getSouthRoom().getRoomName();
		if(hasEast())
			theRooms += "\n  to the east -- " + getEastRoom().getRoomName();
		if(hasWest())
			theRooms += "\n  to the west -- " + getWestRoom().getRoomName();
		return theRooms;
	}


}