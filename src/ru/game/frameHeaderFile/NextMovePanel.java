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

public class NextMovePanel extends JPanel implements ActionListener, Constants {
	private static Random r = new Random();
	private static GamePanel gamePanel = new GamePanel();

	private static JButton nextMoveButton = new JButton("Next Balls");
	private JPanel colorPanel = new JPanel();

	private static JLabel[] colorLabel = new JLabel[NEXT_COLOR_ARRAY_LENGHT];
	private static int[] colorLabelIconIndex = new int[NEXT_COLOR_ARRAY_LENGHT];
	private static Icon[] nextColorIcon = new ImageIcon[ICON_ARRAY_LENGHT];

	public void initNextMovePanel() {
		setBackground(BACKGROUND_COLOR);
		setSize(NEXT_MOVE_PANEL_SIZE);
		setLayout(new GridLayout(2, 1));

		nextMoveButton.setBackground(BACKGROUND_COLOR);
		nextMoveButton.setFocusPainted(false);
		nextMoveButton.setForeground(Color.white);
		nextMoveButton.setRolloverEnabled(false);
		nextMoveButton.setBorderPainted(false);
		nextMoveButton.setContentAreaFilled(false);
		nextMoveButton.addActionListener(this);
		add(nextMoveButton);

		colorPanel.setLayout(new FlowLayout());
		colorPanel.setBackground(BACKGROUND_COLOR);
		add(colorPanel);

		initNextColorIcon();
		initNextColorLabel();
		randomColorLabel();
		initColorPanel();

	}

	/*
	 * veradardznum e hajord guyneri generacvac zangavac@ hamapatasxan
	 * indexnerov
	 */
	public static int[] getColorLabelIconIndex() {
		return colorLabelIconIndex;
	}

	/*
	 * generacnum e hajord 3 guyner@
	 */
	public void randomColorLabel() {
		for (int i = 0; i < colorLabel.length; i++) {
			colorLabelIconIndex[i] = r.nextInt(ICON_ARRAY_LENGHT);
			colorLabel[i].setIcon(nextColorIcon[colorLabelIconIndex[i]]);
		}
	}

	/*
	 * setup and add Color Label
	 */
	private void initColorPanel() {
		for (int i = 0; i < colorLabel.length; i++)
			colorPanel.add(colorLabel[i]);
	}

	/*
	 * Initilization next color label
	 */
	private void initNextColorLabel() {
		for (int i = 0; i < colorLabel.length; i++)
			colorLabel[i] = new JLabel();

	}

	/*
	 * Initilization next color icon
	 */
	private void initNextColorIcon() {
		for (int i = 0; i < nextColorIcon.length; i++)
			nextColorIcon[i] = new ImageIcon("image/small/" + Integer.toString(i + 1) + ".png");

	}
	/*
	 * Next Move Button 
	 * ACTION_LISTENER
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nextMoveButton) {
			gamePanel.threeRandomButton(getColorLabelIconIndex());
			randomColorLabel();
		}

	}

}
