package ru.game.frameHeaderFile;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, Constants {

	private static Random r = new Random();
	private NextMovePanel nextColorPanel = new NextMovePanel();

	private static Icon[] buttonIcon;
	private static Icon[] smallButtonIcon;
	private static ClickButton[][] button;

	private boolean clicked = false;
	private int lastX = 0, lastY = 0;

	private static int[][] gameArray;
	private static int[][] newGameArray = new int[ARRAY_LENGTH][ARRAY_LENGTH];

	/*
	 * Xaxayin dashti stexcum
	 */
	public void InitGamePanel() {
		setBackground(BACKGROUND_COLOR);
		setSize(GAME_PANEL_SIZE);
		setLayout(new GridLayout(ARRAY_LENGTH, ARRAY_LENGTH));

		initButtonIcon();

		setupAndAddButton();

		gameArray = initGameArray(gameArray);

		threeRandomButton();
	}

	/*
	 * nerqin stugvox zangvaci stexcum
	 */
	private int[][] initGameArray(int[][] gameArray) {
		gameArray = new int[ARRAY_LENGTH][ARRAY_LENGTH];
		for (int i = 0; i < gameArray.length; i++) {
			for (int j = 0; j < gameArray[i].length; j++) {
				gameArray[i][j] = 0;
			}
		}
		return gameArray;
	}

	/*
	 * Set-Up and Add button on gamePanel
	 */
	private void setupAndAddButton() {
		button = new ClickButton[ARRAY_LENGTH][ARRAY_LENGTH];
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button[i].length; j++) {
				button[i][j] = new ClickButton();
				button[i][j].addActionListener(this);
				add(button[i][j]);
			}
		}
	}

	/*
	 * Initilization icon name array Initilization button icon array
	 */
	private void initButtonIcon() {
		buttonIcon = new ImageIcon[ICON_ARRAY_LENGHT];
		smallButtonIcon = new ImageIcon[ICON_ARRAY_LENGHT];
		for (int i = 0; i < buttonIcon.length; i++) {
			buttonIcon[i] = new ImageIcon("image/" + Integer.toString(i + 1) + ".png");
			smallButtonIcon[i] = new ImageIcon("image/small/" + Integer.toString(i + 1) + ".png");
		}
	}

	/*
	 * show game Array
	 */
	private static void showGmaeArray() {
		System.out.println("---------------");
		for (int i = 0; i < gameArray.length; i++) {
			for (int j = 0; j < gameArray[i].length; j++) {
				if (gameArray[i][j] == 0)
					System.out.print("0 ");
				else
					System.out.print(gameArray[i][j] + " ");
			}
			System.out.println();
		}
	}

	/*
	 * 3 patahakan guyneri nshanakum
	 */
	private void threeRandomButton() {
		int x = 0;
		int y = 0;
		int iconIndex = 0;
		for (int i = 0; i < 3; i++) {
			while (true) {
				x = r.nextInt(ARRAY_LENGTH);
				y = r.nextInt(ARRAY_LENGTH);
				if (button[x][y].getIcon() == null) {
					iconIndex = r.nextInt(7);
					gameArray[x][y] = iconIndex + 1;
					button[x][y].setIcon(buttonIcon[iconIndex]);
					break;
				} else {
					continue;
				}

			}
		}
	}

	/*
	 * 3 patahakan guyneri texadrum
	 * 
	 * @param- colorIconLabelIndex
	 */
	static void threeRandomButton(int[] colorIconLabelIndex) {
		int[] x = new int[3];
		int[] y = new int[3];
		if (dashtizbaxvacucyun() == 0)
			return;

		for (int i = 0; i < NEXT_COLOR_ARRAY_LENGHT; i++) {

			while (true) {
				x[i] = r.nextInt(ARRAY_LENGTH);
				y[i] = r.nextInt(ARRAY_LENGTH);
				if (button[x[i]][y[i]].getIcon() == null) {
					gameArray[x[i]][y[i]] = colorIconLabelIndex[i] + 1;
					button[x[i]][y[i]].setIcon(buttonIcon[colorIconLabelIndex[i]]);
					buttonClickAction(GameCheck.headerCheck(x[i], y[i], gameArray));
					break;
				} else {
					continue;
				}
			}
		}
	}

	/*
	 * stugum e dhashtum azat vandakneri qanak@
	 */
	private static int dashtizbaxvacucyun() {
		int num = 0;
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button[i].length; j++) {
				if (button[i][j].getIcon() == null)
					num++;
			}
		}
		return num;
	}

	/*
	 * katarum e stugum lrazvac hatvacneri hamar ev maqrum bolor lracvac
	 * hatvacner@ xaxayin dashtic
	 */
	public static boolean buttonClickAction(int array[][]) {
		boolean check = false;
		int balls = 0;
		int score = 0;

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				newGameArray[i][j] = array[i][j];
			}
		}

		for (int i = 0; i < newGameArray.length; i++) {
			for (int j = 0; j < newGameArray[i].length; j++) {
				if (newGameArray[i][j] != 0)
					balls++;
				if (newGameArray[i][j] != gameArray[i][j]) {
					check = true;
					button[i][j].setIcon(null);
					score++;
					gameArray[i][j] = newGameArray[i][j];
				}
			}
		}
		InfoPanel.setBallsCounter(balls);
		InfoPanel.setScoreLabelCounter(InfoPanel.getScoreLabelCounter() + (score * 2));

		return check;
	}

	/*
	 * NEW GAME _ RESTART
	 */
	public void ResetGamePanel() {
		gameArray = initGameArray(gameArray);
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button[i].length; j++) {
				button[i][j].setIcon(null);
				button[i][j].setBackground(BUTTON_COLOR);
			}
		}
		threeRandomButton();
		nextColorPanel.randomColorLabel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button[i].length; j++) {
				if (e.getSource() == button[i][j]) {
					// ete clicked=True nashakum e button sxmvac e
					// ete false sxmvac che
					if (clicked && (DFS.dfs(gameArray, lastX, lastY, i, j))) {
						if (button[i][j].getIcon() == null) {

							button[i][j].setIcon(button[lastX][lastY].getIcon());
							button[lastX][lastY].setIcon(null);
							button[lastX][lastY].setBackground(BUTTON_COLOR);

							gameArray[i][j] = gameArray[lastX][lastY];
							gameArray[lastX][lastY] = 0;

							clicked = false;

							if (!buttonClickAction(GameCheck.headerCheck(i, j, gameArray)))
								threeRandomButton(nextColorPanel.getColorLabelIconIndex());

							nextColorPanel.randomColorLabel();
						} else {
							button[lastX][lastY].setBackground(BUTTON_COLOR);
							button[i][j].setBackground(BUTTON_CLICKED_COLOR);
							
							lastX = i;
							lastY = j;
						}
					} else if (button[i][j].getIcon() != null) {
						button[lastX][lastY].setBackground(BUTTON_COLOR);
						button[i][j].setBackground(BUTTON_CLICKED_COLOR);
						clicked = true;
						lastX = i;
						lastY = j;
					}

				}
			}
		}
	}
}