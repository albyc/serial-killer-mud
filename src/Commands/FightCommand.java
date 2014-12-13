package Commands;

import Controller.Client;

public class FightCommand extends Command<Client> {
	
	private static final long serialVersionUID = -6239777504515291261L;
	private String argument; 
	
	public FightCommand(String argument) {
		this.argument = argument;
	}
	
	public void execute(Client executeOn)
	{
		executeOn.fight(argument);
	}

}
