import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;

	Font titleFont;
	int currentState = MENU_STATE;
	Timer timer;
	Rocketship rocket;
	ObjectManager manager = new ObjectManager();
	
	public static BufferedImage alienImg;
	public static BufferedImage rocketImg;
	public static BufferedImage bulletImg;

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		rocket = new Rocketship(250, 700, 50, 50);
		manager.addObject(rocket);
		
		try {
			alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
			rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
			bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void startGame() {
		timer.start();
	}

	public void paintComponent(Graphics g) {

		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}

	}

	public void updateMenuState() {
		manager.setScore(0);
	}

	public void updateGameState() {
		manager.update();
		manager.manageEnemies();
		manager.checkCollision();
		if(rocket.isAlive == false)
		{
			currentState = END_STATE;
			manager.reset();
			rocket = new Rocketship(250, 700, 50, 50);
			manager.addObject(rocket);
			
		}
		manager.getScore();
	}

	public void updateEndState() {

	}

	public void drawMenuState(Graphics a) {
		a.setColor(Color.BLUE);
		a.fillRect(0, 0, 500, 800);
		a.setColor(Color.red);
		a.setFont(titleFont);
		a.drawString("League Invaders", 80, 400);
	}

	public void drawGameState(Graphics b) {
		b.setColor(Color.BLACK);
		b.fillRect(0, 0, 500, 800);
		manager.draw(b);
	}

	public void drawEndState(Graphics c) {
		c.setColor(Color.RED);
		c.fillRect(0, 0, 500, 800);
		c.setColor(Color.black);
		c.setFont(titleFont);
		c.drawString("GAME OVER", 100, 400);
		c.drawString("Score: " + manager.getScore(), 100, 500);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 10) {
			currentState += 1;
		} if (e.getKeyCode() == 37) // left
		{
			rocket.update('a');
		} if (e.getKeyCode() == 38) // up
		{
			rocket.update('b');
		} if (e.getKeyCode() == 39) // right
		{
			rocket.update('c');
		} if (e.getKeyCode() == 40) // down
		{
			rocket.update('d');
		}
		if(e.getKeyCode() == 32)
		{
			manager.addObject(new Projectile(rocket.x+20, rocket.y, 10, 10));
		}
		if (currentState > END_STATE) {
			currentState = MENU_STATE;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			rocket.left = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			rocket.up = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			rocket.right = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			rocket.down = false;
		}
		

	}

}
