package Rooms;

import java.util.*;

import Items.Item;
import Items.ItemCollection;
import MOBs.MOB;
import MOBs.MOBCollection;
import Players.*;

/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron     
 *
 */
public class RoomCollection 
{
	private List<Room> rooms;
	

	
	private MOBCollection mobCollection;
	private ItemCollection itemCollection;
	
	
	private Room entrance;
	private Item[] items;
	private Room lawn;
	private Room murderCastle;
	private Room farmhouse;
	
	public RoomCollection()
	{
		rooms = new ArrayList<Room>();
		itemCollection = new ItemCollection(items);
		mobCollection = new MOBCollection();
		
		
		

		
		addDefaultRooms();
	} 
	
	private void addDefaultRooms()
	{
		List<Item> itemsInMurderCastle = new ArrayList<Item>();
		List<Item> itemsInFarmhouse = new ArrayList<Item>();
		List<Item> itemsInLawn = new ArrayList<Item>();
		itemsInMurderCastle.add(itemCollection.getItem(0));
		itemsInMurderCastle.add(itemCollection.getItem(1));
		itemsInFarmhouse.add(itemCollection.getItem(2));
		itemsInFarmhouse.add(itemCollection.getItem(3));
		itemsInLawn.add(itemCollection.getItem(4));
		
		murderCastle = new SceneRoom("Murder Castle", "601-603 W. 63rd St. Chicago. Home of Dr. Henry Howard Holmes. Three stories and a block long.", itemsInMurderCastle);
		farmhouse = new SceneRoom("Wisconsin Farmhouse of Horrors", "Average farmhouse, nothing in particular", itemsInFarmhouse);
		lawn = new SceneRoom("The Lawn", "small area of dead grass", itemsInLawn);
		entrance = lawn;
		
		lawn.setNorthRoom(murderCastle);
		murderCastle.setNorthRoom(farmhouse);
		murderCastle.setSouthRoom(lawn);
		farmhouse.setSouthRoom(murderCastle);
		
		rooms.add(murderCastle);
		rooms.add(farmhouse);
		rooms.add(lawn);
	}
	
	public List<Room> getRooms(){
		return rooms;
	}

	public Room getRoomAt(int index)
	{
		return rooms.get(index);
	}
	
	public void addPlayerToRooms(Player player)
	{
		entrance.addPlayer(player);
		
		// Make sure that the player is holding a reference
		// to the room it is located in. In this case, that
		// would be the entrance to the game. 
		player.setLocation(entrance);
	}
	
//	public void setRoomsPlayerList(List<Player> players, int index)
//	{
//		switch(index)
//		{
//		case 0:
//			playersInMurderCastle = players;
//			break;
//		case 1:
//			playersInFarmhouse = players;
//			break;
//		case 2:
//			playersInLawn = players;
//		}
//	}
//	
//	public boolean isItemInRoom(Room room, Item item)
//	{
//		
//		
//		String name = room.getRoomName().toLowerCase();
//		
//			for(Item i : lawn.getItems())
//			{
//				if(i.getName() == item.getName())
//				{
//					return lawn;
//				}
//			}
//		
//			for(Item i : murderCastle.getItems())
//			{
//				if(i.getName() == item.getName())
//				{
//					return murderCastle;
//				}
//			}
//		
//			for(Item i : farmhouse.getItems())
//			{
//				if(i.getName() == item.getName())
//				{
//					return farmhouse;
//				}
//			}
//	
//		
//		return null;
//	}
	
}
