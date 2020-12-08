import javax.swing.*;
import java.awt.*;

public class RandomDots extends JFrame implements Runnable {

	Thread t;

	public void init() {
		t = new Thread(this);
		t.start();
	}

	public void run() {
		try {
			while (true) {
				repaint();
				Thread.sleep(1);
			}
		} catch (Exception e) {
		}
	}

	public void update(Graphics g) {
		paint(g);
	}

	public void paint(Graphics g) {
		Dimension d = getSize();
		int x = (int) (Math.random() * d.width);
		int y = (int) (Math.random() * d.height);
		g.setColor(Color.red);
		g.fillOval(x, y, 10, 10);
	}

}


