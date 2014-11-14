package Controller;

import java.util.ArrayList;
import java.util.List;

import MOBs.MOB;
import Players.Player;
import Rooms.RoomCollection;
import Rooms.SceneRoom;
import Rooms.TrappingRoom;

import java.util.List;

/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public class Client 
{
	//needs a lot of fixing - just testing to see if room abstract class/ subclass objects work
	List<Player> playersInRoom = new ArrayList<Player>();
	List<MOB> mobsInRoom = new ArrayList<MOB>(); 
	RoomCollection roomCollection = new RoomCollection(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
	SceneRoom exit = new SceneRoom(null, null, null, playersInRoom, mobsInRoom, null);
	TrappingRoom desert = new TrappingRoom("Desert", "The Desert room is a trapping room, so your chance of escaping is 50/50.", playersInRoom, mobsInRoom, exit);
	TrappingRoom jail = new TrappingRoom("Jail", "The Jail room is a trapping room, so your chance of escaping is 50/50.", playersInRoom, mobsInRoom, exit);


	public void update(List<String> messages) {
		
	}

}
