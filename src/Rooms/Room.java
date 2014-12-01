package Rooms;

import java.io.Serializable;
import java.util.*;

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
	protected List<Player> mobs;
	private Room northRoom, southRoom, eastRoom, westRoom;
	//protected RoomCollection roomCollection;
	
	public Room(String name, String description)
	{
		this.name = name;
		this.description = description;
		this.players = new ArrayList<Player>();
		this.mobs = new ArrayList<Player>();
		
		// initially, a Room does not have any adjacent Rooms
		northRoom = null;
		southRoom = null;
		eastRoom = null;
		westRoom = null;
	}
	
	public String getName() { return name; }
	
	public String getDescription() { return description; }
	
	public List<Player> getPlayers() { return players; }
	
	public List<Player> getMOBs() { return mobs; }
	
	public void addPlayer(Player aPlayer) { players.add(aPlayer); }
	
	public void removePlayer(Player player) { players.remove(player); }	
	
	public void addMOB(MOB anMOB) { mobs.addAll((Collection<? extends Player>) anMOB); }
	
	public void removeMOB(MOB anMOB) { mobs.remove(anMOB); }
	
	public void setNorthRoom(Room aRoom) { northRoom = aRoom; }
	
	public Room getNorthRoom() { return northRoom; }
	
	public void setSouthRoom(Room aRoom) { southRoom = aRoom; }
	
	public Room getSouthRoom() { return southRoom; }
	
	public void setEastRoom(Room aRoom) { eastRoom = aRoom; }
	
	public Room getEastRoom() { return eastRoom; }
	
	public void setWestRoom(Room aRoom) { westRoom = aRoom; }
	
	public Room getWestRoom() { return westRoom; }
	
	public String getNamesOfPlayersInRoom(){
		String names = "";
		
		return names;
	}
	
	public String getNamesOfMOBsInRoom(){
		String names = "";
		return names;
	}
}
