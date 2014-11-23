package Items;

import Rooms.Room;

public class ReusableItem extends Item{

	private boolean isUsedUp;
	public ReusableItem(String name, String description,
		 boolean isVisible, boolean isPickedUp, boolean isUsedUp) {
		super(name, description, isVisible, isPickedUp);
		this.isUsedUp = isUsedUp;
	}
	
	@Override
	public void use()
	{
		isUsedUp = false;
	}

	public boolean getIsUsedUp()
	{
		return isUsedUp;
	}
	public void setIsUsedUp(boolean isUsedUp)
	{
		this.isUsedUp = isUsedUp;
	}

}
