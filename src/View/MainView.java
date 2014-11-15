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

import Model.AddMessageCommand;

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
	
	/**
	 * 
	 * @return
	 */
	public JPanel createTopPanel()
	{
		JPanel top = new JPanel();
		
		JLabel banner = new JLabel("DEATH MATCH", JLabel.CENTER);
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
		enterButton.setPreferredSize(new Dimension(75, 40));
		
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
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		try
		{
			g2.drawImage(ImageIO.read(new File("scary-wall.JPG")), 0, 0, null);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("stuff");
		}
	}
	
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
}
