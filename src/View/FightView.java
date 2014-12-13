package View;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import MOBs.MOB;
import Players.Player;

public class FightView extends JFrame {
	
	private BufferedImage backgroundImage;
	private JTextArea text;
	private BufferedImage image;
	private String message = "Yo Ass Is Dead fight mode";
	private Player player;
	private MOB opponent;
	
	public FightView(Player player, MOB opponent){
		this.player = player;
		this.opponent = opponent;
		
		this.setTitle("Save Yo Ass MOB Description");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		try {
			backgroundImage = ImageIO.read(new File("images/scaryRoom.jpg"));
			this.setContentPane(new JLabel(new ImageIcon(backgroundImage)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		this.setSize(backgroundImage.getWidth(), backgroundImage.getHeight()-250);
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
}