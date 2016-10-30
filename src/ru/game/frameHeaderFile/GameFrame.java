package ru.game.frameHeaderFile;

import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameFrame extends JFrame implements Constants{
	
	private ImageIcon frameIcon=new ImageIcon("image/gameIcon.jpg");
	private InfoPanel infoPanel;
	private GamePanel gamePanel;
	
	public void initGui(){
		setTitle("Lines");
		setBounds(550,50,FRAME_WIDTH,FRAME_HEIGTH);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIconImage(frameIcon.getImage());
		setLayout(null);
		
		initInfoPanel();
		initGamePanel();
		
		setVisible(true);
	}
	private void initInfoPanel(){
		final Point infoPnaleLocation=new Point(0, 0);
		infoPanel=new InfoPanel();
		infoPanel.initInfoPanel();
		infoPanel.setLocation(infoPnaleLocation);
		add(infoPanel);
	}
	private void initGamePanel(){
		final Point gamePanaleLocation=new Point(0, 80);
		gamePanel=new GamePanel();
		gamePanel.InitGamePanel();
		gamePanel.setLocation(gamePanaleLocation);
		add(gamePanel);
	}
}
