import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {

	int speed;

	public Rocketship(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		speed = 5;
	}

	public void update(char code) {
		if (code == 'a') {
			x -= speed;
		} else if (code == 'b') {
			y -= speed;
		} else if (code == 'c') {
			x += speed;
		} else if (code == 'd') {
			y += speed;
		}

	}

	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}

}
