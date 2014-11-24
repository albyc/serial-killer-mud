package Controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.*;

import Items.EnergyBoostItem;
import Items.FightingItem;
import Items.Item;
import Items.ItemCollection;
import Items.ReusableItem;
import MOBs.*;
import View.*;
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
	
	private MainPanel mainPanel;
	private SerialKillerMud mud;
	private List<String> commandMessages; // the command log
	
	private String username; // username of the client
	private Socket server; // connection to the server
	private Player player;
	private List<Player> players;
	private Item[] items;
	private Room[] rooms;
	private ObjectOutputStream out; // output stream
	private ObjectInputStream in; // input stream
	
	//needs a lot of fixing - just testing to see if room abstract class/ subclass objects work
		//2 rooms - mansion (start on front porch), there's a front yard where you can die
		//List<MOB> mobsInRoom = new ArrayList<MOB>(); 
		RoomCollection roomCollection = new RoomCollection();
		ItemCollection itemCollection = new ItemCollection(items);
		//MOBCollection mobCollection = new MOBCollection(rooms);
			
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
			players = (ArrayList<Player>)in.readObject();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		// From here, the LoginView will take the reins.
		new LoginView(Client.this, players);	
	} // end of constructor Client
	
	private void setupGUI()
	{
		// create mainPanel and add it the the Frame
		mainPanel = new MainPanel(username, out);
		this.add(mainPanel);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

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
		mainPanel.update(chatMessages, commandMessages);
	}
	
	private String welcomeMessage(String username)
	{
		String welcomeMessage = "Hello " + username + " and welcome to SAVE YO ASS.\n\n"
				+ "For a list of commands at your disposal, type: commands\n";
		
		return welcomeMessage;
	}

	public void listCommands() 
	{
		String listOfCommands = "Here are the commands: \nMOVE <direction>: Move into the room to the <direction>"
				+ "\nCOMMANDS: List all of the available commands\nOOC <message>: Send <message> to all players\n"
				+ "WHO: Lists all of the current players\nSCORE: Lists your current score\nGET <item>: Retrieves an item"
				+ "from the room and adds it to your backpack\nINVENTORY: Lists all of the items in your backpack"
				+ "\nDROP <item>: Removes the item from your backpack\nLOOK: provides a 360 description of your surroundings"
				+ "\nLOOK <argument>: provides an in depth description of the specified argument\nQUIT: quits the game and closes the window\n"
				+ "SHUTDOWN: Used by admin only - shuts down the server\n";
		commandMessages.add(listOfCommands);
		mainPanel.updateCommands(commandMessages);
	}

	public void listWho() 
	{
		//doesn't work yet. if 2nd client is added, in the 1st client's view, only the 1st client player exists. :(
		
		String listOfCommands = "Here are the players: \n";
		for (int i = 0; i < players.size(); i++ )
		{
			listOfCommands += players.get(i).getUsername() + '\n';
		}
		commandMessages.add(listOfCommands);
		mainPanel.updateCommands(commandMessages);	
	}
	
	public void closeByInput()
	{
		try 
		{
			out.writeObject(new DisconnectCommand(username));
			out.close();
			in.close();
			System.exit(0);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public void dropItem(String argument) 
	{
		Item item = itemCollection.getItemFromName(argument.toLowerCase());
		if(player.getItems() != null){
			for (Item i : player.getItems())
			{
				if(i.getName().equals(argument.toLowerCase()))
				{
					int index = 0;
					switch(argument){
					case "water":
						index = 0;
						break;
					case "food":
						index = 1;
						break;
					case "knife":
						index = 2;
						break;
					case "night vision goggles":
						index = 3;
						break;
					case "key":
						index = 4;
						break;
					}
					player.dropItem(item);
					//itemCollection.setbool(index, false);
					break;
				}
			}
		}
		
	}

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
		mainPanel.updateCommands(commandMessages);
	}

	public void listScore() 
	{
		int score = player.getHealth();
		String sc = player.getUsername() + "'s stats: \n";
		sc += "Health Level: " + score + "%.\n";
		commandMessages.add(sc);
		mainPanel.updateCommands(commandMessages);
		
	}

	public void pickUp(String argument) 
	{
		Item item = itemCollection.getItemFromName(argument.toLowerCase());
		if(player.getItems() != null){
			if(player.getItems().size() < 5)
			{
				int index = 0;
				switch(argument){
				case "water":
					index = 0;
					incrementHealth();
					break;
				case "food":
					index = 1;
					incrementHealth();
					break;
				case "knife":
					index = 2;
					break;
				case "night vision goggles":
					index = 3;
					break;
				case "key":
					index = 4;
					break;
				}
				//if(itemCollection.getbool(index) == false){
				if(player.getLocation() == roomCollection.isItemInRoom(player.getLocation(), item ))
				{
					player.pickUpItem(item);
				}
					//itemCollection.setbool(index, true);
				//}
				
				
			}
		}
	}
	
	public void incrementHealth()
	{
		int health = player.getHealth();
		health = health + 5;
		player.setHealth(health);
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
			username = player.getUsername();
			commandMessages = new ArrayList<String>();
			commandMessages.add(welcomeMessage(username));
			
			// Write out player associated with this client
			out.writeObject(player);
			
			players.add(player);
			roomCollection.setRoomsPlayerList(players, 2);
			
			// Add a listener that sends a disconnect command to when closing
			this.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent arg0) 
				{
					try 
					{
						out.writeObject(new DisconnectCommand(username));
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
	}

	public void closeServer(String clientName, Commands command) 
	{
		closeByInput();
		try {
			//ShutdownCommand sdc = new ShutdownCommand(username, command);
			out.writeObject(new ShutdownCommand(username, command));
			server.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void listSurroundings() 
	{
		String surroundings = "";
		Room room = player.getLocation();
		String name = room.getName();
		switch(name){
		case "The Lawn":
			surroundings += "Current Room: The Lawn \nDescription: small area of dead grass in front of the Murder Castle"
					+ "\nItems in Room: Key\n"
					+ "Adjacent Rooms:\n  The Murder Castle - to the north\n\n";
			break;
		case "Wisconsin Farmhouse of Horrors":
			surroundings += "Current Room: Wisconsin Farmhouse of Horrors\nDescription: Average farmhouse, nothing in particular"
					+ "\nItems in Room: Knife, Night Vision Goggles\n"
					+ "Adjacent Rooms:\n  The Murder Castle - to the south\n\n ";
			break;
		case "Murder Castle":
			surroundings += "Current Room: The Murder Castle\nDescription: 601-603 W. 63rd St. Chicago. Home of Dr. Henry Howard Holmes. Three stories and a block long."
					+ "\nItems in Room: Food, Water\nAdjacent Rooms:\n  The Lawn - to the south\n"
					+ "  Wisconsin Farmhouse of Horrors - to the north\n\n";
			break;
		}
		commandMessages.add(surroundings);
		mainPanel.updateCommands(commandMessages);
	}

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
			surroundings += "KEY:\nThe key can be used to unlock doors.\n\n";
			break;
		case "night vision goggles":
			surroundings += "NIGHT VISION GOGGLES:\nThe night vision goggles allow you to see in dark places.\n\n";
			break;
		case "lawn":
			surroundings += "THE LAWN:\nThe lawn is your original starting place. \nDescription: small area of dead grass in front of the Murder Castle"
					+ "\nItems in Room:\n  Key\n"
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
		//how to do specific players?
		default:
			break;
		}
		commandMessages.add(surroundings);
		mainPanel.updateCommands(commandMessages);
	}

	public void movePlayer(String argument) {
		switch(argument.toLowerCase())
		{
		case "north":
			player.changeRoom(player.getLocation().getNorthRoom());
			break;
		case "south":
			player.changeRoom(player.getLocation().getSouthRoom());
			break;
		default:
			break;
		}
	}
}
