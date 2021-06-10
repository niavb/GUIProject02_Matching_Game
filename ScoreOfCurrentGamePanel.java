package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ScoreOfCurrentGamePanel extends JPanel {

	public ScoreOfCurrentGamePanel() {
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		
		JLabel yourScoreLabel = new JLabel("Your score: ");
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(yourScoreLabel, gbc);
		
		JLabel yourMovesLabel = new JLabel();
		JLabel yourTimeLabel = new JLabel();
		
		JTextArea textArea = new JTextArea(5, 20);
		textArea.setEditable(false);
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(textArea, gbc);


	}

}
