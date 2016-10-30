package ru.game.frameHeaderFile;

public class ParalelPatok extends Thread {
	GamePanel gamePanel = new GamePanel();
	NextMovePanel nextColorPanel=new NextMovePanel();

	public void run(int i,int j,int gameArray[][]) {
		System.out.println("run(i,j,gameArray)");
		if (!gamePanel.buttonClickAction(GameCheck.headerCheck(i, j, gameArray)))
			gamePanel.threeRandomButton(nextColorPanel.getColorLabelIconIndex());

		nextColorPanel.randomColorLabel();
		
	}
	@Override
	public void run() {
		System.out.println("run()");
	}
}
