package ru.game.frameHeaderFile;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;


public class ClickButton extends JButton{

	private Color buttonBGColor=new Color(80,80,80);
	public ClickButton() {
		setDefaultCapable(false);
		setBackground(buttonBGColor);
		setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(65,65,65)));
		setFocusPainted(false);
		setRolloverEnabled(false);
		
	}

}
