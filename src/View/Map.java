package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// I had this idea of making an "interactive" map :) maybe this could be a holly smokes W to the O to the W factor
// its not pretty code but its in progress. It flipping cool. Maybe we could add it to our main view??
// The ultimate decision is in your hands. 

// Hover over Spain and France 
public class Map extends JFrame {
	private BufferedImage image;
	private JButton  room1,  room2,  room3,  room4,  room5,  room6,  room7,  room8,  room9 , room10;
	private JButton room11, room12, room13, room14, room15, room16, room17, room18, room19 , room20;
	private JButton room21, room22, room23, room24, room25, room26, room27, room28, room29 , room30;
	private JButton spainButton, croissantButton, dubaiButton;
	private JTextArea infoArea;
	
	private String defaultString = "Welcome: \n\n" + 
	                               "This is the Save yo Ass interactive\n" +
	                               "map. For basic room information\n" +
	                               "please hover over the area you would\n" +
	                               "like to read about.";
			     
	public Map(){
		this.setTitle("Save Yo Ass Map");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try 
		{
			image = ImageIO.read(new File("images/MAP.jpg"));
			// Set your Image Here.
			this.setContentPane(new JLabel(new ImageIcon(image)));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
		// has to be here before try catch block
		this.setSize(image.getWidth(),image.getHeight());
		//this.setSize(500,300);
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		infoArea = new JTextArea(defaultString);
		infoArea.setFont(getFont("fonts/trajan.ttf").deriveFont(12f));
		infoArea.setEditable(false);
		infoArea.setSize(270,275);
		infoArea.setLocation(580, 115);
		infoArea.setBackground(Color.BLACK);
		infoArea.setForeground(Color.WHITE);
		JScrollPane sp = new JScrollPane(infoArea);
		
		// regular buttons
		room1 = new JButton("Lawn");
		room1.setOpaque(true);
		room1.setBorderPainted(false);
		room1.setBackground(new Color(168, 7, 7));
		room1.setForeground(Color.WHITE);
		room1.setLocation(410, 550);
		room1.setSize(67, 62);
		room1.setFont(getFont("fonts/trajan.ttf").deriveFont(10f));
		room1.addMouseListener(new MouseMoved("room1"));
		room1.setEnabled(true);

		room2 = new JButton("MC");
		room2.setOpaque(true);
		room2.setBorderPainted(false);
		room2.setBackground(new Color(168, 7, 7));
		room2.setForeground(Color.WHITE);
		room2.setLocation(410, 482);
		room2.setSize(67, 62);
		room2.setFont(getFont("fonts/trajan.ttf").deriveFont(10f));
		room2.addMouseListener(new MouseMoved("room2"));
		room2.setEnabled(true);
		
		// Customized buttons 
		ImageIcon iconOne = new ImageIcon("images/spainButton.png");
		spainButton = new JButton(iconOne);
		spainButton.setContentAreaFilled(false);
		spainButton.setBorderPainted(false);
		spainButton.setLocation(14, 238);
		spainButton.setSize(iconOne.getIconWidth(),iconOne.getIconHeight());
		spainButton.addMouseListener(new MouseMoved("espana"));
		
		ImageIcon iconTwo = new ImageIcon("images/parisButton.png");
		croissantButton = new JButton(iconTwo);
		croissantButton.setContentAreaFilled(false);
		croissantButton.setBorderPainted(false);
		croissantButton.setLocation(25, 73);
		croissantButton.setSize(iconTwo.getIconWidth(),iconTwo.getIconHeight());
		croissantButton.addMouseListener(new MouseMoved("francia"));
		
		ImageIcon iconThree = new ImageIcon("images/dubaiButton.png");
		dubaiButton = new JButton(iconThree);
		dubaiButton.setContentAreaFilled(false);
		dubaiButton.setBorderPainted(false);
		dubaiButton.setLocation(160, 10);
		dubaiButton.setSize(iconThree.getIconWidth(),iconThree.getIconHeight());
		dubaiButton.addMouseListener(new MouseMoved("makeItRain$"));
			
		this.add(room1);
		this.add(room2);
		this.add(infoArea);
		this.add(spainButton);
		this.add(croissantButton);
		this.add(dubaiButton);
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new Map();
	}// end main
	
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
		
		return font;
	} // end of private method getFont
		
	private class MouseMoved implements MouseListener 
	{
		private String current;
		
		
		public MouseMoved(String location)
		{
			this.current = location;
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) 
		{
			switch(current)
			{
			case "room1":
				room1.setBackground(Color.BLACK);
				room1.setEnabled(false);
		        infoArea.setText("Lawn description");
				break;
			case "room2":
				room2.setBackground(Color.BLACK);
				room2.setEnabled(false);
		        infoArea.setText("MC description");
				break;
			case "espana":
				spainButton.setBackground(Color.BLACK);
				spainButton.setEnabled(false);
				infoArea.setText("Spain description");
				break;
			case "francia":
				croissantButton.setBackground(Color.BLACK);
				croissantButton.setEnabled(false);
				infoArea.setText("Paris description");
				break;
			case "makeItRain$":
				dubaiButton.setBackground(Color.BLACK);
				dubaiButton.setEnabled(false);
				infoArea.setText("Dubai description");
				break;
			default:
				break;
			}
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) 
		{
			switch(current)
			{
			case "room1":
				room1.setBackground(new Color(168, 7, 7));
				infoArea.setText(defaultString);
				room1.setEnabled(true);
				break;
			case "room2":
				room2.setBackground(new Color(168, 7, 7));
				infoArea.setText(defaultString);
				room2.setEnabled(true);
				break;
			case "espana":
				spainButton.setContentAreaFilled(false);
				infoArea.setText(defaultString);
				spainButton.setEnabled(true);
				break;
			case "francia":
				croissantButton.setContentAreaFilled(false);
				infoArea.setText(defaultString);
				croissantButton.setEnabled(true);
				break;
			case "makeItRain$":
				dubaiButton.setContentAreaFilled(false);
				infoArea.setText(defaultString);
				dubaiButton.setEnabled(true);
				break;
			default:
				break;
			}
		}

		@Override public void mouseClicked(MouseEvent arg0) {}
		
		@Override public void mousePressed(MouseEvent arg0) {}

		@Override public void mouseReleased(MouseEvent arg0) {}
	}//end private class MouseMoved

}
