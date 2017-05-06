import java.awt.Color;
import java.awt.Graphics;

public class Sniper extends GameObject{
	
	int x;
	int y;
	int width;
	int height;
	int speed;
	
	boolean up;
	boolean down;
	boolean left;
	boolean right;
	
	public Sniper(int myX, int myY, int myWidth, int myHeight)
	{
		x = myX;
		y = myY;
		width = myWidth;
		height = myHeight;
		speed = 5;
	}
	
	@Override
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
		if(x > HiddenGame.WIDTH)
		{
			x = 0;
		}
		else if(x < 0)
		{
			x = HiddenGame.WIDTH;
		}
		if(y > HiddenGame.HEIGHT)
		{
			y = HiddenGame.HEIGHT;
		}
		else if(y < 0)
		{
			y=0;
			
		}

	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.BLUE);
		//g.fillRect(x, y, width, height);
        g.drawRect(x, y, width, height);
	}

}
