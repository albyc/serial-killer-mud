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
	private Item[] items;
	RoomCollection roomCollection = new RoomCollection();
	ItemCollection itemCollection = new ItemCollection(items);
			
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
		String host = JOptionPane.showInputDialog("Host address:");
		String port = JOptionPane.showInputDialog("Host port:");
		
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
				+ "\nLOOK <argument>: provides in depth description of specified argument\nQUIT: quits the game and closes the window\n";
		commandMessages.add(listOfCommands);
		mainView.updateCommands(commandMessages);
	}

	/**
	 * lists all of the players currently online. updates the command side of the gui.
	 * @param players - list of current players
	 */
	public void listWho(List<Player> players) 
	{
		//doesn't work yet. if 2nd client is added, in the 1st client's view, only the 1st client player exists. :(
		
		String listOfPlayers = "Here are the players currently online: \n";
		int count = 0;
		for(Player p : players)
		{
//			count++;
//			if(count >4)
				listOfPlayers += p.getUsername() + '\n';

		}
	
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
		Item item;
		if(argument.equalsIgnoreCase("nvg"))
		{
			item = itemCollection.getItemFromName("night vision goggles");
			System.out.println("nvg thing");
		}
		else
			item = itemCollection.getItemFromName(argument.toLowerCase());
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
					}*/
					player.dropItem(item);
					String dropped = "You no longer have <" + item.getName() + "> in your inventory." + "\n";
					commandMessages.add(dropped);
					mainView.updateCommands(commandMessages);
					//itemCollection.setbool(index, false);
					break;
				}
			}
		}
		
	}

	/**
	 * lists all of the items in a player's backpack
	 */
	public void listInventory() 
	{
		List<Item> list = player.getItems();
		boolean empty = true;
		String allItems = "These are the items that are currently in your backpack:\n";
		
		for (Item item: list)
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
	public void pickUp(String argument) 
	{
//		Item item = itemCollection.getItemFromName(argument.toLowerCase());
//		
//		if (player.getItems() != null)
//		{
//			if (player.getItems().size() < 5)
//			{				
//				if(player.getLocation() == roomCollection.isItemInRoom(player.getLocation(), item ))
//				{
//					boolean inBackpack = false;
//					for(Item i : player.getItems())
//					{
//						if(i == item)
//						{
//							inBackpack = true;
//							break;
//						}
//					}
//					if(inBackpack == false){
//						player.pickUpItem(item);
//						String pickUp = "You have picked up <" + item.getName()+ "> and added it to your inventory.\n";
//						commandMessages.add(pickUp);
//						mainView.updateCommands(commandMessages);
//						if(item.getName().equals("water") || item.getName().equals("food"))
//						{
//							player.incrementHealth(5);//??? arg depend on how much boost
////							incrementHealth();
//						}
//					}
//				}
//			}
//		}
//		Item item;
//		
//		if(argument.equalsIgnoreCase("nvg"))
//		{
//			item = itemCollection.getItemFromName("night vision goggles");
//		}
//		else
//		
//			item = itemCollection.getItemFromName(argument.toLowerCase());
//		
//		
//		if (player.getItems() != null)
//		{
//			if (player.getItems().size() < 5)
//			{				
//				if(player.getLocation() == roomCollection.isItemInRoom(player.getLocation(), item ))
//				{
//					boolean inBackpack = false;
//					for(Item i : player.getItems())
//					{
//						if(i == item)
//						{
//							inBackpack = true;
//							break;
//						}
//					}
//					if(inBackpack == false){
//						player.pickUpItem(item);
//						String pickUp = "You have picked up <" + item.getName()+ "> and added it to your inventory.\n";
//						commandMessages.add(pickUp);
//						mainView.updateCommands(commandMessages);
//						if(item.getName().equals("water") || item.getName().equals("food"))
//						{
//							player.incrementHealth(5);//??? arg depend on how much boost
////							incrementHealth();
//						}
//					}
//				}
//			}
//		}
	}
	
//	public void incrementHealth()	//this should be in MOB and Player class. not here
//	{
//		int health = player.getHealth();
//		health = health + 5;
//		System.out.println(health);
//		player.setHealth(health);
//	}
	
	public void showMap()
	{
		new Map();
	}

	public void listSurroundings() 
	{
		//need to change how items are listed in case item picked up in one room but dropped in other room
		//could use as similar idea for adjacent rooms
		String surroundings = "";
		Room room = player.getLocation();
		String name = room.getRoomName();
		switch(name){
		case "The Lawn":
			surroundings += "Current Room: The Lawn \nDescription: small area of dead grass in front of the Murder Castle"
					+ "\nPlayers in Room: " + roomCollection.getRoomAt(0).getNamesOfPlayersInRoom()
					+ "\nMOB's in Room: " + roomCollection.getRoomAt(0).getNamesOfMOBsInRoom()
					+ "\nItems in Room: " + roomCollection.getRoomAt(0).getNamesOfItemsInRoom() //Key"
					+ "\nAdjacent Rooms:\n  The Murder Castle - to the north\n";
			break;
		case "Wisconsin Farmhouse of Horrors":
			surroundings += "Current Room: Wisconsin Farmhouse of Horrors\nDescription: Average farmhouse, nothing in particular"
					+ "\nPlayers in Room: " + roomCollection.getRoomAt(1).getNamesOfPlayersInRoom()
					+ "\nMOB's in Room: " + roomCollection.getRoomAt(1).getNamesOfMOBsInRoom()
					+ "\nItems in Room: \n  Knife\n  Night Vision Goggles\n"
					+ "\nPlayers in Room: " + roomCollection.getRoomAt(0).getNamesOfPlayersInRoom()
					+ "\nMOB's in Room: " + roomCollection.getRoomAt(0).getNamesOfMOBsInRoom()
					+ "\nItems in Room: " + roomCollection.getRoomAt(0).getNamesOfItemsInRoom()//\n  Knife\n  Night Vision Goggles\n"
					+ "Adjacent Rooms:\n  The Murder Castle - to the south\n ";
			break;
		case "Murder Castle":
			surroundings += "Current Room: The Murder Castle\nDescription: 601-603 W. 63rd St. Chicago. Home of Dr. Henry Howard Holmes. Three stories and a block long."
					+ "\nItems in Room: \n  Food\n  Water"
					+ "\nPlayers in Room: " + roomCollection.getRoomAt(2).getNamesOfPlayersInRoom()
					+ "\nMOB's in Room: " + roomCollection.getRoomAt(2).getNamesOfMOBsInRoom()
					+ "\nItems in Room: " + roomCollection.getRoomAt(0).getNamesOfItemsInRoom()//\n  Food\n  Water"
					+ "\nPlayers in Room: " + roomCollection.getRoomAt(0).getNamesOfPlayersInRoom()
					+ "\nMOB's in Room: " + roomCollection.getRoomAt(0).getNamesOfMOBsInRoom()
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
		roomCollection.addPlayerToRooms(player);
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

	public void tellMessage(String argument1, String argument2) 
	{
		System.out.println("trying to tell " + argument1 + "message: " + argument2);
	}
}
