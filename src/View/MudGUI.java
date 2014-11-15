package View;

import java.io.*;
import java.awt.*;
import java.util.*;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;

import Model.*;

/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public class MudGUI extends JFrame
{
	private static final long serialVersionUID = 7477644930151827118L;
	private JTextArea chatArea, commandArea; 
	private JTextField textField; // field where user enters text
	private JButton enterButton, signoutButton;
	
	private ObjectOutputStream output; // output stream to server
	private String clientName;
	
	private MainView mainview;
	
	/**
	 * Constructs a new MUD view for given username, using the given OutputStream
	 * 
	 * @param clientName username of the client
	 * @param output Output stream to server
	 */
	public MudGUI(String clientName, ObjectOutputStream output)
	{
		this.output = output;
		this.clientName = clientName;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
//		this.addWindowListener(new WindowAdapter()
//		{
//			public void windowClosing(WindowEvent arg0)
//			{
//				try
//				{
//					
//				}
//				catch (Exception e)
//				{
//					e.printStackTrace();
//				}
//			}
//		});
		
		setupGUI();
	} // end of constructor 
	
	/**
	 * 
	 */
	public void setupGUI()
	{		
		this.setLayout(new BorderLayout());
		
		// create and add top panel of MudGUI
		this.add(createTopPanel(), BorderLayout.NORTH);
		
		// create and add center panel of MudGUI
		this.add(createCenterPanel(), BorderLayout.CENTER);
		
		// create and add bottom panel of MudGUI
		this.add(createBottomPanel(), BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	} // end of method setupGUI
	
	/**
	 * 
	 * @return
	 */
	public JPanel createTopPanel()
	{
		JPanel top = new JPanel();
		
		JLabel banner = new JLabel("TITLE IN THE WORKS", JLabel.CENTER);
		banner.setPreferredSize(new Dimension(1100, 60));
		banner.setForeground(Color.RED);
        banner.setOpaque(true);
        banner.setFont(getFont("cenobyte.ttf"));
        
        top.add(banner);
        
		return top;
	} // end of method createTopPanel
	
	/**
	 * Sets the fucking font
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
	
	/**
	 * 
	 * @return
	 */
	public JPanel createCenterPanel()
	{	
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(1, 2, 10, 0));
		center.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// create chat panel
		JPanel chatPanel = new JPanel();
		chatPanel.setLayout(new BorderLayout());
		chatPanel.setPreferredSize(new Dimension(550, 550));
		
		// initialize the text area and add it to the chat panel
		chatArea = new JTextArea();
		chatArea.setBackground(Color.BLACK);
		chatArea.setForeground(Color.WHITE);
		chatArea.setEditable(false);
		chatPanel.add(new JScrollPane(chatArea), BorderLayout.CENTER);
		
		JPanel commandPanel = new JPanel();
		commandPanel.setLayout(new BorderLayout());
		commandPanel.setPreferredSize(new Dimension(550, 550));

		// initialize the text area and add it to the command panel
		commandArea = new JTextArea();
		commandArea.setBackground(Color.BLACK);
		commandArea.setForeground(Color.WHITE);
		commandArea.setEditable(false);
		commandPanel.add(new JScrollPane(commandArea), BorderLayout.CENTER);
		
		center.add(chatPanel);
		center.add(commandPanel);
		
		return center;
	} // end of method createCenterPanel
	
	/**
	 * 
	 * @return
	 */
	public JPanel createBottomPanel()
	{
		JPanel bottomPanel = new JPanel();
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(500, 40));
		textField.setBackground(Color.BLACK);
		textField.setForeground(Color.WHITE);
		
		enterButton = new JButton("Enter");
		enterButton.setOpaque(true);
		enterButton.setBorderPainted(false);
		//enterButton.setContentAreaFilled(false);
		enterButton.setBackground(Color.RED);
		enterButton.setPreferredSize(new Dimension(100, 40));
		
		// add button and field to the bottom panel
		bottomPanel.add(textField);
		bottomPanel.add(enterButton);
		
		// create a listener for writing messages to server
		ActionListener listener = new EnterListener();
		
		// attach listener to the text field and button
		textField.addActionListener(listener);
		enterButton.addActionListener(listener);
		
		return bottomPanel;
	} // end of method createBottomPanel
	
	/**
	 *
	 */
	private class EnterListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			String s = textField.getText();
			
			try
			{
				output.writeObject(new AddMessageCommand(clientName + ":  " + s));
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			textField.setText("");
		}
	} // end of private class EnterListener
	
	/**
	 * Updates the chat log. Called by UpdateClientCommands
	 * 
	 * @param messages The current chat log
	 */
	public void update(List<String> messages) 
	{
		String s = "";
		for (String message: messages)
			s = s + message + "\n";
		
		chatArea.setText(s);
		chatArea.setCaretPosition(s.length());
		repaint();
	} // end of method update
} // end of class MUDView
