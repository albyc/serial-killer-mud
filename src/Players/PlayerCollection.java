package Players;


import java.util.ArrayList;
 
/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public class PlayerCollection {
 
    private ArrayList<Player> players;
     
    public PlayerCollection(){
        players = new ArrayList<Player>();
    }
     
    public void addPlayer(Player newPlayer){
        players.add(newPlayer);
    }
     
    public Player getPlayer(int num){
        return players.get(0);
    }
     
    public boolean isUsernamePasswordOrGameNameTaked(String canidateUsername, String canidatePassword, String canidateGameName){
        for(Player p : players){
            if(p.getUsername().equals(canidateUsername) || p.getPassword().equals(canidatePassword) || p.getGameName().equals(canidateGameName))
                return true;
        }
        return false;
    }
 
}