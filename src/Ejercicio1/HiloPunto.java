package Ejercicio1;

import javax.swing.*;
import java.awt.*;

public class HiloPunto extends JPanel implements Runnable {

	private int x;
	private int y;
	private Graphics graphics;
	private Color color;

	public HiloPunto(double alto, double ancho, Graphics g, Color color) {
		this.x = (int) alto;
		this.y = (int) ancho;
		this.graphics = g;
		this.color = color;
	}

	private int recalculatePoint(int maximo) {

		Integer random = 1;
		random = (int) (10 * Math.random());
		if (random == 0) {

			random = 1;
		}

		return maximo / random;
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(color);
		g.fillOval(x, y, 10, 10);
		g.drawOval(x, y, 10, 10);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x = recalculatePoint(this.x);
		int y = recalculatePoint(this.y);

		g.setColor(color);
		g.fillOval(x, y, 10, 10);
		g.drawOval(x, y, 10, 10);
	}

	@Override
	public void run() {
		while (true) {
			HiloPunto test = new HiloPunto(x, y, graphics, color);
			test.paintComponent(graphics);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
