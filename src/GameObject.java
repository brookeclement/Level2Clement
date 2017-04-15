import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {

	int x;
	int y;
	int width;
	int height;
	Rectangle collisionBox;

	boolean isAlive;

	public GameObject() {
		isAlive = true;
		collisionBox = new Rectangle(x, y ,width, height);

	}

	public void update() {
		collisionBox.setBounds(x, y, width, height);
	}

	public void draw(Graphics g) {

		g.fillRect(x, y, 100, 100);
	}

}
