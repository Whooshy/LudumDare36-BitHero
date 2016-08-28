package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.TitleMenu;
import main.Main;
import player.Player;

public class Key implements KeyListener{
	
	public Key(){
		System.out.println("KeyListener Initialized!");
	}

	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		
		if(k == e.VK_RIGHT){
			if(Main.STATE == 1) TitleMenu.selection++;
			//System.out.println("Umm...");
		}
		if(k == e.VK_LEFT){
			if(Main.STATE == 1) TitleMenu.selection--;
		}
		if(k == e.VK_ENTER){
			if(Main.STATE == 1 && TitleMenu.selection == 0) Main.STATE = 2;
			if(Main.STATE == 1 && TitleMenu.selection == 1) Main.STATE = 3;
		}
		if(k == e.VK_A){
			if(Main.STATE == 2){
				Player.velX = -4;
			}
		}
		if(k == e.VK_D){
			if(Main.STATE == 2) Player.velX = 4;
		}
		if(k == e.VK_SPACE){
			if(Main.STATE == 2 && Player.canJump){
				Player.jump();
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		int k = e.getKeyCode();
		
		if(k == e.VK_A || k == e.VK_D){
			if(Main.STATE == 2) Player.velX = 0;
		}
	}

	public void keyTyped(KeyEvent e) {

	}

	
}
