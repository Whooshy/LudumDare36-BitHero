package player;

public class Camera {
	
	public int x, y;

	public void update(){
		x = -Player.x + ((1000 / 2) - 32);
		y = -Player.y + ((750 / 2) - 64);
	}
}
