import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {

	int speed;
	boolean up;
	boolean down;
	boolean left;
	boolean right;

	public Rocketship(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		speed = 5;
	}

	public void update(char code) {
		super.update();
		if (code == 'a') {
			left = true;
		}if (code == 'b') {
			up = true;
		} if (code == 'c') {
			right = true;
		}if (code == 'd') {
			down = true;
		}
	}	
		
	public void update()
	{
		if (left) {
			x -= speed;
		}if (down) {
			y += speed;
		} if (right) {
			x += speed;
		}if (up) {
			y -=speed;
		}
		if(x > LeagueInvaders.WIDTH)
		{
			x = 0;
		}
		else if(x < 0)
		{
			x = LeagueInvaders.WIDTH;
		}
		if(y > LeagueInvaders.HEIGHT)
		{
			y = LeagueInvaders.HEIGHT;
		}
		else if(y < 0)
		{
			y=0;
			
		}

	}
	

	public void draw(Graphics g) {
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);

	}

}
