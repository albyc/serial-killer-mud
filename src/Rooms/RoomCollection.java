package Rooms;

import java.util.*;

/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron     
 *
 */
public class RoomCollection 
{
	private List<Room> rooms;
	
	public RoomCollection()
	{
		rooms = new ArrayList<Room>();
		addDefaultRooms();
	}
	
	private void addDefaultRooms()
	{
		Room murderCastle = new SceneRoom("Murder Castle", "stuff...", null);
		Room farmhouse = new SceneRoom("Wisconsin Farmhouse of Horrors", "stuff...", null);
		
		murderCastle.setNorthRoom(farmhouse);
		farmhouse.setSouthRoom(murderCastle);
	}

//	public Room getRoomAt(int index)
//	{
//		return roomCollection[index];
//	}
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
