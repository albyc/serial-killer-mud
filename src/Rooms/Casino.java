package Rooms;

import java.util.List;

import Items.Item;
import Players.Player;

public class Casino extends Room{

	public Casino(String name, String description, List<Item> items, List<Player> players, List<MOB> mobs, List<Room> references){
		super(description, items, players, mobs, references);
	}

	@Override
	public void setNextRoom(Room room) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePlayer(Player player) {
		// TODO Auto-generated method stub
		players.remove(player);
	}
	
}
