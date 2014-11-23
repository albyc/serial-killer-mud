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

	// who dat
public class Client extends JFrame
{	
	private static final long serialVersionUID = 7356738763172150406L;
	
	private MainPanel mainPanel;
	private SerialKillerMud mud;
	private List<String> commandMessages; // the command log
	
	private String username; // username of the client
	private Socket server; // connection to the server
	private Player newPlayer;
	private Item[] items;
	private ObjectOutputStream out; // output stream
	private ObjectInputStream in; // input stream
	
	//needs a lot of fixing - just testing to see if room abstract class/ subclass objects work
		//2 rooms - mansion (start on front porch), there's a front yard where you can die
		ArrayList<Player> playersInStartingRoom = new ArrayList<Player>();
		//List<MOB> mobsInRoom = new ArrayList<MOB>(); 
		RoomCollection roomCollection = new RoomCollection();
		ItemCollection itemCollection = new ItemCollection(items);
		
	// Not from damaris you can't have a main if you do the login view won't work 	
	/*public static void main (String []args)
	{
		new Client();
	} // end of method main
*/
	/**
	 * Asks the user for a host, port, and username. Sets up the
	 * connection to the server and sets up the GUI
	 */
	public Client(String gamename)
	{
		String host = JOptionPane.showInputDialog("Host address:");
		String port = JOptionPane.showInputDialog("Host port:");
		username = gamename;
		
		if (host == null || port == null || username == null)
			return;
		
		try
		{
			// open a connection to the server
			server = new Socket(host, Integer.parseInt(port));
			out = new ObjectOutputStream(server.getOutputStream());
			in = new ObjectInputStream(server.getInputStream());
			commandMessages = new ArrayList<String>();
			commandMessages.add(welcomeMessage(username));
			
			// write out the name of this client
			out.writeObject(username);
			
			//add player to starting room
			
			//need to get their password
			String password = "";
			List<Item> backpack = new ArrayList<Item>(5);
			newPlayer = new Player(username, password,backpack);
			playersInStartingRoom.add(newPlayer);
			roomCollection.setRoomsPlayerList(playersInStartingRoom, 2);
			
			
			// add a listener that sends a disconnect command to when closing
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
			
			// start a thread for handling server events
			new Thread(new ServerHandler()).start();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		} // end of try/catch statement
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
				+ "For a list of commands at your disposal, type: commands";
		
		return welcomeMessage;
	}

	public void listCommands() 
	{
		String listOfCommands = "Here are the commands...";
		commandMessages.add(listOfCommands);
		mainPanel.updateCommands(commandMessages);
	}

	public void listWho() 
	{
		
		String listOfCommands = "Here are the players...";
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
		Item item = itemCollection.getItemFromName(argument);
		if(newPlayer.getItems() != null){
			for (Item i : newPlayer.getItems())
			{
				if(i.getName() == argument)
				{
					newPlayer.dropItem(item);
				}
			}
		}
		
	}

	public void listInventory() 
	{
		List<Item> list = newPlayer.getItems();
		String allItems = "";
		if(list == null)
		{
			allItems = "You have no items in your backpack.";
		}
		else{
			for (Item item : list){
				allItems += item.getName();
			}
		}
		commandMessages.add(allItems);
		mainPanel.updateCommands(commandMessages);
	}

	public void listScore() 
	{
		int score = newPlayer.getHealth();
		String sc = "" + score + "";
		commandMessages.add(sc);
		mainPanel.updateCommands(commandMessages);
		
	}
}
