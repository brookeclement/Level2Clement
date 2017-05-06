import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class HiddenPanel extends JPanel implements ActionListener, KeyListener{
   
	Timer timer;
    
    final int MENU_STATE = 0;
    final int GAME_STATE = 1;
    final int END_STATE = 2;
    
    int currentState;
    Sniper sniper;
    
    public HiddenPanel()
    {
    	timer = new Timer(1000/60, this);
    	sniper = new Sniper(400, 650, 100,100);
    }
    
    public void startGame()
    {
    	timer.start();
    }
    
    public void paintComponent(Graphics g) 
    {
		if(currentState == MENU_STATE)
		{
			drawMenuState(g);
		}
		else if(currentState == GAME_STATE)
		{
			drawGameState(g);
		}
		else if(currentState == END_STATE)
		{
			drawEndState(g);
		}
	}
    
    public void updateMenuState()
    {
    	
    }
    
    public void updateGameState()
    {
    	sniper.update();
    }
    
    public void updateEndState()
    {
    	
    }
    
    public void drawMenuState(Graphics g)
    {
    	g.setColor(Color.BLUE);
    	g.fillRect(0, 0, HiddenGame.WIDTH, HiddenGame.HEIGHT);
    }
    
    public void drawGameState(Graphics g)
    {
    	g.setColor(Color.RED);
    	g.fillRect(0, 0, HiddenGame.WIDTH, HiddenGame.HEIGHT); 
    	sniper.draw(g);
    }
    
    public void drawEndState(Graphics g)
    {
    	g.setColor(Color.BLACK);
    	g.fillRect(0, 0, HiddenGame.WIDTH, HiddenGame.HEIGHT);  
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		if(currentState == MENU_STATE)
		{
			updateMenuState();
		}
		else if(currentState == GAME_STATE)
		{
			updateGameState();
		}
		else if(currentState == END_STATE)
		{
			updateEndState();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("1");
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 10) {
			currentState += 1;
		}
		if (currentState > END_STATE) {
			currentState = MENU_STATE;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			sniper.left = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			sniper.up = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			sniper.right = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			sniper.down = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			sniper.left = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			sniper.up = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			sniper.right = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			sniper.down = false;
		}
		
	}
	
	
}
