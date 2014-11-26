package MOBs;

import java.util.*;

import Items.Item;
import Rooms.Room;

public class MOBCollection
{
	private List<MOB> theMOBs;
	
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
	
	public List<MOB> getAllMOBS(){
		return theMOBs;
	}
	
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
	
	public MOB getItemFromName(String name){
		for (MOB mob: theMOBs)
		{
			if (mob.getIdentity().equals(name))
			{
				System.out.println("found it");
				return mob;
			}
		}
		return null;
	}
}
