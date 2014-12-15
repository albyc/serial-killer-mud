package Model;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import Rooms.*;
import Items.Item;
import MOBs.*;
import Players.*;

/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public class SerialKillerMud
{
	private RoomCollection roomCollection;
	private transient List<Player> playersOnline;
	private transient List<Player> administrators;
	
	public SerialKillerMud()
	{
		int answer = JOptionPane.showConfirmDialog(null, "Start with previous saved state?", "Select an Option", JOptionPane.YES_NO_OPTION);
		if(answer == JOptionPane.NO_OPTION || !loadData()){
			roomCollection = new RoomCollection();
			playersOnline = new ArrayList<Player>();
			administrators = new ArrayList<Player>();
			roomCollection.setMOBsInRooms();
			addAdmins();
		}
		//this.addWindowListener(new SaveDataListener());
	
	}

	private void addAdmins()
	{
		Player admin = new Player("admin", "0000");
		
		administrators.add(admin);
	}

	public void addPlayerToGame(Player player)
	{		
		// Add the new player to the collection of existing players
		playersOnline.add(player);
		
		// Add the player to the rooms. Initially, every new player
		// will start out in the same location. 
		roomCollection.addNewPlayerToRooms(player);
	}
	
	public List<Player> getPlayersOnline()
	{
		return playersOnline;
	}
	
	public List<Player> getAdministrators()
	{
		return administrators;
	}
	
	public RoomCollection getRoomCollection()
	{
		return roomCollection;
	}
	

	public MOBCollection getMobCollection()
	{
		return roomCollection.getMobCollection();
	}
	
	public List<MOB> getListOfMOBs()
	{
		return getMobCollection().getAllMOBS();
	}

	public TimerTask updateMOBsOnTimer() {

		/*Random random = new Random();
		for(MOB m : roomCollection.getMobCollection().getAllMOBS()){
			m.getCurrentLocation();
			
			System.out.println(m.getCurrentLocation().getRoomName());
			//null pointer exception
			int direction = random.nextInt(4);
			switch(direction){
			case 0:
				try{
					m.changeRoom(m.getCurrentLocation().getEastRoom());
				}catch(Exception e){
					e.printStackTrace();
				}
				break;
			case 1:
				try{
					m.changeRoom(m.getCurrentLocation().getWestRoom());
				}catch(Exception e){
					e.printStackTrace();
				}
				break;
			case 2:
				try{
					m.changeRoom(m.getCurrentLocation().getNorthRoom());
				}catch(Exception e){
					e.printStackTrace();
				}
				break;
			case 3:
				try{
					m.changeRoom(m.getCurrentLocation().getSouthRoom());
				}catch(Exception e){
					e.printStackTrace();
				}
				break;
			default:
				try{
					m.changeRoom(m.getCurrentLocation().getNorthRoom());
				}catch(Exception e){
					e.printStackTrace();
				}
				break;
			}

			
		}*/
		return null;
	}
	
	private class SaveDataListener implements WindowListener {

		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
		}

		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
		}

		public void windowClosing(WindowEvent arg0) {
			// TODO Auto-generated method stub
			int answer = JOptionPane.showConfirmDialog(null, "save data?",
					"save data?", JOptionPane.YES_NO_OPTION);
			if (answer == JOptionPane.YES_OPTION) {
				// save data
				 saveData();
			}
		}

		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
		}

		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
		}

		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
		}

		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
		}
	}
	
	public boolean loadData() {
				try{
					FileInputStream inStream = new FileInputStream(new File("accounts.dat"));
					ObjectInputStream inObject = new ObjectInputStream(inStream);
					roomCollection = (RoomCollection) inObject.readObject();
					playersOnline = (List<Player>) inObject.readObject();
					administrators = (List<Player>) inObject.readObject();
					/*roomCollection.getPlaylist().resetListDataListeners();
					jukebox.getSongList().resetTableModelListeners();*/
					inObject.close();
				} catch(Exception e) {
					System.out.println("Unable to load data");
					return false;
				}
				return true;
	}
	
	public void saveData() {
		try{
			FileOutputStream outStream = new FileOutputStream(new File("accounts.dat"));
			ObjectOutputStream outObject = new ObjectOutputStream(outStream);
			outObject.writeObject(roomCollection);
			outObject.writeObject(playersOnline);
			outObject.writeObject(administrators);
			outObject.close();
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
} // end of class SerialKillerMud
