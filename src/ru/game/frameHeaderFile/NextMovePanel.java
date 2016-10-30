package ru.game.frameHeaderFile;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NextMovePanel extends JPanel implements ActionListener{
	private static Random r=new Random();
	private static GamePanel gamePanel=new GamePanel();
	private static final Color backgroundColor = new Color(65, 65, 65);
	private final  Dimension nextMovePanelSize = new Dimension(150, 79);
	
	//private final JLabel nextMoveLabel=new JLabe("Next Balls",JLabel.CENTER);
	private static JButton nextMoveButton=new JButton("Next Balls");
	private JPanel colorPanel=new JPanel();
	
	private static JLabel []colorLabel=new JLabel[3]; 
	private static int []colorLabelIconIndex=new int[3];
	private static Icon []nextColorIcon=new ImageIcon[7];
	public void initNextMovePanel(){
		setBackground(backgroundColor);
		setSize(nextMovePanelSize);
		setLayout(new GridLayout(2, 1));
		
		/*
		nextMoveLabel.setFont(new Font("Arial", 0, 14));
		nextMoveLabel.setForeground(Color.WHITE);
		add(nextMoveLabel);
		 */
		nextMoveButton.setBackground(backgroundColor);
		nextMoveButton.setFocusPainted(false);
		nextMoveButton.setForeground(Color.white);
		nextMoveButton.setRolloverEnabled(false);
		nextMoveButton.setBorderPainted(false);
		nextMoveButton.setContentAreaFilled(false);
		nextMoveButton.addActionListener(this);
		add(nextMoveButton);
		
		
		colorPanel.setLayout(new FlowLayout());
		colorPanel.setBackground(backgroundColor);
		add(colorPanel);
		
		initNextColorIcon();
		initNextColorLabel();
		randomColorLabel();
		initColorPanel();
		
	}
	
	public static int[] getColorLabelIconIndex() {
		return colorLabelIconIndex;
	}
	public  void randomColorLabel(){
		for(int i=0;i<colorLabel.length;i++){
			colorLabelIconIndex[i]=r.nextInt(7);
			//System.out.println(colorLabelIconIndex[i]);
			colorLabel[i].setIcon(nextColorIcon[colorLabelIconIndex[i]]);
		}
	}
	private void initColorPanel(){
		for(int i=0;i<colorLabel.length;i++){
			colorPanel.add(colorLabel[i]);
		}
	}
	private void initNextColorLabel() {
		for(int i=0;i<colorLabel.length;i++){
			colorLabel[i]=new JLabel();
		}
	}
	private void initNextColorIcon() {
		//String[] iconName = { "aqua", "blue", "green", "pink", "red", "violet", "yellow" };
		for (int i = 0; i <nextColorIcon.length; i++) {
			nextColorIcon[i] = new ImageIcon("image/small/" + Integer.toString(i+1) + ".png");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==nextMoveButton){
			gamePanel.threeRandomButton(getColorLabelIconIndex());
			randomColorLabel();
		}
		
	}

}
