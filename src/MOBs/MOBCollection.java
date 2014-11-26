package MOBs;

import java.util.*;

import Items.Item;
import Rooms.Room;

public class MOBCollection
{
	private List<MOB> theMOBS;
	
	private Killer drHenryHowardHolmes;
	private Killer jefferyDahmer;
	private Killer lawrenceBittaker;
	private Killer royNorris;
	
	private NonKiller victim;
	private NonKiller foodStandGuy;
	
	public MOBCollection(Room[] rooms){
		drHenryHowardHolmes = new Killer("Dr. Henry Howard Holmes", new ArrayList<Item>(), new ArrayList<String>(), rooms[0]);
		jefferyDahmer = new Killer("Jeffery Dahmer", new ArrayList<Item>(), new ArrayList<String>(), rooms[0]); 
		lawrenceBittaker = new Killer("Lawrence Bittaker", new ArrayList<Item>(), new ArrayList<String>(), rooms[0]);
		royNorris = new Killer("Roy Norris", new ArrayList<Item>(), new ArrayList<String>(), rooms[0]);
		victim = new NonKiller("Victim", new ArrayList<Item>(), new ArrayList<String>(), rooms[0]);
		foodStandGuy = new NonKiller("Food Stand guy", new ArrayList<Item>(), new ArrayList<String>(), rooms[0]);
	}
///rtmnbdcjdwbfhje
	
	public MOB getMOB(int index) {
		switch(index) {
			case 0:
				return drHenryHowardHolmes;
			case 1:
				return jefferyDahmer;
			case 2:
				return lawrenceBittaker;
			case 3:
				return royNorris;
			case 4:
				return victim;
			case 5:
				return foodStandGuy;
			default:
				return null;
		}	
	}
	
//	public Mob getItemFromName(String name){
//		
//		for (Item ii: itumss)
//		{
//			if (ii.getName().equals(name))
//			{
//				System.out.println("found it");
//				return ii;
//			}
//		}
//		
//		return null;
//		
//	}
}
