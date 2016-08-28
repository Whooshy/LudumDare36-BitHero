package main;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import game.Level;
import game.RoomScene;
import game.TitleMenu;
import input.Key;
import player.Camera;
import utilities.Images;

public class Main extends Canvas implements Runnable, MouseListener{
	
	public Dimension size = new Dimension(1000, 750);
	public static Font normFont = new Font("Courier", Font.PLAIN, 20);
	
	private Thread thread;
	private boolean isRunning = false;
	
	public Images imgs;
	public RoomScene scene;
	public TitleMenu menu;
	public Key key;
	public Level lvl;
	public Camera cam;
	
	public static boolean debugMode = true;
	
	public static int STATE = 0;
	
	public Main(){
		JFrame frame = new JFrame("Game");
		imgs = new Images();
		scene = new RoomScene();
		menu = new TitleMenu();
		key = new Key();
		lvl = new Level();
		cam = new Camera();
		
		setPreferredSize(size);
		
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		frame.add(this, BorderLayout.CENTER);
		addKeyListener(key);
		addMouseListener(this);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		
		start();
	}

	public static void main(String[] args){
		new Main();
	}
	
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		
		isRunning = true;
	}
	
	public synchronized void stop(){
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		while(isRunning){
			try {
				thread.sleep(6);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			update();
		}
		stop();
	}
	
	public void update(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2 = (Graphics2D) g;
		
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 1000, 750);
		
		if(STATE == 0) scene.update(g2);
		if(STATE == 1) menu.update(g2);
		if(STATE == 2){
			cam.update();
			
			g.translate(cam.x, cam.y);
			lvl.update(g2);
			g.translate(-cam.x, -cam.y);
		}
		
		g.dispose();
		bs.show();
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		//System.out.println("Is this working?");
		
		if(x >= 350 && y >= 600 && x <= 530 && y <= 700){
			RoomScene.consoleHighlighted = true;
		}
	}

	public void mouseExited(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		//System.out.println("Is this not working?");
		
		if(x >= 350 && y >= 600 && x <= 530 && y <= 700){
			RoomScene.consoleHighlighted = false;
		}
	}

	public void mousePressed(MouseEvent e){
		int x = e.getX();
		int y = e.getY();
		
		if(x >= 350 && y >= 600 && x <= 530 && y <= 700){
			RoomScene.beginningGame = true;
		}
	}

	public void mouseReleased(MouseEvent e) {

	}
	
	
}
