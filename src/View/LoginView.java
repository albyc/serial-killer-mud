package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Players.Player;

public class LoginView extends JFrame 
{	
	private Map<String, Player> players = new HashMap<String, Player>(); // the players will be be stored here 
	private Player current; // current login person
	
	private BufferedImage image;
	private JLabel title;
	private JLabel error;
	private JLabel oldy;
	private JLabel oldUN;
	private JLabel oldUP;
	private JTextField username;
	private JPasswordField userPass;

	private JButton loginButton;
	private JButton createButton;
	

	public static void main(String[] args) 
	{
		new LoginView().setVisible(true);
	}
	
	/**
	 * Sets the font
	 * 
	 * @param filename
	 * @return
	 */
	private static Font getFont(String filename)
	{
		Font font = null;
		
		try 
        {
			font = Font.createFont(Font.TRUETYPE_FONT, new File(filename));
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		}
		
		return font.deriveFont(50f);
	} // end of private method getFont
	
	public LoginView() 
	{
		this.setTitle("Login");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try 
		{
			image = ImageIO.read(new File("images/scaryRoom.jpg"));
			// Set your Image Here.
			this.setContentPane(new JLabel(new ImageIcon(image)));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		// has to be here before try catch block
		this.setSize(image.getWidth()-10,image.getHeight());
		//this.setSize(500,300);
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		
		// make AWESOME title
/*		title = new JLabel(" ");
		title.setFont(getFont("fonts/cenobyte.ttf").deriveFont(38f));
		title.setForeground(Color.RED);
		title.setSize(600,40);
		title.setLocation(92,5);
		*/
		// Returning user JLabel and text fields
		oldy = new JLabel("Player Login:");
		oldy.setFont(getFont("fonts/trajan.ttf").deriveFont(20f));
		oldy.setForeground(Color.RED);
		oldy.setSize(250,30);
		oldy.setLocation(60,50);
		
		oldUN = new JLabel("Username:");
		oldUN.setFont(getFont("fonts/trajan.ttf").deriveFont(16f));
		oldUN.setForeground(Color.GREEN);
		oldUN.setSize(250,30);
		oldUN.setLocation(100,100);
		
		username = new JTextField("");
		username.setSize(175,30);
		username.setLocation(200,100);
		
		oldUP = new JLabel("Password:");
		oldUP.setFont(getFont("fonts/trajan.ttf").deriveFont(16f));
		oldUP.setForeground(Color.GREEN);
		oldUP.setSize(250,30);
		oldUP.setLocation(100,150);
		
		userPass = new JPasswordField("");
		userPass.setSize(175,30);
		userPass.setLocation(200,150);
		
		error = new JLabel("");
		error.setFont(getFont("fonts/trajan.ttf").deriveFont(16f));
		error.setForeground(Color.YELLOW);
		error.setSize(400,30);
		error.setLocation(95,260);
				
		loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				login();
			}
		});		
		loginButton.setOpaque(true);
		loginButton.setBorderPainted(false);
		loginButton.setBackground(Color.RED);
		loginButton.setForeground(Color.WHITE);
		loginButton.setFont(getFont("fonts/trajan.ttf").deriveFont(14f));
		loginButton.setSize(130, 30);
		loginButton.setLocation(90, 205);
		
		
		createButton = new JButton("Create Account");
		createButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				addPlayer();
			}
		});
		createButton.setOpaque(true);
		createButton.setBorderPainted(false);
		createButton.setBackground(Color.RED);
		createButton.setForeground(Color.WHITE);
		createButton.setFont(getFont("fonts/trajan.ttf").deriveFont(14f));
		createButton.setSize(180, 30);
		createButton.setLocation(245, 205);
		//Adding components to Panel and JFrame
		
		//this.add(title);
		this.add(oldy);
		this.add(oldUN);
		this.add(username);
		this.add(oldUP);
		this.add(userPass);
		this.add(loginButton);
		this.add(createButton);
		this.add(error);
		
		
	}
	
	public void login()
	{
		String gamename = username.getText();
		Player person = players.get(gamename);
		if(person == null || !person.matches(userPass.getPassword()))
		{
			error.setText("Invalid username or password");
			error.setLocation(115,260);
			username.setText("");
			userPass.setText("");
			return;
		}
		
		current = person;
		username.setText("");
		userPass.setText("");
		error.setText("");
		
	}
	
	public void addPlayer()
	{
		String gamename = username.getText();
		String password = new String(userPass.getPassword());
		
		if(gamename.equals("") || userPass.equals(""))
		{
			error.setText("Enter a valid username or password");
			error.setLocation(90,260);
			username.setText("");
			userPass.setText("");
			return;
		}
		
		if(players.get(gamename) != null)
		{
			error.setText("An account exists with that name");
			error.setLocation(95,260);
			username.setText("");
			userPass.setText("");
			return;
		}
		error.setText("");
		players.put(gamename, new Player(gamename, password));
		login();
	}
}
