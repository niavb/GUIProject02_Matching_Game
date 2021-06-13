package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StartMenuPanel extends JPanel {
	JButton startBtn = new JButton("Start game");
	JLabel addName = new JLabel("Enter username: ");
	JTextField textFieldForName = new JTextField();
	String name;
	BufferedImage background;

	public StartMenuPanel() {
		setLayout(new GridBagLayout());
		try {
			background = ImageIO.read(new File("src/app/startMenuBackground.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		gbc.gridx = GridBagConstraints.CENTER;
		gbc.gridy = 4;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		addName.setForeground(Color.WHITE);
		add(addName, gbc);
		
		gbc.gridy = 5;
		gbc.gridwidth = 5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(textFieldForName, gbc);
		
		gbc.gridy = 6;
		gbc.gridwidth = 5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(startBtn, gbc);
		
	}
	
	 protected void paintComponent(Graphics g) {

		    super.paintComponent(g);
		        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
		}

}
