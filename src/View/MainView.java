package View;

import java.io.*;
import java.awt.*;
import java.util.*;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;

import Commands.AddChatMessageCommand;
import Commands.ForServerCommand;
import Commands.ForServerW2ArgsCommand;
import Commands.ForServerWArgsCommand;
import Commands.TellMessageCommand;
import Enums.Commands;
import Model.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MainView extends JPanel
{
	private static final long serialVersionUID = 818711182821925316L;
	private JTextArea chatArea, commandArea; 
	private JTextField textField; // field where user enters text
	private JButton enterButton;
	
	private ObjectOutputStream output; // output stream to server
	private String clientName;
	
	public MainView(String clientName, ObjectOutputStream output)
	{
		this.output = output;
		this.clientName = clientName;
		
		this.setLayout(new BorderLayout());
		//background.setLayout(new BorderLayout());
		
		// create and add top panel of MudGUI
		this.add(createTopPanel(), BorderLayout.NORTH);
		
		// create and add center panel of MudGUI
		this.add(createCenterPanel(), BorderLayout.CENTER);
		
		// create and add bottom panel of MudGUI
		this.add(createBottomPanel(), BorderLayout.SOUTH);
	}
	
	public JPanel createTopPanel()
	{
		JPanel top = new JPanel();
		
		JLabel banner = new JLabel("SAVE YO ASS", JLabel.CENTER);
		banner.setPreferredSize(new Dimension(1100, 60));
		banner.setForeground(Color.RED);
        banner.setOpaque(true);
        banner.setFont(getFont("fonts/cenobyte.ttf"));
        
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
		chatArea.setLineWrap(true);
		chatArea.setBackground(Color.BLACK);
		chatArea.setForeground(Color.WHITE);
		chatArea.setEditable(false);
		chatArea.setFont(getFont("fonts/trajan.ttf").deriveFont(12f));
		chatPanel.add(new JScrollPane(chatArea), BorderLayout.CENTER);
		
		JPanel commandPanel = new JPanel();
		commandPanel.setLayout(new BorderLayout());
		commandPanel.setPreferredSize(new Dimension(550, 550));

		// initialize the text area and add it to the command panel
		commandArea = new JTextArea();
		commandArea.setLineWrap(true);
		commandArea.setBackground(Color.BLACK);
		commandArea.setForeground(Color.WHITE);
		commandArea.setEditable(false);
		commandArea.setFont(getFont("fonts/trajan.ttf").deriveFont(12f));
		commandPanel.add(new JScrollPane(commandArea), BorderLayout.CENTER);
		
		center.add(chatPanel);
		center.add(commandPanel);
		
		return center;
	} // end of method createCenterPanel
	
	public JPanel createBottomPanel()
	{
		JPanel bottomPanel = new JPanel();
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(500, 40));
		textField.setBackground(Color.BLACK);
		textField.setForeground(Color.WHITE);
		textField.setFont(getFont("fonts/trajan.ttf").deriveFont(12f));
		
		enterButton = new JButton("Enter");
		enterButton.setOpaque(true);
		enterButton.setBorderPainted(false);
		//enterButton.setContentAreaFilled(false);
		enterButton.setBackground(Color.RED);
		enterButton.setForeground(Color.WHITE);
		enterButton.setFont(getFont("fonts/cenobyte.ttf").deriveFont(14f));
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
	
	private class EnterListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			/*String s = textField.getText().toUpperCase();

			String command = new String();
			String argument = new String();
			String argument1 = new String();
			String argument2 = new String();
			int spaceCount = 0;
			
			String[] split = s.split(" ", 2);
			command = split[0];
			
			for(int i = 0; i < s.length(); i++)
			{
				if(s.charAt(i) == ' ')
				{
					spaceCount++;
				}
			}
			
			
			
			if (spaceCount == 1)
			{
				String[] splitS = s.split(" ", 2);
				command = splitS[0];
				argument = splitS[1];
			}
			
			else if (spaceCount > 1 && !command.equalsIgnoreCase("OOC"))
			{
				String[] splitS = s.split(" ", 3);
				command = splitS[0];
				argument1 = splitS[1];
				argument2 = splitS[2];
				String sCopy = s;
				int index = s.indexOf(" ");
				command = s.substring(0, index);
				sCopy = sCopy.substring(index + 1);
				index = sCopy.indexOf(" ");
				argument1 = sCopy.substring(0, index);
				sCopy = sCopy.substring(index + 1);
				argument2 = sCopy;
				
			}
			else if(command.equalsIgnoreCase("OOC"))
			{
				argument1 = split[1];
			}
			
			else
			{
				command = s;
			}*/
			
			String s = textField.getText().toUpperCase();
			
			int spaceCount = 0;
			
			for(int i = 0; i < s.length(); i++)
			{
				if(s.charAt(i) == ' ')
				{
					spaceCount++;
				}
			}

			String command = new String();
			String argument = new String();
			String argument2 = new String();
			
			String[] firstSplit = s.split(" ", 2);
			command = firstSplit[0];
			
			
			switch(command)
			{
			case "TELL":
				String[] tellSplit = s.split(" ", 3);
				argument = tellSplit[1];
				argument2 = tellSplit[2];
				break;
			case "GET":
				
				//need 2 args version
				
				String[] getSplit = s.split(" ", 2);
				argument = getSplit[1];
				break;
			case "GIVE":
				String[] giveSplit = s.split(" ", 3);
				argument = giveSplit[1];
				argument2 = giveSplit[2];
				
				break;
			case "OOC":
				String[] oocSplit = s.split(" ", 2);
				argument = oocSplit[1];
				break;
			case "LOOK":
				if(spaceCount == 0)
					command = s;
				else
				{
					String[] lookSplit = s.split(" ", 2);
					argument = lookSplit[1];
				}
				break;
			case "INVENTORY":
				command = s;
				break;
			case "SCORE":
				command = s;
				break;
			case "WHO":
				command = s;
				break;
			case "SAY":
				break;
			case "COMMANDS":
				command = s;
				break;
			case "USE":
				break;
			case "QUIT":
				//command = s;
				break;
			case "DROP":
				String[] dropSplit = s.split(" ", 2);
				argument = dropSplit[1];
				break;
			case "SHUTDOWN":
				//command = s;
				break;
			case "MOVE":
				String[] moveSplit = s.split(" ", 2);
				argument = moveSplit[1];
				break;
			
			}
			
			/*if (s.indexOf(" ") > 0)
			{
				String[] splitS = s.split(" ", 2);
				//command = splitS[0];
				argument = splitS[1];
			}
			
			else
			{
				command = s;
			}*/
			
			Commands c = Commands.valueOf(command);
			
			
			try
			{
				switch(c)
				{
				case DROP:
				case GET:
					output.writeObject(new ForServerWArgsCommand(clientName, argument, c));
					break;
				case MOVE:
					if(!argument.equals(""))
					{
						output.writeObject(new ForServerWArgsCommand(clientName, argument, c));
					}
					break;
				case SCORE:
				case INVENTORY:
				case COMMANDS:
				case WHO:
				case QUIT:
				case MAP:
					output.writeObject(new ForServerCommand(clientName, c));
					break;
				case LOOK:
					if(argument.equals(""))
						output.writeObject(new ForServerCommand(clientName, c));
					
					else
						output.writeObject(new ForServerWArgsCommand(clientName, argument, c));
					
					break;
				case OOC:
					output.writeObject(new AddChatMessageCommand(clientName + ":  " + argument));
					break;
				case SHUTDOWN:
					if(clientName.equalsIgnoreCase("alby") || clientName.equalsIgnoreCase("damaris") || clientName.equalsIgnoreCase("alexa")
							|| clientName.equalsIgnoreCase("lisa")){
					output.writeObject(new ForServerCommand(clientName, c));
					}
					break;
				case TELL:
					output.writeObject(new TellMessageCommand(clientName, argument, argument2, c));
				default:
					break;
				}

			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			textField.setText("");
		}
	} // end of private class EnterListener
	
	/**
	 * Updates the chat log and command log. Called by UpdateClientCommands
	 * 
	 * @param chatMessages The current chat log
	 */
	public void update(List<String> chatMessages, List<String> commandMessages) 
	{
		String chat = "";
		for (String message: chatMessages)
			chat = chat + message + "\n";
		
		chatArea.setText(chat);
		chatArea.setCaretPosition(chat.length());
		
		String command = "";
		for (String message: commandMessages)
			command = command + message + "\n";
		
		commandArea.setText(command);
		commandArea.setCaretPosition(command.length());
		
		repaint();
	} // end of method update
	
	public void updateCommands(List<String> commandMessages)
	{
		String command = "";
		for (String message: commandMessages)
			command = command + message + "\n";
		
		commandArea.setText(command);
		commandArea.setCaretPosition(command.length());
		
		repaint();
	} // end of method updateCommands
} // end of class MainPanel
