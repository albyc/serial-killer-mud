package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class MOBdescription extends JFrame{
	
	private BufferedImage backgroundImage;
	private BufferedImage dahmerImage;
	private JTextArea infoArea;
	
	public MOBdescription(String mobName){
		
		this.setTitle("Save Yo Ass MOB Description");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		try 
		{
			backgroundImage = ImageIO.read(new File("images/scary-wall.jpg"));
			this.setContentPane(new JLabel(new ImageIcon(backgroundImage)));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		this.setSize(backgroundImage.getWidth(),backgroundImage.getHeight());
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		
		if(mobName.equals("jeffery dahmer") || mobName.equals("dahmer")){
			infoArea = new JTextArea("\n    jeffery dahmer info");
		}
		else if(mobName.equals("lawrence bittaker") || mobName.equals("roy norris") || mobName.equals("bittaker") || mobName.equals("norris") || mobName.equals("toolbox killers")){
			infoArea = new JTextArea("\n\tthe toolbox killers info");
			//add images
		}
		else if(mobName.equals("richard ramirez") || mobName.equals("ramirez")){
			infoArea = new JTextArea("\n\trichard ramirez info");
			//add images
		}
		else if(mobName.equals("andre chikatilo") || mobName.equals("chikatilo") || mobName.equals("red ripper")){
			infoArea = new JTextArea("\n\tandre chikatilo info");
			//add images
		}
		else if(mobName.equals("richard trenton chase") || mobName.equals("richard chase") || mobName.equals("chase")){
			infoArea = new JTextArea("\n\trichard trenton chase info");
			//add images
		}
		else if(mobName.equals("henry lee lucus") || mobName.equals("henry lucus") ||mobName.equals("lucus")){
			infoArea = new JTextArea("\n\thenry lee lucus info");
			//add images
		}
		else if(mobName.equals("ed gein") || mobName.equals("gein") || mobName.equals("psycho")){
			infoArea = new JTextArea("\n\ted gein info");
			//add images
		}
		
		infoArea.setFont(getFont("fonts/trajan.ttf").deriveFont(12f));
		infoArea.setEditable(false);
		infoArea.setSize(277,420);
		infoArea.setLocation(572, 195);
		infoArea.setBackground(Color.BLACK);
		infoArea.setForeground(Color.WHITE);
		
		this.add(infoArea);
		this.setVisible(true);
	}
	
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

}
