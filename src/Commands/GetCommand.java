package Commands;

import Controller.Client;
import Items.Item;
import Items.ItemCollection;

public class GetCommand extends Command<Client>
{
	private static final long serialVersionUID = 853680469911913921L;
	private String argument;
	private ItemCollection itemCollection;
	
	public GetCommand(String argument)
	{
		this.argument = argument;
	}

	@Override
	public void execute(Client executeOn)
	{
		switch(argument.toLowerCase()){
		case "water":
		case "food":
		case "bandaid":
		case "first aid kit":
		case "energy boost":
		case "stick":
		case "knife":
		case "gun":
		case "sword":
		case "shovel":
		case "rope":
		case "handcuffs":
		case "flashlight":
		case "night vision goggles":
		case "key":
		case "money":
		case "disguise":
			executeOn.pickUp(argument);
			break;
		}
		
//		String item = "";
//		String player = "";
//		int lastIndex = argument.length();
//		
//		for( int i = 0; i < argument.length(); i++){
//			if(argument.charAt(i) == ' '){
//				lastIndex = i;
//			}
//		}
//		
//		if(lastIndex != argument.length()-1){
//		item = argument.substring(0, lastIndex).trim();
//		player = argument.substring(lastIndex + 1).trim();
//		
//		executeOn.getItemFromPlayer(item, player);
//		}
		
		
		
		
	}
} // end of class GetCommand
