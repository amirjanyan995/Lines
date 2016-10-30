package ru.game.frameHeaderFile;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class ButtonReset extends JButton implements ActionListener {
	private static InfoPanel infoPanel = new InfoPanel();
	private static GamePanel gamePanel = new GamePanel();

	private static final Font presedFont = new Font("Arial", 0, 16);
	private static final Font releasedFont = new Font("Arial", 0, 14);

	public ButtonReset() {
		setText("Reset");
		setForeground(Color.white);
		setSize(90, 35);
		setFocusPainted(false);
		setBackground(new Color(65, 65, 65));
		setRolloverEnabled(false);
		setFont(releasedFont);
		setBorder(BorderFactory.createLineBorder(Color.white));

		setContentAreaFilled(false);
		// setContentAreaFilled(true);
		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				setFont(releasedFont);

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				setFont(presedFont);

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				setBorder(BorderFactory.createLineBorder(Color.white));
				setForeground(Color.white);
				setFont(releasedFont);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				setBorder(BorderFactory.createLineBorder(Color.CYAN));
				setForeground(Color.CYAN);
				setFont(new Font("Arial", 0, 14));
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				setBorder(BorderFactory.createLineBorder(Color.YELLOW));
				setForeground(Color.YELLOW);
			}
		});
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		infoPanel.reset();
		gamePanel.ResetGamePanel();
	}

}
