package Items;

import Rooms.Room;

public class FightingItem extends Item
{
	private boolean isUsedUp;
	public FightingItem(String name, String description, Room currentLocation, boolean isVisible, boolean isPickedUp, boolean isUsedUp)
	{
		super(name, description, currentLocation, isVisible, isPickedUp);
		this.isUsedUp = isUsedUp;
	}
	
	public void fightWith(Item item)
	{
		isUsedUp = true;
	}
}
