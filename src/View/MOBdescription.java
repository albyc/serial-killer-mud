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
	
	private BufferedImage image;
	private JTextArea infoArea;
	
	public MOBdescription(String mobName){
		
		this.setTitle("Save Yo Ass Map");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		try 
		{
			image = ImageIO.read(new File("images/MAP.jpg"));
			this.setContentPane(new JLabel(new ImageIcon(image)));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		// has to be here before try catch block
		this.setSize(image.getWidth(),image.getHeight());
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
//		infoArea = new JTextArea("");
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
