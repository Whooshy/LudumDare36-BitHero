package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.Main;
import player.Player;
import utilities.Images;

public class Level {
	
	Player player = new Player(500, 400);
	public static Rectangle[] hitbox = new Rectangle[20];

	public void update(Graphics2D g){
		for(int x = 0; x < 16 * 64; x += 64) for(int y = 600; y < (3 * 64) + 600; y += 64)
		g.drawImage(Images.getTile(Images.tilesheet, 1, 1, 8), x, y, 64, 64, null);
		
		hitbox[0] = new Rectangle(0, 600, 1024, 192);
		
		if(Main.debugMode){
			g.setColor(Color.YELLOW);
			g.draw(hitbox[0]);
		}
		
		player.update(g);
	}

}
