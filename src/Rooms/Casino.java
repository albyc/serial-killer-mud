package Rooms;

import java.util.List;

import Items.Item;
import MOBs.MOB;
import Players.Player;

/**
 * This class...
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public class Casino extends Room
{
	/**
	 * 
	 * @param name
	 * @param description
	 * @param items
	 * @param players
	 * @param mobs
	 * @param references
	 */
	public Casino(String name, String description, List<Item> items, List<Player> players, List<MOB> mobs, List<Room> references){
		super(name, description, items, players, mobs, references);
	}

	/**
	 * 
	 */
	@Override
	public void setNextRoom(Room room) 
	{
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
	@Override
	public void removePlayer(Player player) 
	{
		// TODO Auto-generated method stub
		players.remove(player);
	}
	
}
