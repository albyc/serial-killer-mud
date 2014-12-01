package MOBs;

import java.util.ArrayList;

import Items.Item;
import Rooms.Room;

public class Killer extends MOB{
	private final static boolean isKiller = true;

	public Killer(String identity, ArrayList<Item> items, ArrayList<String> stuffToSay, Room startLocation) {
		super(identity, items, stuffToSay, startLocation);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isKiller() {
		return isKiller;
		
	}

	@Override
	public void action1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void action2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void action3() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void action4() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void action5() {
		// TODO Auto-generated method stub
		
	}



}
