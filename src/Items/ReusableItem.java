package Items;

import Rooms.Room;

public class ReusableItem extends Item{

	private boolean isUsedUp;
	public ReusableItem(String name, String description,
			Room currentLocation, boolean isVisible, boolean isPickedUp, boolean isUsedUp) {
		super(name, description, currentLocation, isVisible, isPickedUp);
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
