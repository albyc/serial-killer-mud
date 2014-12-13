package MOBs;

import java.util.*;

import Items.Item;
import Rooms.Room;

public class MOBCollection
{
	private List<MOB> theMOBs;
	
	private MOB jefferyDahmer;		//abduct you
	private MOB lawrenceBittaker;
	private MOB royNorris;
	private MOB richardRamirez;				//attack just by being in the same room
	private MOB andreChikatilo;				//only attack by talking to
	private MOB richardTrentonChase;
	private MOB henryLeeLucus;
	private MOB edGein;
	private MOB hannibalLecter;		//cooking in kitchen, will make you food but beware
	private MOB henryHowardHolmes;
	
	private MOB victim;			//warn you of upcoming dangers
	private MOB foodStandGuy;		//help you increase you health for battles ahead
	
	public MOBCollection(){
		jefferyDahmer = new MOB("Jeffery Dahmer", new ArrayList<Item>(), new ArrayList<String>());
		lawrenceBittaker = new MOB("Lawrence Bittaker", new ArrayList<Item>(), new ArrayList<String>());
		royNorris = new MOB("Roy Norris", new ArrayList<Item>(), new ArrayList<String>());
		richardRamirez = new MOB("Richard Ramirez", new ArrayList<Item>(), new ArrayList<String>());
		andreChikatilo = new MOB("Andre Chikatilo", new ArrayList<Item>(), new ArrayList<String>());
		richardTrentonChase = new MOB("Richard Trenton Chase", new ArrayList<Item>(), new ArrayList<String>());
		henryLeeLucus = new MOB("Henry Lee Lucus", new ArrayList<Item>(), new ArrayList<String>());
		edGein = new MOB("Ed Gein", new ArrayList<Item>(), new ArrayList<String>());
		hannibalLecter = new MOB("Hannibal Lecter", new ArrayList<Item>(), new ArrayList<String>());
		henryHowardHolmes = new MOB("Henry Howard Holmes", new ArrayList<Item>(), new ArrayList<String>());
		
//		victim = new MOB("Victim", new ArrayList<Item>(), new ArrayList<String>());
//		foodStandGuy = new MOB("Food Stand Guy", new ArrayList<Item>(), new ArrayList<String>());
//		
//		theMOBs.add(hannibalLecter);
//		theMOBs.add(jefferyDahmer);
//		theMOBs.add(lawrenceBittaker);
//		theMOBs.add(royNorris);
//		theMOBs.add(hannibalLecter);
//		theMOBs.add(richardRamirez);
//		theMOBs.add(andreChikatilo);
//		theMOBs.add(richardTrentonChase);
//		theMOBs.add(henryHowardHolmes);
//	
//		theMOBs.add(victim);
//		theMOBs.add(foodStandGuy);
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
