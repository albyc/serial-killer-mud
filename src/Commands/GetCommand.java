package Commands;

import Controller.Client;
import Items.Item;
import Items.ItemCollection;

public class GetCommand extends Command<Client>
{
	private static final long serialVersionUID = 853680469911913921L;
	private String argument;
	private ItemCollection itemCollection;
	private String clientName;
	
	public GetCommand(String argument, String clientName)
	{
		this.argument = argument;
		this.clientName = clientName;
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
		default:
			String item = "";
			String player = "";
			int lastIndex = argument.length();
			
			for( int i = 0; i < argument.length(); i++){
				if(argument.charAt(i) == ' '){
					lastIndex = i;
				}
			}
			System.out.println(item);
			System.out.println(player);
			
			if(lastIndex != argument.length()-1){
				
			item = argument.substring(0, lastIndex).trim();
			System.out.println(item);
			player = argument.substring(lastIndex + 1).trim();
			System.out.println(player);
			executeOn.getItemFromPlayer(item, player);
			}
			break;
		}
		
		
		
		
	}
} // end of class GetCommand
