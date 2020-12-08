package Juego;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {

	int x = 0;
	int y = 0;

	private void move() {
		x = x + 1;
		y = y + 1;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
							 RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.fillOval(x, y, 30, 30);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame();
		Game game = new Game();
		frame.add(game);
		frame.setSize(300,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		while (true){
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
	}
}
