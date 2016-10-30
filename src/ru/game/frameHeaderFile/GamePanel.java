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

	private static ParalelPatok patok1=new ParalelPatok();
	private static Random r = new Random();
	private static NextMovePanel nextColorPanel = new NextMovePanel();

	private final Dimension panelSize = new Dimension(GAME_PANEL_WIDTH, GAME_PANEL_HEIGTH);
	private static Icon[] buttonIcon;
	private static ClickButton[][] button;

	private static final Color buttonColor = new Color(80, 80, 80);
	private static final Color buttonClickedColor = new Color(120, 120, 120);
	private final Color backgroundColor = new Color(65, 65, 65);

	private static boolean clicked = false;
	private static int lastX = 0, lastY = 0;

	private static int[][] gameArray;
	private static int[][] newGameArray = new int[ARRAY_LENGTH][ARRAY_LENGTH];

	/*
	 * Xaxayin dashti stexcum
	 */
	public void InitGamePanel() {
		setBackground(backgroundColor);
		setSize(panelSize);
		setLayout(new GridLayout(ARRAY_LENGTH, ARRAY_LENGTH));

		initButtonIcon();

		setupAndAddButton();

		gameArray = initGameArray(gameArray);

		threeRandomButton();
	}

	/*
	 * nerqin stugman zangvaci stexcum
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
		buttonIcon = new ImageIcon[7];
		for (int i = 0; i < buttonIcon.length; i++) {
			buttonIcon[i] = new ImageIcon("image/" + Integer.toString(i + 1) + ".png");
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
	 * 3 patahakan  guyneri nshanakum
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
	 * @param- colorIconLabelIndex
	 */
	static void threeRandomButton(int[] colorIconLabelIndex) {
		int x = 0;
		int y = 0;
		
		if (dashtizbaxvacucyun() == 0)
			return;
		
		for (int i = 0; i < 3; i++) {
			while (true) {
				x = r.nextInt(ARRAY_LENGTH);
				y = r.nextInt(ARRAY_LENGTH);
				if (button[x][y].getIcon() == null) {
					gameArray[x][y] = colorIconLabelIndex[i] + 1;
					button[x][y].setIcon(buttonIcon[colorIconLabelIndex[i]]);
					buttonClickAction(GameCheck.headerCheck(x, y, gameArray));
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
	 * katarum e stugum  lrazvac hatvacneri hamar 
	 * ev maqrum bolor lracvac hatvacner@ xaxayin dashtic
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
	 * NEW GAME
	 */
	public void ResetGamePanel() {
		gameArray = initGameArray(gameArray);
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button[i].length; j++) {
				button[i][j].setIcon(null);
				button[i][j].setBackground(buttonColor);
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
							button[lastX][lastY].setBackground(buttonColor);
							gameArray[i][j] = gameArray[lastX][lastY];
							gameArray[lastX][lastY] = 0;

							clicked = false;
							
							//patok1.run(i,j,gameArray);
							
							
							if (!buttonClickAction(GameCheck.headerCheck(i, j, gameArray)))
								threeRandomButton(nextColorPanel.getColorLabelIconIndex());

							nextColorPanel.randomColorLabel();
								
							//showGmaeArray();
						} else {
							button[lastX][lastY].setBackground(buttonColor);
							button[i][j].setBackground(buttonClickedColor);
							lastX = i;
							lastY = j;
						}
					} else if (button[i][j].getIcon() != null) {
						button[lastX][lastY].setBackground(buttonColor);
						button[i][j].setBackground(buttonClickedColor);
						clicked = true;
						lastX = i;
						lastY = j;
					}

				}
			}
		}
	}
}