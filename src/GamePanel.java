import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		rocket = new Rocketship(250, 700, 50, 50);
		manager.addObject(rocket);
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

	}

	public void updateGameState() {
		manager.update();

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
		} else if (e.getKeyCode() == 37) // left
		{
			rocket.update('a');
		} else if (e.getKeyCode() == 38) // up
		{
			rocket.update('b');
		} else if (e.getKeyCode() == 39) // right
		{
			rocket.update('c');
		} else if (e.getKeyCode() == 40) // down
		{
			rocket.update('d');
		}
		if (currentState > END_STATE) {
			currentState = MENU_STATE;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
