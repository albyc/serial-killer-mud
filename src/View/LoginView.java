package View;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;


// TRAIL class in progress Under construction 

// HOT MESS 

// *****************************  NOT GOOD YET **************************

// I'll fix the curly braces when I redo the code
public class LoginView extends JFrame {
  public LoginView() {
    add(new ContentPanel());
    setSize(500, 300);
  }

  public static void main(String[] args) {
    LoginView jrframe = new LoginView();
    jrframe.setVisible(true);
  }

}

class ContentPanel extends JPanel {
  Image bgimage = null;

  ContentPanel() {
    MediaTracker mt = new MediaTracker(this);
    bgimage = Toolkit.getDefaultToolkit().getImage("images/darkRoom.jpg");
    mt.addImage(bgimage, 0);
    try {
      mt.waitForAll();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    int imwidth = bgimage.getWidth(null);
    int imheight = bgimage.getHeight(null);
    g.drawImage(bgimage, 1, 1, null);
  }
}
/*package View;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Players.Player;




public class LoginView extends JFrame
{
	private Map<String, Player> players = new HashMap<String, Player>();
	private Player current;
	
	private JPasswordField passField;
	private JTextField userField;
	private JTextField gameField;
	public static void main(String[] args)
	{
		new LoginView().setVisible(true);
	}
	
	public LoginView()
	{
		setupLoginView();
	}
	
	public void addPlayer()
	{
		String username = userField.getText();
		String password = new String(passField.getPassword());
		String gameName = gameField.getText();
		
		//players.put(username, new Player(username, password, gameName) );
	}
	
	public class ImagePanel extends JPanel
	{
		Image background = null;
		public ImagePanel()
		{
			MediaTracker mTrack = new MediaTracker(this);
			background = Toolkit.getDefaultToolkit().getImage("images/scary-wall.JPG");
			mTrack.addImage(background,0);
			try
			{
				mTrack.waitForAll();
			} 
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
		protected void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    int imwidth = background.getWidth(null);
		    int imheight = background.getHeight(null);
		    g.drawImage(background, 1, 1, null);
		  }
		
	}
	

	private void setupLoginView()
	{
		this.setSize(500,300);
		
	}
	

}// end LoginView class
*/