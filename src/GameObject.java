import java.awt.Graphics;

public class GameObject {

	int x;
	int y;
	int width;
	int height;

	boolean isAlive;

	public GameObject() {
		isAlive = true;

	}

	public void update() {

	}

	public void draw(Graphics g) {

		g.fillRect(x, y, 100, 100);
	}

}
