package MOBs;

import java.util.*;

import Items.Item;
import Rooms.Room;

public class MOBCollection
{
	private List<MOB> theMOBs;
	
	private Killer drHenryHowardHolmes;
	private Killer jefferyDahmer;		//abduct you
	private Killer lawrenceBittaker;
	private Killer royNorris;
	private Killer hannibalLecter;		//cooking in kitchen, will make you food but beware
	private Killer richardRamirez;				//attack just by being in the same room
	private Killer andreChikatilo;				//only attack by talking to
	private Killer richardTrentonChase;
	
	private NonKiller victim;			//warn you of upcoming dangers
	private NonKiller foodStandGuy;		//help you increase you health for battles ahead
	
	public MOBCollection(List<Room> rooms){
		drHenryHowardHolmes = new Killer("Dr. Henry Howard Holmes", new ArrayList<Item>(), new ArrayList<String>(), rooms.get(0));
		jefferyDahmer = new Killer("Jeffery Dahmer", new ArrayList<Item>(), new ArrayList<String>(), rooms.get(0)); 
		lawrenceBittaker = new Killer("Lawrence Bittaker", new ArrayList<Item>(), new ArrayList<String>(), rooms.get(0));
		royNorris = new Killer("Roy Norris", new ArrayList<Item>(), new ArrayList<String>(), rooms.get(0));
		hannibalLecter = new Killer("Hannibal Lecter", new ArrayList<Item>(), new ArrayList<String>(), rooms.get(0));
		richardRamirez = new Killer("Richard Ramirez", new ArrayList<Item>(), new ArrayList<String>(), rooms.get(0));
		andreChikatilo = new Killer("Andre Chikatilo", new ArrayList<Item>(), new ArrayList<String>(), rooms.get(0));
		richardTrentonChase = new Killer("Richard Trenton Chase", new ArrayList<Item>(), new ArrayList<String>(), rooms.get(0));
		
		victim = new NonKiller("Victim", new ArrayList<Item>(), new ArrayList<String>(), rooms.get(0));
		foodStandGuy = new NonKiller("Food Stand guy", new ArrayList<Item>(), new ArrayList<String>(), rooms.get(0));
		
		theMOBs.add(drHenryHowardHolmes);
		theMOBs.add(jefferyDahmer);
		theMOBs.add(lawrenceBittaker);
		theMOBs.add(royNorris);
		theMOBs.add(hannibalLecter);
		theMOBs.add(richardRamirez);
		theMOBs.add(andreChikatilo);
		theMOBs.add(richardTrentonChase);
		
		theMOBs.add(victim);
		theMOBs.add(foodStandGuy);
		
		
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
	
	public MOB getMOBFromIdentity(String theIdentity){
		for (MOB mob: theMOBs)
		{
			if (mob.getIdentity().equals(theIdentity))
			{
				System.out.println("found it");
				return mob;
			}
		}
		return null;
	}
}
