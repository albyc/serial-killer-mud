package Commands;

import Controller.*;

public class InventoryCommand extends Command<Client>
{
	private static final long serialVersionUID = -4184462915452723529L;

	public void execute(Client executeOn)
	{
		executeOn.listInventory();
	}
} // end of class InventoryCommand
