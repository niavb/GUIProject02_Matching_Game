package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class ScoreOfCurrentGamePanel extends JPanel {
	JTextArea textAreaOfScores;
	JLabel yourScoreLabel = new JLabel();
	JLabel leaderboardLabel = new JLabel("Leaderboard: ");
	BufferedImage background;

	public ScoreOfCurrentGamePanel() {
		
		try {
			background = ImageIO.read(new File("src/app/endBackgroundPic.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		
		gbc.gridx = GridBagConstraints.CENTER;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		yourScoreLabel.setForeground(Color.WHITE);
		add(yourScoreLabel, gbc);
		
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(leaderboardLabel, gbc);
		
		textAreaOfScores = new JTextArea(5, 20);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		textAreaOfScores.setBorder(BorderFactory.createCompoundBorder(border, 
			      BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		textAreaOfScores.setEditable(false);
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(textAreaOfScores, gbc);


	}
	
	protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	}

}
