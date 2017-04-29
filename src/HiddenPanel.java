import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class HiddenPanel extends JPanel implements ActionListener, KeyListener{
    Timer timer;
    
    public HiddenPanel()
    {
    	timer = new Timer(1000/60, this);
    }
    
    public void startGame()
    {
    	timer.start();
    }
    
    public void paintComponent(Graphics g) 
    {
    	g.fillRect(10, 10, 100, 100);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("1");
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("2");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("3");
		
	}
	
	
}
