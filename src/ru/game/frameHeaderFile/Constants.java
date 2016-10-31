package ru.game.frameHeaderFile;

import java.awt.Color;
import java.awt.Dimension;

public interface Constants {
	/*
	 * Frame Sizes
	 */
	final int FRAME_WIDTH=524;		//patuhani laynutyun
	final int FRAME_HEIGTH=628;		//patuhani bardzrutyun
	
	final int INFO_PANEL_WIDTH=FRAME_WIDTH;	//tvyalneri dashti laynutyun
	final int INFO_PANEL_HEIGTH=80;			//tvyalneri dashti bardzrutyun
	final Dimension INFO_PANEL_SIZE = new Dimension(INFO_PANEL_WIDTH, INFO_PANEL_HEIGTH);
	
	final int NEXT_MOVE_PANEL_WIDTH=150;
	final int NEXT_MOVE_PANEL_HEIGTH=70;
	final  Dimension NEXT_MOVE_PANEL_SIZE = new Dimension(NEXT_MOVE_PANEL_WIDTH, NEXT_MOVE_PANEL_HEIGTH);
	
	final int GAME_PANEL_WIDTH=520;	 //xaxayin dashti laynutyun
	final int GAME_PANEL_HEIGTH=520; //xaxayin dashti bardzrutyun
	final Dimension GAME_PANEL_SIZE = new Dimension(GAME_PANEL_WIDTH, GAME_PANEL_HEIGTH);
	
	final Color BACKGROUND_COLOR=new Color(65,65,65);
	final Color BUTTON_COLOR = new Color(80, 80, 80);
	final Color BUTTON_CLICKED_COLOR = new Color(120, 120, 120);
	
	final int ARRAY_LENGTH=9;
	final int ICON_ARRAY_LENGHT=7;
	final int NEXT_COLOR_ARRAY_LENGHT=3;
	
	
}
