package Controller;

import java.io.*;
import java.net.*;
import java.util.*;

import MOBs.*;
import Model.*;
import Players.*;
import Rooms.*;
import View.Commands;

/**
 * The class is the server side of the Serial Killer MUD. The server communicates with clients,
 * sends and receives commands, etc.
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public class Server 
{
	private ServerSocket socket; // the server socket
	
	private List<String> chatMessages; // the chat log
	private HashMap<String, ObjectOutputStream> outputs; // map of all connected user's output streams
	private SerialKillerMud mud;
	private String commands;
	
	public static void main(String [] args)
	{
		new Server();
	}
	
	public Server()
	{
		chatMessages = new ArrayList<String>(); // create the chat log
		outputs = new HashMap<String, ObjectOutputStream>(); // setup the map
		mud = new SerialKillerMud();
		
		try
		{
			// start a new server on port 9001
			socket = new ServerSocket(9001);
			System.out.println("MUD Server started on port 9001");
			
			// spawn a client accepter thread
			new Thread(new ClientAccepter()).start();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	} // end of constructor Server
	
	/**
	 * This thread listens for and sets up connections to new clients
	 */
	public class ClientAccepter implements Runnable
	{

		@Override
		public void run() 
		{
			try
			{
				while (true)
				{
					// accept a new client, get output & input streams
					Socket s = socket.accept();
					ObjectOutputStream output = new ObjectOutputStream(s.getOutputStream());
					ObjectInputStream input = new ObjectInputStream(s.getInputStream());
					
					// read the client's information (here it's just name)
					// but later we'll add the password, too
					String clientName = (String)input.readObject();
					
					// set up the client as a player in game
					mud.setUpNewPlayer(clientName);
					
					// map the client name to the output stream
					outputs.put(clientName, output);
					
					// spawn a thread to handle communication with this client
					new Thread(new ClientHandler(input)).start();
					
					// add a notification message to the chat log
					addMessage(clientName + " connected");
					
					// 
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}	
	} // end of private class ClientAccepter
	
	private class ClientHandler implements Runnable
	{
		private ObjectInputStream input; // the input stream from the client
		
		public ClientHandler(ObjectInputStream input)
		{
			this.input = input;
		}

		@SuppressWarnings("unchecked")
		public void run() 
		{
			try
			{
				while(true)
				{
					// read a command from the client, execute on the server
					Command<Server> command = (Command<Server>)input.readObject();
					command.execute(Server.this);
					
					// terminate if client is disconnecting
					if (command instanceof DisconnectCommand)
					{
						input.close();
						return;
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	} // end of private class ClientHandler

	public void addMessage(String message) 
	{
		chatMessages.add(message);
		updateClients();
	} // end of method addMessage
	

	public void updateClients()
	{
		// make an UpdatedClientCommand, write to all connected users
		UpdateClientsCommand update = new UpdateClientsCommand(chatMessages);
		
		try
		{
			for(ObjectOutputStream out : outputs.values())
				out.writeObject(update);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	} // end of method updateClients
	
	public void disconnect(String clientName)
	{
		try
		{
			outputs.get(clientName).close(); // close outputs stream
			outputs.remove(clientName); // remove from map
			
			// add notification message
			addMessage(clientName + " disconnected");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	} // end of method disconnect

	public void PrintToClient(String clientName, Commands command) 
	{
		//print commands in client's right side text area
		// make an UpdatedClientCommand, write to all connected users
		UpdateAClientCommand update = new UpdateAClientCommand(command);
				
		ObjectOutputStream out = outputs.get(clientName);
		try {
			out.writeObject(update);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void PrintToClientWArgs(String clientName, String arguments, Commands command)
	{
		UpdateAClientWArgsCommand update = new UpdateAClientWArgsCommand(command, arguments);
		
		ObjectOutputStream out = outputs.get(clientName);
		try {
			out.writeObject(update);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
} // end of class Server
