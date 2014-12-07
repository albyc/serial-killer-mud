package Items;

import java.util.ArrayList;
import java.util.List;

public class ItemCollection 
{
	private List<Item> items;
	
	private EnergyBoostItem water = new EnergyBoostItem("water", "you drink it to stay alive", true, false);
	private EnergyBoostItem food = new EnergyBoostItem("food", "you eat it to stay alive", true, false);
	private EnergyBoostItem bandaid = new EnergyBoostItem("bandaid", "patch up your wound", true, false);
	private EnergyBoostItem aidKit = new EnergyBoostItem("first aid kit", "patch up your wound", true, false);
	private EnergyBoostItem energyBoost = new EnergyBoostItem("energy boost", "You look a little tired, use this to increase your energy.", true, false);
	private FightingItem stick = new FightingItem("stick","Use this fine piece of wood to protect yourself in anyway possible. It's more powerful than you think.", true, false, false);
	private FightingItem knife = new FightingItem("knife", "You can stab people with it to stay alive", true, false, false);
	private FightingItem gun = new FightingItem("gun", "Use this to kill enemies/victims.", true, false, false);
	private FightingItem sword = new FightingItem("sword", "Use this sleek piece of weaponry to fight any evil MOB's that stand in your way.", true, false, false);
	private FightingItem shovel = new FightingItem("shovel", "Use this to digg wholes or to whack MOB's upside there heads.", true, false, false);
	private FightingItem rope = new FightingItem("rope", "Need to tie up a victim?", true, false, false);
	private ReusableItem handcuffs = new ReusableItem("handcuffs", "Use this to save yourself some time. MOB's will struggle to get free from this restraint.", true, false, false);
	private ReusableItem flashLight = new ReusableItem("falsh light", "Use this item to light up your night.", true, false, false);
	private ReusableItem nightVisionGoggles = new ReusableItem("night vision goggles", "Use these to see in dark places to stay alive", true, false, false);
	private ReusableItem key = new ReusableItem("key", "Use this to unlock doors to run away to stay alive.", true, false, false);
	private ReusableItem money = new ReusableItem("money", "Use this to buy energy boosts", true, true, true); 
	private ReusableItem disguise = new ReusableItem("disguise", "This is a rare find. Use this to hide your face from your enemies.", true, true, true); 
	
	
//	private boolean[] pickedUp;
	
	public ItemCollection(){
		items = new ArrayList<Item>();
//		this.pickedUp = new boolean[5];
//		for(int i = 0; i < pickedUp.length; i++){
//			pickedUp[i] = false;
//		}
		items.add(water);
		items.add(food);
		items.add(bandaid);
		items.add(aidKit);
		items.add(energyBoost);
		items.add(stick);
		items.add(knife);
		items.add(gun);
		items.add(sword);
		items.add(shovel);
		items.add(rope);
		items.add(handcuffs);
		items.add(flashLight);
		items.add(nightVisionGoggles);
		items.add(key);
		items.add(money);
		items.add(disguise);
		
	}
	
	public Item getItem(int index){
		switch(index){
		case 0:
			return water;
		case 1:
			return food;
		case 2:
			return bandaid;
		case 3:
			return aidKit;
		case 4:
			return energyBoost;
		case 5:
			return stick;
		case 6:
			return knife;
		case 7:
			return gun;
		case 8:
			return sword;
		case 9:
			return shovel;
		case 10:
			return rope;
		case 11:
			return handcuffs;
		case 12:
			return flashLight;
		case 13:
			return nightVisionGoggles;
		case 14:
			return key;
		case 15:
			return money;
		case 16:
			return disguise;
		default:
			return null;
		
		}
	}
	
//	public boolean getbool(int index)
//	{
//		return pickedUp[index];
//	}
	
	
	
//	public void setbool(int index, boolean set)
//	{
//		pickedUp[index] = set;
//	}
	
//	public void removeItem(Item item)
//	{
//		for (int i = 0; i < items.length; i++){
//			if( items[i] == item)
//			{
//				items[i] = null;
//			}
//		}
//	}
//	
//	public void addItem(Item item)
//	{
//		for (int i = 0; i < items.length; i++)
//		{
//			if (items[i] == null)
//			{ 
//				items[i] = item;
//			}
//		}
//	}
	
//	public Item getItemFromName(String name){
//		for(int i = 0; i < items.length; i++){
//			if(items[i].getName().equals(name)){
//				return items[i];
//			}
//		}}

}
