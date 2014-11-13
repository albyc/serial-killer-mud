package Rooms;

/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public class RoomCollection 
{
	private Room[][][] roomCollection = new Room[3][4][3];
	
	public RoomCollection(Room room1, Room room2, Room room3, Room room4, Room room5, Room room6,Room room7,Room room8,
			Room room9, Room room10,Room room11,Room room12,Room room13,Room room14,Room room15,Room room16,Room room17,Room room18,
			Room room19,Room room20,Room room21,Room room22,Room room23,Room room24,Room room25,Room room26,Room room27,Room room28,
			Room room29,Room room30){
		
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
	
	public Room getRoomAt(int row, int col, int height)
	{
		return roomCollection[row][col][height];
	}
	
	public void setRoomAt(int row, int col, int height, Room room)
	{
		roomCollection[row][col][height] = room;
	}
	
	
}
