package Items;

import java.util.ArrayList;
import java.util.List;

public class ItemCollection 
{
	private List<Item> itumss;
	private EnergyBoostItem water = new EnergyBoostItem("water", "you drink it to stay alive", true, false);
	private EnergyBoostItem food = new EnergyBoostItem("food", "you eat it to stay alive", true, false);
	private FightingItem knife = new FightingItem("knife", "You can stab people with it to stay alive", true, false, false);

	private ReusableItem nightVisionGoggles = new ReusableItem("night vision goggles", "Use these to see in dark places to stay alive", true, false, false);

	private FightingItem key = new FightingItem("key", "use this to unlock doors to run away to stay alive", true, false, false);
	Item[] items;
	boolean[] pickedUp;
	
	public ItemCollection(Item[] items){
		//itumss = new ArrayList<Item>();
		this.items = new Item[5];
		this.pickedUp = new boolean[5];
		for(int i = 0; i < pickedUp.length; i++){
			pickedUp[i] = false;
		}
		this.items[0] = water;
		this.items[1] = food;
		this.items[2] = knife;
		this.items[3] = nightVisionGoggles;
		this.items[4] = key;
		/*itumss.add(water);
		itumss.add(food);
		itumss.add(knife);
		itumss.add(nightVisionGoggles);
		itumss.add(key);*/
		
	}
	
	public Item getItem(int index){
		switch(index){
		case 0:
			return water;
		case 1:
			return food;
		case 2:
			return knife;
		case 3:
			return nightVisionGoggles;
		case 4:
			return key;
		default:
			return null;
		
		}
		
			
	}
	
	public boolean getbool(int index)
	{
		return pickedUp[index];
	}
	
	public void setbool(int index, boolean set)
	{
		pickedUp[index] = set;
	}
	
	public void removeItem(Item item)
	{
		for (int i = 0; i < items.length; i++){
			if( items[i] == item)
			{
				items[i] = null;
			}
		}
	}
	
	public void addItem(Item item)
	{
		for (int i = 0; i < items.length; i++)
		{
			if (items[i] == null)
			{ 
				items[i] = item;
			}
		}
	}
	
	public Item getItemFromName(String name){
		for(int i = 0; i < items.length; i++){
			if(items[i].getName().equals(name)){
				return items[i];
			}
		}
		
		/*for (Item ii: itumss)
		{
			if (ii.getName().equals(name))
			{
				System.out.println("found it");
				return ii;
			}
		}*/
		
		return null;
		
	}
}
