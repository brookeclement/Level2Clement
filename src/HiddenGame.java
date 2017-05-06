import javax.swing.JFrame;

public class HiddenGame {
	
	static final int WIDTH = 800;
	static final int HEIGHT = 800;
	
	JFrame frame;
	HiddenPanel panel;
	
	public HiddenGame()
	{
		frame = new JFrame();
		panel = new HiddenPanel();
		setup();
	}
	
	public void setup()
	{
		frame.add(panel);
		frame.setSize(WIDTH, HEIGHT);
		frame.addKeyListener(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        panel.startGame();
	}
	
	public static void main(String[] args) {
		HiddenGame game = new HiddenGame();
		 
	}

}
