package Players;

import java.util.*;

 
/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public class PlayerCollection 
{
 
    private List<Player> players;
     
    public PlayerCollection()
    {
        players = new ArrayList<Player>();
    }
     
    /**
     * Adds a new player to the list of players. 
     * 
     * @param aPlayer Player to be added
     * @return Returns true if the player was added successfully. Otherwise, returns false.
     */
    public boolean addPlayer(Player aPlayer)
    {
		// for loop makes sure that the student being added
		// does not have the same ID as another student already
		// in the list
		for (Player p: players) 
		{
			if (p.getUsername().equals(aPlayer.getUsername()))
				return false;
		}
		
		players.add(aPlayer);
		return true;
    } // end of method addPlayer
   
    /**
     * Removes specified player from the list of players. 
     * 
     * @param aPlayer Player to be removed
     * @return Returns true if the player was successfully removed. 
     */
	public boolean removePlayer(Player aPlayer)
	{
		for (Player p: players)
		{
			if (p.getUsername().equals(aPlayer.getUsername()))
			{
				players.remove(p);
				return true;
			}
		}
		return false;
	} // end of method removePlayer
     
	public Player getPlayer(String username)
	{
		for(Player p: players)
		{
			if(p.getUsername().equals(username))
				return p;
		}
		return null;
	} // end of method getPlayer
} // end of class PlayerCollection