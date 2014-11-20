package Controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
public class Client extends JFrame
{	
	private static final long serialVersionUID = 7356738763172150406L;
	
	private MainPanel mainPanel;
	private SerialKillerMud mud;
	
	private String username; // username of the client
	private Socket server; // connection to the server
	private ObjectOutputStream out; // output stream
	private ObjectInputStream in; // input stream
	
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
			
			mud = new SerialKillerMud();
			
			// here we would add the player to the list of players
			
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
		mainPanel.update(messages);
	}
}
