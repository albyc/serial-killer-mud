package Rooms;

import java.util.*;

import Items.Item;
import Items.ItemCollection;
import Players.*;

/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron     
 *
 */
public class RoomCollection 
{
	private List<Room> rooms;
	private List<Item> itemsInMurderCastle;
	private List<Item> itemsInFarmhouse;
	private List<Item> itemsInLawn;
	private List<Player> playersInMurderCastle;
	private List<Player> playersInFarmhouse;
	private List<Player> playersInLawn;
	private Room entrance;
	private Item[] items;
	private ItemCollection itemCollection = new ItemCollection(items);
	public RoomCollection()
	{
		rooms = new ArrayList<Room>();
		itemsInMurderCastle = new ArrayList<Item>();
		itemsInFarmhouse = new ArrayList<Item>();
		itemsInLawn = new ArrayList<Item>();
		itemsInMurderCastle.add(itemCollection.getItem(0));
		itemsInMurderCastle.add(itemCollection.getItem(1));
		itemsInFarmhouse.add(itemCollection.getItem(2));
		itemsInFarmhouse.add(itemCollection.getItem(3));
		itemsInLawn.add(itemCollection.getItem(4));
		
		playersInMurderCastle = new ArrayList<Player>();
		playersInFarmhouse = new ArrayList<Player>();
		playersInLawn = new ArrayList<Player>();
		addDefaultRooms();
	} 
	
	private void addDefaultRooms()
	{
		Room murderCastle = new SceneRoom("Murder Castle", "601-603 W. 63rd St. Chicago. Home of Dr. Henry Howard Holmes. Three stories and a block long.", itemsInMurderCastle);
		Room farmhouse = new SceneRoom("Wisconsin Farmhouse of Horrors", "Average farmhouse, nothing in particular", itemsInFarmhouse);
		Room lawn = new SceneRoom("The Lawn", "small area of dead grass", itemsInLawn);
		entrance = lawn;
		
		lawn.setNorthRoom(murderCastle);
		murderCastle.setNorthRoom(farmhouse);
		murderCastle.setSouthRoom(lawn);
		farmhouse.setSouthRoom(murderCastle);
		rooms.add(murderCastle);
		rooms.add(farmhouse);
		rooms.add(lawn);
	}

	public void addPlayerToRooms(Player player)
	{
		entrance.addPlayer(player);
		
		// Make sure that the player is holding a reference
		// to the room it is located in. In this case, that
		// would be the entrance to the game. 
		player.setLocation(entrance);
	}
	
	

	public Room getRoomAt(int index)
	{
		return rooms.get(index);
	}
	
	public void setRoomsPlayerList(List<Player> players, int index)
	{
		switch(index)
		{
		case 0:
			playersInMurderCastle = players;
			break;
		case 1:
			playersInFarmhouse = players;
			break;
		case 2:
			playersInLawn = players;
		}
	}
	
	/*public List<Player> getPlayers(int index) 
	{ 
		switch(index){
		case 0:
			return 
		}
	}*/
//	
//	public void setRoomAt(int index, Room room)
//	{
//		roomCollection[index] = room;
//	}
	/*private SceneRoom[][][] roomCollection = new SceneRoom[3][4][3];
	
	public RoomCollection(SceneRoom room1, SceneRoom room2, SceneRoom room3, SceneRoom room4, SceneRoom room5, SceneRoom room6,SceneRoom room7,SceneRoom room8,
			SceneRoom room9, SceneRoom room10,SceneRoom room11,SceneRoom room12,SceneRoom room13,SceneRoom room14,SceneRoom room15,SceneRoom room16,SceneRoom room17,SceneRoom room18,
			SceneRoom room19,SceneRoom room20,SceneRoom room21,SceneRoom room22,SceneRoom room23,SceneRoom room24,SceneRoom room25,SceneRoom room26,SceneRoom room27,SceneRoom room28,
			SceneRoom room29,SceneRoom room30){
		
		roomCollection[0][0][0] = room1;
		roomCollection[0][1][0] = room2;
		roomCollection[0][2][0] = room3;
		roomCollection[0][3][0] = room4;
		roomCollection[1][0][0] = room5;
		roomCollection[1][1][0] = room6;
		roomCollection[1][2][0] = room7;
		roomCollection[1][3][0] = room8;
		roomCollection[2][0][0] = room9;
		roomCollection[2][1][0] = room10;
		roomCollection[2][2][0] = room11;
		roomCollection[2][3][0] = room12;
		roomCollection[0][0][1] = room13;
		roomCollection[0][1][1] = room14;
		roomCollection[0][2][1] = room15;
		roomCollection[0][3][1] = room16;
		roomCollection[1][0][1] = room17;
		roomCollection[1][1][1] = room18;
		roomCollection[1][2][1] = room19;
		roomCollection[1][3][1] = room20;
		roomCollection[2][0][1] = room21;
		roomCollection[2][1][1] = room22;
		roomCollection[2][2][1] = room23;
		roomCollection[2][3][1] = room24;
		roomCollection[0][0][1] = room25;
		roomCollection[0][1][1] = room26;
		roomCollection[0][2][1] = room27;
		roomCollection[0][3][1] = room28;
		roomCollection[1][0][2] = room29;
		roomCollection[1][1][2] = room30;	
	}
	
	public SceneRoom getRoomAt(int row, int col, int height)
	{
		return roomCollection[row][col][height];
	}
	
	public void setRoomAt(int row, int col, int height, SceneRoom room)
	{
		roomCollection[row][col][height] = room;
	}
	
	public int getRoomRow(SceneRoom room){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 4; j++){
				for(int k = 0; k < 3; k++){
					if(roomCollection[i][j][k] == room){
						return i;
					}
				}
			}
		}
		return -1;
	}

	public int getRoomCol(SceneRoom room) {
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 4; j++){
				for(int k = 0; k < 3; k++){
					if(roomCollection[i][j][k] == room){
						return j;
					}
				}
			}
		}
		return -1;
	}

	public int getRoomHeight(SceneRoom room) {
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 4; j++){
				for(int k = 0; k < 3; k++){
					if(roomCollection[i][j][k] == room){
						return k;
					}
				}
			}
		}
		return -1;		
	}*/
	
}
