package Controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.*;

import Commands.Command;
import Commands.DisconnectCommand;
import Items.EnergyBoostItem;
import Items.FightingItem;
import Items.Item;
import Items.ItemCollection;
import Items.ReusableItem;
import MOBs.*;
import View.*;
import View.Map;
import Rooms.*;
import Model.*;
import Players.*;

/**
 * The client side of Serial Killer MUD. This class displays the chat log
 * and sends...
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public class Client extends JFrame
{	
	private static final long serialVersionUID = 7356738763172150406L;
	
	private MainView mainView;
	private List<String> commandMessages; // the command log
	
	private Socket server; // connection to the server
	private Player player;
	private ObjectOutputStream out; // output stream
	private ObjectInputStream in; // input stream
	
	// These instance variables shouldn't be in Client, they should
	// be passed from Server to client, and to the Server from the 
	// SerialKillerMud
	//keep as instance variables but change that not new
	RoomCollection roomCollection = new RoomCollection();
			
	public static void main (String []args)
	{
		new Client();
	} // end of method main

	/**
	 * Sets up the connection between the server and the
	 * client. Sets up the GUI.
	 */
	@SuppressWarnings("unchecked")
	public Client()
	{
		String host = JOptionPane.showInputDialog("Host address:", "localhost");
		String port = JOptionPane.showInputDialog("Host port:", "9001");
		
		if (host == null || port == null)
			return;
		
		try
		{
			// Open a connection to the server
			server = new Socket(host, Integer.parseInt(port));
			out = new ObjectOutputStream(server.getOutputStream());
			in = new ObjectInputStream(server.getInputStream());
			
			// Once the connection is open, the client will read in from the
			// server the current list of players. It will then use this list
			// to determine whether the motherheffer trying to access the game
			// is allowed the privilege. If not, there's no fucking point in 
			// letting them in...
			List<Player> players = (ArrayList<Player>)in.readObject();
			List<Player> admins = (ArrayList<Player>)in.readObject();
			
			// From here, the LoginView will take the reins.
			new LoginView(Client.this, players, admins);	
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	} // end of constructor Client

	/**
	 * This class reads and executes commands sent from the server
	 */
	public class ServerHandler implements Runnable
	{
		@SuppressWarnings("unchecked")
		public void run()
		{
			try
			{
				while (true)
				{
					// read a command from server and execute it
					Command<Client> c = (Command<Client>)in.readObject();
					c.execute(Client.this);
				}
			}
			catch (SocketException e)
			{
				return; // "gracefully" terminate after disconnect
			}
			catch (EOFException e)
			{
				return; // "gracefully" terminate
			}
			catch (Exception e)
			{
				e.printStackTrace();
			} // end of try/catch statements
		} // end of method run
	} // end of private class ServerHandler
	
	/**
	 * Updates the view with the updated message log
	 * 
	 * @param messages The current log of messages to display
	 */
	public void update(List<String> chatMessages) 
	{
		mainView.update(chatMessages, commandMessages);
	}
	/**
	 * welcomMessage prints out a welcoming message as the player's client begins
	 * @param username - player's username
	 * @return the string message
	 */
	private String welcomeMessage(String username)
	{
		String welcomeMessage = "Hello " + username + " and welcome to SAVE YO ASS.\n\n"
				+ "For a list of commands at your disposal, type: commands\n";
		
		return welcomeMessage;
	}

	/**
	 * lists all of the commands a player can use during game play.
	 * calls the update function on the command side of the gui.
	 */
	public void listCommands() 
	{
		String listOfCommands = "Here are the commands: \nMAP: An interactive map will appear.\nMOVE <direction>: Move into the room to the <direction>"
				+ "\nCOMMANDS: List all of the available commands\nOOC <message>: Send <message> to all players\n"
				+ "WHO: Lists all of the current players\nSCORE: Lists your current score\nGET <item>: Retrieves an item"
				+ "from the room and adds it to your backpack\nINVENTORY: Lists all of the items in your backpack"
				+ "\nDROP <item>: Removes the item from your backpack\nLOOK: provides a 360 description of your surroundings"
				+ "\nLOOK <argument>: provides in depth description of specified argument\nQUIT: quits the game and closes the window\n"
				+ "SAY: send a message to all players in the same room as you\nTELL <player> <message>: Sends a message to the "
				+ "specified player\n";
		commandMessages.add(listOfCommands);
		mainView.updateCommands(commandMessages);
	}

	/**
	 * lists all of the players currently online. updates the command side of the gui.
	 * @param players - list of current players
	 */
	public void listWho(List<Player> players) 
	{
		String listOfPlayers = "Here are the players currently online: \n";
		int count = 0;
		for(Player p : players)
			listOfPlayers += p.getUsername() + '\n';
	
		commandMessages.add(listOfPlayers);
		mainView.updateCommands(commandMessages);	
	}
	
	/**
	 * closes the gui and creates a new DisconnectCommand for that player.
	 */
	public void closeByInput()
	{
		try 
		{
			out.writeObject(new DisconnectCommand(player.getUsername()));
			out.close();
			in.close();
			System.exit(0);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * allows the player to drop the specified item
	 * @param argument - the string name of the item to be dropped
	 */
	public void dropItem(String argument) 
	{
		//retrieve item from collection
		Item item;
		if(argument.equalsIgnoreCase("nvg"))
			item = roomCollection.getItemCollection().getItemFromName("night vision goggles");
		else
			item = roomCollection.getItemCollection().getItemFromName(argument.toLowerCase());
		
		//drop item if possible
		String dropped = "";
		if(player.dropItem(item)){ //drops item if possible and either returns true or false on successfulness
			player.getLocation().addItem(item);
			dropped = "You no longer have <" + item.getName() + "> in your inventory." + "\n";
		}
		else
			dropped = "You did not have <" + item.getName() + "> to drop." + "\n";
		
		//update gui
		commandMessages.add(dropped);
		mainView.updateCommands(commandMessages);
		
		/*
		if(player.getItems() != null){
			for (Item i : player.getItems())
			{
				if(i.getName().equals(argument.toLowerCase()) || (i.getName().equals("night vision goggles") && argument.toLowerCase().equals("nvg")))
				{
					/*switch(argument){
						case "water":
						break;
						case "food":
						break;
						case "knife":
						break;
						case "nvg":
						break;
						case "key":
						break;
					}
					player.dropItem(item);
					String dropped = "You no longer have <" + item.getName() + "> in your inventory." + "\n";
					commandMessages.add(dropped);
					mainView.updateCommands(commandMessages);
					//itemCollection.setbool(index, false);
					break;
				}
			}
		}*/
		
	}

	/**
	 * lists all of the items in a player's backpack
	 */
	public void listInventory() 
	{
		List<Item> playerBackpack = player.getItems();
		
		
		boolean empty = true;
		String allItems = "These are the items that are currently in your backpack:\n";
		
		for (Item item: playerBackpack)
		{
			allItems += item.getName() + "\n";
			empty = false;
			System.out.print("d");
		}
		
		if (empty)
			allItems = "You have no items in your backpack.\n";
		
		commandMessages.add(allItems);
		mainView.updateCommands(commandMessages);
	}

	/**
	 * lists the player's current stats
	 */
	public void listScore() 
	{
		int score = player.getHealth();
		String sc = player.getUsername() + "'s stats: \n";
		sc += "Health Level: " + score + "%.\n";
		commandMessages.add(sc);
		mainView.updateCommands(commandMessages);
		
	}

	/**
	 * allows the player to pick up the specified item
	 * @param argument - the string name of the item
	 */
	public void pickUp(String argument) //not working dammit
	{
		Item item;
		if(argument.equalsIgnoreCase("nvg"))
			item = roomCollection.getItemCollection().getItemFromName("night vision goggles");
		else
			item = roomCollection.getItemCollection().getItemFromName(argument.toLowerCase());
		
		if(player.getLocation().hasItem(item)){
			if(player.pickUpItem(item)){
			player.getLocation().removeItem(item);
			String pickUp = "You have picked up <" + item.getName()+ "> and added it to your inventory.\n";
			commandMessages.add(pickUp);
			mainView.updateCommands(commandMessages);
			}
			else{
				String pickUp = "Backpack is full.\n";
				commandMessages.add(pickUp);
				mainView.updateCommands(commandMessages);
			}
		}
		
/*	
		if (player.getItems() != null)
		{
			if (player.getItems().size() < 5)
			{				
				if(player.getLocation() == roomCollection.isItemInRoom(player.getLocation(), item ))
				{
					boolean inBackpack = false;
					for(Item i : player.getItems())
					{
						if(i == item)
						{
							inBackpack = true;
							break;
						}
					}
					if(inBackpack == false){
						player.pickUpItem(item);
						String pickUp = "You have picked up <" + item.getName()+ "> and added it to your inventory.\n";
						commandMessages.add(pickUp);
						mainView.updateCommands(commandMessages);
						if(item.getName().equals("water") || item.getName().equals("food"))
						{
							player.incrementHealth(5);//??? arg depend on how much boost
//							incrementHealth();
						}
					}
				}
			}
		}

		if(argument.equalsIgnoreCase("nvg"))
			item = roomCollection.getItemCollection().getItemFromName("night vision goggles");
		else
			item = itemCollection.getItemFromName(argument.toLowerCase());
*/
	}

	
	/*public void showMap()
	{
		new Map();
	}*/

	//needs to be finished
	public void listSurroundings() 
	{
		String surroundings = "";
		Room room = player.getLocation();
		String name = room.getRoomName();
		surroundings += "CurrentRoom: " + room.getRoomDescription()
				+ "\nPlayers in Room: "
				+ room.getNamesOfAdjacentRooms();
		switch(name){
			case "The Lawn":
				surroundings += "Current Room: The Lawn \nDescription: small area of dead grass in front of the Murder Castle"
						+ "\nPlayers in Room:" + room.getNamesOfPlayersInRoom()
						+ "MOB's in Room:" + room.getNamesOfMOBsInRoom()
						+ "Items in Room:" + room.getNamesOfItemsInRoom()
						+ "Adjacent Rooms:\n  The Murder Castle - to the north\n";
				break;
			case "Wisconsin Farmhouse of Horrors":
				surroundings += "Current Room: Wisconsin Farmhouse of Horrors\nDescription: Average farmhouse, nothing in particular"
						+ "\nPlayers in Room: " + room.getNamesOfPlayersInRoom()
						+ "\nMOBs in Room: " + room.getNamesOfMOBsInRoom()
						+ "\nItems in Room: " + room.getNamesOfItemsInRoom()
						+ "Adjacent Rooms:\n  The Murder Castle - to the south\n ";
				break;
			case "Murder Castle":
				surroundings += "Current Room: The Murder Castle\nDescription: 601-603 W. 63rd St. Chicago. Home of Dr. Henry Howard Holmes. Three stories and a block long."
						+ "\nPlayers in Room: " + room.getNamesOfPlayersInRoom()
						+ "\nMOB's in Room: " + room.getNamesOfMOBsInRoom()
						+ "\nItems in Room: " + room.getNamesOfItemsInRoom()
						+ "\nAdjacent Rooms:\n  The Lawn - to the south\n"
						+ "  Wisconsin Farmhouse of Horrors - to the north\n";
				break;
		}
		commandMessages.add(surroundings);
		mainView.updateCommands(commandMessages);
	}

	/**
	 * lists the details of the specified argument
	 * @param argument - string name of item/room specified
	 */
	public void surroundingsArg(String argument) {
		String surroundings = "";
		switch(argument.toLowerCase())
		{
			case "water":
				surroundings += "WATER:\nThe water item is drinkable water. It increases your health score.\n\n";
				break;
			case "food":
				surroundings += "FOOD:\nThe food item is edible food. It increases your health score.\n\n";
				break;
			case "knife":
				surroundings += "KNIFE:\nThe knife can be used as a weapon against the MOB serial killers and other players.\n\n";
				break;
			case "key":
				surroundings += "KEY:\nThe key locan be used to unlock doors.\n\n";
				break;
			case "night vision goggles":
				surroundings += "NIGHT VISION GOGGLES (NVG):\nThe night vision goggles allow you to see in dark places.\n\n";
				break;
			case "lawn":
				surroundings += "THE LAWN:\nThe lawn is your original starting place. \nDescription: small area of dead grass in front of the Murder Castle"
						+ "\nItems in Room:\n" // + Key\n"
						+ "Adjacent Rooms:\n  The Murder Castle - to the north\n\n";
				break;
			case "murder castle":
				surroundings += "THE MURDER CASTLE:\nDescription: 601-603 W. 63rd St. Chicago. Home of Dr. Henry Howard\n Holmes. Three stories and a block long."
						+ "\nItems in Room:\n  Food\n  Water\nAdjacent Rooms:\n  The Lawn - to the south\n"
						+ "  Wisconsin Farmhouse of Horrors - to the north\n\n";
				break;
			case "wisconsin farmhouse of horrors":
				surroundings += "WISCONSIN FARMHOUSE OF HORRORS:\nDescription: Average farmhouse, nothing in particular"
						+ "\nItems in Room:\n  Food\n  Water\nAdjacent Rooms:\n  The Lawn - to the south\n  "
						+ "Wisconsin Farmhouse of Horrors - to the north\n\n";
				break;
			case "jeffery dahmer":
			case "dahmer":
				surroundings += "it works dumbass";
				new MOBdescription(argument.toLowerCase());
				break;
			case "lawrence bittaker":
			case "roy norris":
			case "bittaker":
			case "norris":
			case "toolbox killers":
				new MOBdescription(argument.toLowerCase());
				break;
			case "richard ramirez":
			case "ramirez":
			case "night stalker":
				new MOBdescription(argument.toLowerCase());
				break;
			case "andre chikatilo":
			case "chikatilo":
			case "red ripper":
				new MOBdescription(argument.toLowerCase());
				break;
			case "richard trenton chase":
			case "richard chase":
			case "chase":
				new MOBdescription(argument.toLowerCase());
				break;
			case "henry lee lucus":
			case "henry lucus":
			case "lucus":
				new MOBdescription(argument.toLowerCase());
				break;
			case "ed gein":
			case "gein":
			case "psycho":
				new MOBdescription(argument.toLowerCase());
				break;
			case "hannibal lecter":
			case "hannibal":
			case "lecter":
				new MOBdescription(argument.toLowerCase());
			case "henry howard holmes":
			case "holmes":
			case "hhh":
				new MOBdescription(argument.toLowerCase());
			default:
				break;
		}
		commandMessages.add(surroundings);
		mainView.updateCommands(commandMessages);
	}


	/**
	 * moves the player in the specified direction
	 * @param argument - string the direction
	 */
	public void movePlayer(String argument) {
		switch(argument.toLowerCase())
		{
			case "north":
				if(player.getLocation().getNorthRoom() != null)
				{
					player.changeRoom(player.getLocation().getNorthRoom());
	
					String movedTo = "You have moved north into " + player.getLocation().getRoomName() + "\n"; 
					commandMessages.add(movedTo);
					mainView.updateCommands(commandMessages);
				}
				else
				{
					String movedTo = "There is no room to the north of your current location. Use the LOOK\ncommand to see "
							+ "the adjacent rooms.\n";
					commandMessages.add(movedTo);
					mainView.updateCommands(commandMessages);
				}
				break;
			case "south":
				if(player.getLocation().getSouthRoom() != null)
				{
					player.changeRoom(player.getLocation().getSouthRoom());
	
					String movedTo = "You have moved south into " + player.getLocation().getRoomName() + "\n"; 
					commandMessages.add(movedTo);
					mainView.updateCommands(commandMessages);
				}
				else
				{
					String movedTo = "There is no room to the south of your current location. Use the LOOK\ncommand to see "
							+ "the adjacent rooms.\n";
					commandMessages.add(movedTo);
					mainView.updateCommands(commandMessages);
				}
				break;
			default:
				// message is sent to client letting them know that it is not a valid move
				break;
		}
		listSurroundings();
	}

	/**
	 * Associates this client with a player account. Called 
	 * by LoginView.
	 * 
	 * @param player The player this client is associated with. 
	 */
	public void setPlayer(Player player)
	{
		this.player = player;
		roomCollection.addNewPlayerToRooms(player);
	}

	/**
	 * Finishes setting up the player as well as displaying the main 
	 * view of the MUD. Called by LoginView.
	 */
	public void finishSettingUpPlayer()
	{
		try
		{
			
			commandMessages = new ArrayList<String>();
			commandMessages.add(welcomeMessage(player.getUsername()));
			
			// Write out player associated with this client
			out.writeObject(player);
			
			/*players.add(player);
			roomCollection.setRoomsPlayerList(players, 2);*/
			
			// Add a listener that sends a disconnect command to when closing
			this.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent arg0) 
				{
					try 
					{
						out.writeObject(new DisconnectCommand(player.getUsername()));
						out.close();
						in.close();
					} 
					catch (IOException e) 
					{
						e.printStackTrace();
					}
				}
			});
						
			setupGUI();
			
			// Start a thread for handling server events.
			new Thread(new ServerHandler()).start();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		} // end of try/catch statement
	} // end of method finishSettingUpPlayer
	
	private void setupGUI()
	{
		// create an instance of the mainView and add it the this frame
		mainView = new MainView(player.getUsername(), out);
		this.add(mainView);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}  // end of method setupGUI


	public void updateOne(List<String> messages, String receiver, String sender) {
		if(player.getUsername().equalsIgnoreCase(receiver) || player.getUsername().equalsIgnoreCase(sender))
		{
			mainView.updateOne(messages, receiver, sender);
		}
	}

	public void showMap() {
		new Map();
	}

	
	// if mob is in same room as player, fight
	public void fight(String argument) {
		List<MOB> allMOBsInRoom = player.getLocation().getMOBs();
		MOB opponent = player.getLocation().getMobByName(argument);
		if(opponent != null)
			player.fight(opponent);
		listScore();
	}

	public void lookDescription(String argument) {
		String description = "";
		switch(argument.toLowerCase()){
		case "water":
			description = "Water: you drink it to stay alive\n";
			break;
		case "food":
			description = "Food: you eat it to stay alive\n";
			break;
		case "bandaid":
			description = "BandAid: patch up your wound\n";
			break;
		case "first aid kit":
			description = "First Aid Kit: patch up your wound\n";
			break;
		case "energy boost":
			description = "Energy Boost: you look a little tired, use this to increase your energy\n";
			break;
		case "stick":
			description = "Stick: use this fine piece of wood to protect yourself in any way possible."
					+ "It's more powerful than you think.\n";
			break;
		case "knife":
			description = "Knife: You can stab people with it to stay alive\n";
			break;
		case "gun":
			description = "Gun: Use this to kill enemies/victims\n";
			break;
		case "sword":
			description = "Sword: use this sleek piece of weaponry to fight any evil MOB's that stand in your way.\n";
			break;
		case "shovel":
			description = "Shovel: Use this to dig holes or to whack MOB's upside thier heads.\n";
			break;
		case "rope":
			description = "Rope: Need to tie up a victim?\n";
			break;
		case "handcuffs":
			description = "Handcuffs: Use this to save yourself some time. MOB's will struggle to get free from this restraint\n";
			break;
		case "flashlight":
			description = "Flashlight: Use this item to light up your night.\n";
			break;
		case "night vision goggles":
			description = "Night Vision Goggles: Use these to see in dark places\n";
			break;
		case "key":
			description = "Key: Use this to unlock doors\n";
			break;
		case "money":
			description = "Money: Use this to buy energy boosts\n";
			break;
		case "disguise":
			description = "Disguise: This is a rare find. Use this to hide your face from your enemies.\n";
			break;
		case "lawn":
			description = "The Lawn: There is no escaping now! The lawn\n"
    				+ "is homebase for all players. You are\n"
    				+ "surrounded by thousands upon\n"
    				+ "thousands of acres of dead grass and\n"
    				+ "trees. Daylight does not exist in this\n"
    				+ "area and anything  can happen. There\n"
    				+ "is only one way out. Find the key and\n"
    				+ "enter the Murder Castle. You can stay\n"
    				+ "but your chances of survival are slim\n"
    				+ "to none. Do yourself a favor if you’re\n"
    				+ "on the lawn, leave at once and save yo\n"
    				+ "ass.\n\n";
			break;
		case "secret room":
			description = "Sorry, the contents within this room\n"
		        				+ "are confidential. You have to play\n"
		        				+ "the game and explore it yourself\n\n";
			break;
		case "dark woods":
			description = "Dark Woods: AAAAAOOOOOOWWWWWWWW. Watch\n"
     			   + "out for those deathly predators\n"
     			   + "hidden in the brush. Their eyes\n"
     			   + "glow with a lively flourish that\n"
     			   + "juxtaposes your inevitable fate.\n"
     			   + "There isn’t much to see here since\n"
     			   + "it is dark. Perhaps you’ll find a\n"
     			   + "flashlight hidden amongst the trees.\n"
     			   + "Word of advice… Watch your back!!\n\n";
			break;
		case "basement":
			description = "Basement: Welcome to the deepest trenches\n"
     			   + "of the murder castle. Beware the\n "
     			   + "piles of corpses. That stench isn't\n"
     			   + "just your feet. Besides the eeriness\n"
     			   + "feeling this room gives you there isn’t\n"
     			   + "much within the space enclosed by\n"
     			   + "these nicely painted red walls.\n\n";
			break;
		case "murder castle":
			description = "Murder Castle: Welcome to the cozy home of Sir\n"
		        			   + "HH Holmes. There's no need to be\n"
		        			   + "afraid. Unless HH comes home. The\n"
		        			   + "‘Castle’ is located 601-603 W. 63rd St.\n"
		        			   + "Chicago. It's three stories and a block\n"
		        			   + "long. The ground floor contains Dr.\n"
		        			   + "Holmes drugstore. The upper two\n"
		        			   + "floors consist of 100 windowless\n"
		        			   + "rooms with doorways opening to\n"
		        			   + "brick walls, oddly angles hallways,\n"
		        			   + "and stairways to nowhere.\n";
			break;
		case "wisconsin farmhouse of horrors":
			description = "Wisconsin Farmhouse of Horrors: Welcome to Ed Gein's farmhouse. Pay\n"
	        			   + "no mind to the human paraphernalia,\n"
	        			   + "Ed Gein definately does not want to\n"
	        			   + "scare you away. The house is in\n"
	        			   + "pristine shape but a little out\n"
	        			   + "dated. I wouldn’t touch anything Ed\n"
	        			   + "wouldn’t like that. He should be\n"
	        			   + "arriving shortly. If I were you get\n"
	        			   + "what you need and leave.\n";
			break;
		case "cleveland strangler murder house":
			description = "Cleveland Strangler Murder House: You are currently standing in the\n"
	        			   + "Cleveland Strangler’s living room.\n"
	        			   + "It is here where two bodies were\n"
	        			   + "found during the time of the\n"
	        			   + "Strangler’s arrest. Don’t worry he\n"
	        			   + "won’t be coming for you but someone\n"
	        			   + "else could be. There is a couch to\n"
	        			   + "the north of the room and a\n"
	        			   + "television. The room is pretty empty\n"
	        			   + "the Strangler wasn’t too keen on\n"
	        			   + "indoor decorating.\n\n";
			break;
		case "abandoned factory":
			description = "Abandoned Factory: Creeeeeaak. Low-hanging pipes and\n"
     			   + "boarded windows haunt this desolate\n"
     			   + "place. Beware of dangerous machinery.\n"
     			   + "Some murders can be made to look like\n"
     			   + "accidents. Spiders aren't the only\n"
     			   + "thing you should be afraid of.\n";
			break;
		case "roach motel":
			description = "Roach Motel: You have found a safe place. This\n"
	        			   + "place is pretty dirty. The walls are\n"
	        			   + "moldy with odd colored stains. No\n"
	        			   + "one can attack you here, so go ahead.\n"
	        			   + "Grab a roach filled cot and get some\n"
	        			   + "Just keep your mouth closed.\n";
			break;
		case "save yo self hospital":
			description = "Save Yo Self Hospital: Got wounds? Need some patching up?\n"
     			   + "You've come to the right place.\n"
     			   + "Just make sure you check your\n"
     			   + "doctor's credentails. Or else you'll\n"
     			   + "have a one way ticket to the morgue."
     			   + "\n\n";
			break;
		case "dakota apartments":
			description = "The Dakota Apartments: Welcome to northwest corner of\n"
     			   + "72nd Street and Central Park West in\n"
     			   + "New York City. This place is also\n"
     			   + "known to be the famous murder place\n"
     			   + "of John Lennon. Come here to see\n"
     			   + "music die.\n";
			break;
		case "hannibal's kitchen":
			description = "Hannibal's Kitchen: You're in for a treat.\n"
	        			   + "Pull up a chair and prepare\n"
	        			   + "to be served the finest white\n"
	        			   + "meat you'll consume.\n"
	        			   + "Make sure you try the ribs.\n";
			break;
		case "dead end jail":
			description = "Dead End Jail: Bars and Stripes. Welcome to\n"
     			   + "jail.  Your backpack has been\n"
     			   + "taken into custody. You have\n"
     			   + "lost all your items.\n";
			break;
		case "police station":
			description = "Police Station: Got a crime to report?\n"
	        			   + "Of course you do, you snitch.\n"
	        			   + "You are safe... for now.\n";
			break;
		case "chi omega sorority house":
			description = "Chi Omega Sorority House at FSU: Wild parties, catty drama, and\n"
	        			   + "psycho murders. Come for fun,\n"
	        			   + "because this is a party you'll\n"
	        			   + "never forget.\n";
			break;
		case "jeffrey dahmer's apartment":
			description = "This is Jeffrey Dahmer's Apartment.\n";
			break;
		case "cemetery":
			description = "Cemetery: Tombstones and coffins and dead\n"
     			   + "people sleeping. These are a few\n"
     			   + "of my fa-vor-ite things.\n"
     			   + "Pick up a shovel and bury your\n"
     			   + "victims, before someone buries\n"
     			   + "you.\n";
			break;
		case "kingsfield bank":
			description = "Kingsfield Bank: Out of money? You've come to\n"
	        			   + "the right place. Finance your\n"
	        			   + "bribes here.\n";
			break;
		case "casino especial":
			description = "Casino Especial: Gamble all your problems away.\n";
			break;
		case "adventure land":
			description = "Adventure Land Theme Park: Step right up and claim your prize.\n"
	        			   + "I recommend you check out Devil's\n"
	        			   + "Flight before you reach your final\n"
	        			   + "destination. Keep your hands and\n"
	        			   + "feet in the ride at all times and\n"
	        			   + "don't forget to kiss yo ass\n"
	        			   + "goodbye.\n";
			break;
		case "dark alleyway":
			description = "Dark Alleyway: The best place for illegal transactions.\n"
	        			   + "But watch out. Not all sharks\n"
	        			   + "live in the ocean.\n";
			break;
		case "international airport":
			description = "International Airport: Need to get away or do some\n"
	        			   + "international business? Travel\n"
	        			   + "to Paris, Spain, or Dubai!\n"
	        			   + "This is a safe zone!\n";
			break;
		case "streets of detroit":
			description = "Streets of Detroit: Welcome to the streets of Detroit.\n"
	        			   + "Watch yo self. These streets\n"
	        			   + "are not safe.\n";
			break;
		case "fox hollow farms":
			description = "Fox Hollow Farms: Needs a Description.\n";
			break;
		case "big rig":
			description = "Robert Ben Rhodes' Big Rig: This may look like a normal Big\n"
	        			   + "Rig, but look closer.\n";
			break;
		case "desert":
			description = "Desert: I hope you brought plenty of water.\n"
	        			   + "And watch out for those scorpions\n"
	        			   + "too.  Stay here too long, and yo ass\n"
	        			   + "will suffer death by dehydration.\n";
			break;
		case "spain":
			description = "Spain: Welcome to Spain!\n";
			break;
		case "paris":
			description = "Paris: Welcome to Paris!\n"
     			   + "Visit the crypts under the city\n"
     			   + "and get lost in the Louvre.\n";
			break;
		case "dubai":
			description = "Dubai: Welcome to Dubai!\n";
			break;
		case "dahmer":
			new MOBdescription("jeffrey dahmer");
			break;
		case "bittaker":
			new MOBdescription("lawrence bittaker");
			break;
		case "ramirez":
			new MOBdescription("richard ramirez");
			break;
		case "chikatilo":
			new MOBdescription("andre chickatilo");
			break;
		case "chase":
			new MOBdescription("richard chase");
			break;
		case "lucus":
			new MOBdescription("lucus");
			break;
		case "gein":
			new MOBdescription("gein");
			break;
		case "hannibal":
			new MOBdescription("hannibal lecter");
			break;
		case "holmes":
			new MOBdescription("henry howard holmes");
			break;
		default:
			description = "Nothing matches your input. Please try again.";
			break;
		}
		
		commandMessages.add(description);
		mainView.updateCommands(commandMessages);
	}

	public void useItem(String argument) {
		String toPrint = "";
		switch(argument.toLowerCase()){
		case "water":
		case "food":
		case "money":
		case "energy boost":
			player.incrementHealth(5);
			toPrint = "You have now used <" +argument + ">. Your health has been incremented. \n";
			commandMessages.add(toPrint);
			mainView.updateCommands(commandMessages);
			listScore();
			dropItem(argument);
			break;
		default:
			toPrint = "You have now used <" +argument + ">.\n";
			commandMessages.add(toPrint);
			mainView.updateCommands(commandMessages);
			dropItem(argument);
			break;
		}
	}

}
