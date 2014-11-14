package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;

import javax.swing.*;

import Model.AddMessageCommand;

/**
 * 
 * @author Team Alpha-Super-Awesome-Cool-Dynamite-Wolf-Squadron
 *
 */
public class MUDView extends JFrame
{
	private static final long serialVersionUID = 7477644930151827118L;
	private JTextArea chatArea, commandArea; 
	private JTextField textField; // field where user enters text
	
	private ObjectOutputStream output; // output stream to server
	private String clientName;
	

	public static void main(String [] args)
	{
		new MUDView();
	} // end of method main
	
	/**
	 * 
	 */
	public MUDView()
	{
		setupGUI();
	} // end of constructor MUDView
	
	/**
	 * 
	 */
	public void setupGUI()
	{
		
	}
	
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
		}
	}
} // end of class MUDView
