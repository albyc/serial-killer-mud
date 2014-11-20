package Controller;

import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.*;

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
public class Client 
{
	
	
	private String username; // username of the client
	private MudGUI mudGUI; 
	
	private Socket server; // connection to the server
	private ObjectOutputStream out; // output stream
	private ObjectInputStream in; // input stream
	
	//needs a lot of fixing - just testing to see if room abstract class/ subclass objects work
		//2 rooms - mansion (start on front porch), there's a front yard where you can die
		List<Player> playersInRoom = new ArrayList<Player>();
		List<MOB> mobsInRoom = new ArrayList<MOB>(); 
		MOB mob = new MOB();
		RoomCollection roomCollection = new RoomCollection(null, null);
		SceneRoom frontPorch = new SceneRoom("Front Porch" , "This is your initial starting location.", null, username, mob, frontYard);
		TrappingRoom frontYard = new TrappingRoom("Front Yard", "The front yard is a trapping room, so your chance of escaping is 50/50.", null, mob, frontPorch);
		/*SceneRoom exit = new SceneRoom(null, null, null, playersInRoom, mobsInRoom, null);
		TrappingRoom desert = new TrappingRoom("Desert", "The Desert room is a trapping room, so your chance of escaping is 50/50.", playersInRoom, mobsInRoom, exit);
		TrappingRoom jail = new TrappingRoom("Jail", "The Jail room is a trapping room, so your chance of escaping is 50/50.", playersInRoom, mobsInRoom, exit);
		TrappingRoom court = new TrappingRoom("Court", "The court room is a trapping room, so your chance of escaping is 50/50.", playersInRoom, mobsInRoom, exit);*/
	
	public static void main (String []args)
	{
		new Client();
	} // end of method main

	/**
	 * Asks the user for a host, port, and username. Sets up the
	 * connection to the server and sets up the GUI
	 */
	public Client()
	{
		String host = JOptionPane.showInputDialog("Host address:");
		String port = JOptionPane.showInputDialog("Host port:");
		username = JOptionPane.showInputDialog("User name:");
		
		if (host == null || port == null || username == null)
			return;
		
		try
		{
			// open a connection to the server
			server = new Socket(host, Integer.parseInt(port));
			out = new ObjectOutputStream(server.getOutputStream());
			in = new ObjectInputStream(server.getInputStream());
			
			// write out the name of this client
			out.writeObject(username);
			
			mudGUI = new MudGUI(username, out);
			
			// start a thread for handling server events
			new Thread(new ServerHandler()).start();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		} // end of try/catch statement
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
			} // end of try/catch statement
		} // end of method run
	} // end of private class ServerHandler
	
	/**
	 * Updates the MudView with the updated message log
	 * 
	 * @param messages The current log of messages to display
	 */
	public void update(List<String> messages) 
	{
		mudGUI.update(messages);
	}

}
