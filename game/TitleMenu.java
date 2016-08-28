package game;

import java.awt.Graphics2D;

import utilities.Images;

public class TitleMenu {
	
	public static int selection = 1;

	public void update(Graphics2D g){
		g.drawImage(Images.titlescreen, 0, 0, 1000, 750, null);
		
		if(selection == 0){
			g.drawImage(Images.selection_box, 70, 510, 395, 170, null);
		}
		if(selection == 1){
			g.drawImage(Images.selection_box, 540, 510, 395, 170, null);
		}
		
		if(selection >= 2) selection = 0;
		if(selection <= -1) selection = 1;
	}
}
