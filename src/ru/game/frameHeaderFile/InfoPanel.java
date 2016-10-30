package ru.game.frameHeaderFile;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPanel extends JPanel implements Constants {
	private static int scoreResult=0; 
	
	private final Color backgroundColor = new Color(65, 65, 65);
	private final Dimension infoPanelSize = new Dimension(INFO_PANELWIDTH, INFO_PANEL_HEIGTH);
	
	private NextMovePanel nextMovePanel=new NextMovePanel();
	private ButtonReset buttonReset=new ButtonReset();
	
	private static JLabel scoreLabel=new JLabel("Score - "+Integer.toString(scoreResult));
	private static JLabel ballsCounter=new JLabel("Balls - "+Integer.toString(3));
	
	private final Font textFont=new Font("Arial",0,15);
	
	public void initInfoPanel(){
		setBackground(backgroundColor);
		setSize(infoPanelSize);
		setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(85, 85, 85)));
		setLayout(null);
		
		nextMovePanel.initNextMovePanel();
		add(nextMovePanel);
		nextMovePanel.setLocation(new Point(getWidth()-nextMovePanel.getWidth(), 0));
		
		scoreLabel.setFont(textFont);
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setBounds(10, 10, 115, 25);
		add(scoreLabel);
		
		ballsCounter.setFont(textFont);
		ballsCounter.setForeground(Color.WHITE);
		ballsCounter.setBounds(10, 50, 115, 25);
		add(ballsCounter);
		
		buttonReset.setLocation(215, 15);
		add(buttonReset);
	}
	// miavorneri hashvichi tarmacum
	public static void setScoreLabelCounter(int score) {
		scoreResult=score;
		scoreLabel.setText("Score - "+Integer.toString(scoreResult));
	}
	//stanum e miavorneri hashvichi arjeq@
	public static int getScoreLabelCounter() {
		return scoreResult;
	}
	// sharikneri hshvichi tarmacum 
	public static void setBallsCounter(int ballCounter) {
		ballsCounter.setText("Balls - "+Integer.toString(ballCounter));
	}
	//RESTAR
	public void reset(){
		scoreResult=0;
		scoreLabel.setText("Score - "+Integer.toString(scoreResult));
		ballsCounter.setText("Balls - "+Integer.toString(3));
	}
}

