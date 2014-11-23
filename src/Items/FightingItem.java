package Items;

import Rooms.Room;

public class FightingItem extends Item
{
	private boolean isUsedUp;
	public FightingItem(String name, String description, boolean isVisible, boolean isPickedUp, boolean isUsedUp)
	{
		super(name, description,isVisible, isPickedUp);
		this.isUsedUp = isUsedUp;
	}
	
	public void fightWith(Item item)
	{
		isUsedUp = true;
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		
	}
}
