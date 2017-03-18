import javax.swing.JFrame;

public class LeagueInvaders {

	final int WIDTH = 500;
	final int HEIGHT = 800;

	GamePanel gamePan;
	JFrame frame;

	public LeagueInvaders() {
		frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		gamePan = new GamePanel();
		setup();
	}

	public void setup() {
		frame.add(gamePan);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(gamePan);
		gamePan.startGame();
	}

	public static void main(String[] args) {
		LeagueInvaders leagueInv = new LeagueInvaders();

	}

}
