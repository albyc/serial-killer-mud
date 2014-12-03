package MOBs;

import java.util.*;

import Items.Item;
import Rooms.Room;

public class MOBCollection
{
	private List<MOB> theMOBs;
	
	private Killer jefferyDahmer;		//abduct you
	private Killer lawrenceBittaker;
	private Killer royNorris;
	private Killer richardRamirez;				//attack just by being in the same room
	private Killer andreChikatilo;				//only attack by talking to
	private Killer richardTrentonChase;
	private Killer henryLeeLucus;
	private Killer edGein;
	private Killer hannibalLecter;		//cooking in kitchen, will make you food but beware
	private Killer henryHowardHolmes;
	
	private NonKiller victim;			//warn you of upcoming dangers
	private NonKiller foodStandGuy;		//help you increase you health for battles ahead
	
	public MOBCollection(List<Room> rooms){
		jefferyDahmer = new Killer("Jeffery Dahmer", new ArrayList<Item>(), new ArrayList<String>(), rooms.get(0));
		lawrenceBittaker = new Killer("Lawrence Bittaker", new ArrayList<Item>(), new ArrayList<String>(), rooms.get(0));
		royNorris = new Killer("Roy Norris", new ArrayList<Item>(), new ArrayList<String>(), rooms.get(0));
		richardRamirez = new Killer("Richard Ramirez", new ArrayList<Item>(), new ArrayList<String>(), rooms.get(0));
		andreChikatilo = new Killer("Andre Chikatilo", new ArrayList<Item>(), new ArrayList<String>(), rooms.get(0));
		richardTrentonChase = new Killer("Richard Trenton Chase", new ArrayList<Item>(), new ArrayList<String>(), rooms.get(0));
		henryLeeLucus = new Killer("Henry Lee Lucus", new ArrayList<Item>(), new ArrayList<String>(), rooms.get(0));
		edGein = new Killer("Ed Gein", new ArrayList<Item>(), new ArrayList<String>(), rooms.get(0));
		hannibalLecter = new Killer("Hannibal Lecter", new ArrayList<Item>(), new ArrayList<String>(), rooms.get(0));
		henryHowardHolmes = new Killer("Henry Howard Holmes", new ArrayList<Item>(), new ArrayList<String>(), rooms.get(0));
		
		victim = new NonKiller("Victim", new ArrayList<Item>(), new ArrayList<String>(), rooms.get(0));
		foodStandGuy = new NonKiller("Food Stand Guy", new ArrayList<Item>(), new ArrayList<String>(), rooms.get(0));
		
		theMOBs.add(hannibalLecter);
		theMOBs.add(jefferyDahmer);
		theMOBs.add(lawrenceBittaker);
		theMOBs.add(royNorris);
		theMOBs.add(hannibalLecter);
		theMOBs.add(richardRamirez);
		theMOBs.add(andreChikatilo);
		theMOBs.add(richardTrentonChase);
		theMOBs.add(henryHowardHolmes);
		
		theMOBs.add(victim);
		theMOBs.add(foodStandGuy);
	}
	
	public List<MOB> getAllMOBS(){
		return theMOBs;
	}
	
	public MOB getMOB(int index) {
		switch(index) {
			case 0:
				return jefferyDahmer;
			case 1:
				return lawrenceBittaker;
			case 2:
				return royNorris;
			case 3:
				return richardRamirez;
			case 4:
				return andreChikatilo;
			case 5:
				return richardTrentonChase;
			case 6:
				return henryLeeLucus;
			case 7:
				return edGein;
			case 8:
				return hannibalLecter;
			case 9:
				return henryHowardHolmes;
			case 10:
				return victim;
			case 11:
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
