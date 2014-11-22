package Items;

public class ItemCollection {
	
	private EnergyBoostItem water = new EnergyBoostItem("water", "you drink it to stay alive", true, false);
	private EnergyBoostItem food = new EnergyBoostItem("food", "you eat it to stay alive", true, false);
	private FightingItem knife = new FightingItem("knife", "You can stab people with it", true, false, false);
	private ReusableItem nightVisionGoggles = new ReusableItem("Night Vision Goggles", "Use these to see in dark places", true, false, false);
	private FightingItem key = new FightingItem("key", "use this to unlock doors", true, false, false);
	Item[] items;
	
	public ItemCollection(Item[] items){
		
		this.items = new Item[5];
		
		this.items[0] = water;
		this.items[1] = food;
		this.items[2] = knife;
		this.items[3] = nightVisionGoggles;
		this.items[4] = key;
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
}
