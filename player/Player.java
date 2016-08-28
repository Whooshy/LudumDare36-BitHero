package player;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import game.Level;
import main.Main;
import utilities.Images;

public class Player {
	
	public static int x;
	public static int y;
	public static float velX, velY;
	
	public static float gravity = 5.5f;
	
	public static boolean isFalling, canJump;

	public Player(int x, int y){
		this.x = x;
		this.y = y;
		
		isFalling = true;
		canJump = false;
	}
	
	public void update(Graphics2D g){
		g.drawImage(Images.player, x, y, 64, 128, null);
		
		if(Main.debugMode){
			g.setColor(Color.YELLOW);
			g.draw(topHitbox());
			g.draw(bottomHitbox());
		}
		
		for(int i = 0; i < 1; i++){
			if(bottomHitbox().intersects(Level.hitbox[i])){
				isFalling = false;
				canJump = true;
				//System.out.println("YES");
			}else{
				isFalling = true;
				canJump = false;
			}
		}
		
		if(isFalling){ 
			velY = gravity;
		}else if(canJump){
			velY = 0;
		}
		
		x += velX;
		y += velY;
	}
	
	public static void jump(){
		velY = -15;
		System.out.println("Is this working?");
	}
	
	public Rectangle topHitbox(){
		return new Rectangle(x + 8, y, 64 - 16, 8);
	}
	
	public Rectangle bottomHitbox(){
		return new Rectangle(x + 8, y + 120, 64 - 16, 8);
	}
	
}
