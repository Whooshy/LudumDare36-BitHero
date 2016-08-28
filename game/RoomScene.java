package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.Main;
import utilities.Images;

public class RoomScene {
	
	public static int frameCount = 0;
	public static int frameCount2 = 0;
	
	public static boolean consoleHighlighted = false;
	public static boolean beginningGame = false;
	
	public static int x, y, width, height;
	
	public RoomScene(){
		x = 0;
		y = 0;
		width = 1000;
		height = 750;
	}

	public void update(Graphics2D g){
		frameCount++;
		g.drawImage(Images.livingroom, x, y, width, height, null);
		
		g.setFont(Main.normFont);
		g.setColor(Color.YELLOW);
		
		if(consoleHighlighted){
			//System.out.println("Test");
			g.setColor(Color.RED);
		}
		if(frameCount >= 500 && !beginningGame){
			g.drawString("Please press the console to begin...", 50, 100);
		}
		
		if(Main.debugMode){
			//System.out.println("Test 2");
			g.setColor(Color.BLUE);
			g.draw(new Rectangle(350, 600, 180, 100));
		}
		
		if(beginningGame){
			begin();
		}
	}
	
	public void begin(){
		frameCount2++;
		
		x -= 20;
		y -= 20;
		width += 40;
		height += 40;
		
		//System.out.println(frameCount);
		
		if(frameCount2 >= 500) Main.STATE = 1;
	}
}
