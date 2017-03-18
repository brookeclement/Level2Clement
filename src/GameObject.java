import java.awt.Graphics;
import java.util.Random;

public class GameObject {

	int x;
	int y;
	int width;
	int height;

	public GameObject() {

	}

	public void update() {
		int randX = new Random().nextInt(500);
		int randY = new Random().nextInt(800);
		x = randX;
		y = randY;
	}

	public void draw(Graphics g) {
		g.fillRect(x, y, 100, 100);
	}

}
