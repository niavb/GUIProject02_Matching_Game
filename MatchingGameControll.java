package app;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class MatchingGameControll extends JPanel{
	private MatchingGamePanel matchingGamePanel = new MatchingGamePanel();
	
	public MatchingGameControll() {
		setLayout(new BorderLayout());
		add(matchingGamePanel, BorderLayout.CENTER);
		
		matchingGamePanel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int x, y;//coordinates of the clicked mouse
				int width = matchingGamePanel.getWidth()/4;
				int height = matchingGamePanel.getHeight()/3;
				
				if(e.getX()<=width) x = 0;
				else if(e.getX()>width && e.getX()<=2*width) x = 1;
				else if(e.getX()>2*width && e.getX()<=3*width) x = 2;
				else x = 3;
				
				if(e.getY()<=height) y = 0;
				else if(e.getY()>height && e.getY()<=2*height) y = 1;
				else y = 2;
				
				matchingGamePanel.turnCard(x, y);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

}