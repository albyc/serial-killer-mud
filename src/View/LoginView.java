package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JFrame 
{
	private BufferedImage image;
	private JLabel title;
	
	private JLabel oldy;
	private JLabel oldUN;
	private JLabel oldUP;
	private JTextField oldUserName;
	private JPasswordField oldUserPass;

	private JButton loginB;
	private JButton createB;
	

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
		title = new JLabel("save yo ass");
		title.setFont(getFont("fonts/cenobyte.ttf").deriveFont(38f));
		title.setForeground(Color.RED);
		title.setSize(600,40);
		title.setLocation(92,5);
		
		// Returning user JLabel and text fields
		oldy = new JLabel("Player Login:");
		oldy.setFont(getFont("fonts/trajan.ttf").deriveFont(20f));
		oldy.setForeground(Color.RED);
		oldy.setSize(250,30);
		oldy.setLocation(45,70);
		
		oldUN = new JLabel("Username:");
		oldUN.setFont(getFont("fonts/trajan.ttf").deriveFont(16f));
		oldUN.setForeground(Color.GREEN);
		oldUN.setSize(250,30);
		oldUN.setLocation(100,115);
		
		oldUserName = new JTextField("");
		oldUserName.setSize(175,30);
		oldUserName.setLocation(200,115);
		
		oldUP = new JLabel("Password:");
		oldUP.setFont(getFont("fonts/trajan.ttf").deriveFont(16f));
		oldUP.setForeground(Color.GREEN);
		oldUP.setSize(250,30);
		oldUP.setLocation(100,165);
		
		oldUserPass = new JPasswordField("");
		oldUserPass.setSize(175,30);
		oldUserPass.setLocation(200,165);
				
		loginB = new JButton("Login");
		loginB.setOpaque(true);
		loginB.setBorderPainted(false);
		loginB.setBackground(Color.RED);
		loginB.setForeground(Color.WHITE);
		loginB.setFont(getFont("fonts/trajan.ttf").deriveFont(14f));
		loginB.setSize(130, 30);
		loginB.setLocation(90, 225);
		
		
		createB = new JButton("Create Account");
		createB.setOpaque(true);
		createB.setBorderPainted(false);
		createB.setBackground(Color.RED);
		createB.setForeground(Color.WHITE);
		createB.setFont(getFont("fonts/trajan.ttf").deriveFont(14f));
		createB.setSize(180, 30);
		createB.setLocation(245, 225);
		//Adding components to Panel and JFrame
		
		this.add(title);
		this.add(oldy);
		this.add(oldUN);
		this.add(oldUserName);
		this.add(oldUP);
		this.add(oldUserPass);
		this.add(loginB);
		this.add(createB);
		
		
	}
}
