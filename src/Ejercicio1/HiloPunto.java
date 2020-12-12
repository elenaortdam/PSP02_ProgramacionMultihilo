package Ejercicio1;

import javax.swing.*;
import java.awt.*;

public class HiloPunto extends JPanel implements Runnable {

	private final int alto;
	private final int ancho;
	private final Graphics graphics;
	private final Color color;

	public HiloPunto(double alto, double ancho, Graphics g, Color color) {
		this.alto = (int) alto;
		this.ancho = (int) ancho;
		this.graphics = g;
		this.color = color;
	}

	private int recalculatePoint(int maximo) {

		return (int) (Math.random() * maximo);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(color);
		g.fillOval(alto, ancho, 10, 10);
		g.drawOval(alto, ancho, 10, 10);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x = recalculatePoint(this.alto);
		int y = recalculatePoint(this.ancho);
		g.setColor(color);
		g.fillOval(x, y, 10, 10);
		g.drawOval(x, y, 10, 10);
	}

	@Override
	public void run() {
		while (true) {
			HiloPunto test = new HiloPunto(alto, ancho, graphics, color);
			test.paintComponent(graphics);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
