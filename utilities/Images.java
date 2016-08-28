package utilities;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	
	public static BufferedImage livingroom;
	public static BufferedImage titlescreen;
	public static BufferedImage selection_box;
	public static BufferedImage player;
	public static BufferedImage tilesheet;

	public Images(){
		try {
			livingroom = ImageIO.read(getClass().getResource("/scenes/livingroom.png"));
			titlescreen = ImageIO.read(getClass().getResource("/logos/bit_hero.png"));
			selection_box = ImageIO.read(getClass().getResource("/misc/selection_box.png"));
			player = ImageIO.read(getClass().getResource("/objects/player/player.png"));
			tilesheet = ImageIO.read(getClass().getResource("/objects/tiles/tile_sheet1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static BufferedImage getTile(BufferedImage img, int column, int row, int size){
		img = img.getSubimage((column * size) - size, (row * size) - size, size, size);
		return img;
	}
}
