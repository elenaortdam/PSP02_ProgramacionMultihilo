package Ejercicio2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HiloBolitaBackup extends JPanel implements Runnable, ActionListener {

	private final Thread thread;
	private int x;
	private int y;
	private int desplazamiento;
	private Graphics g;
	private Color color;
	private double ancho;
	JFrame jFrame;
	private Button b1;

	public HiloBolitaBackup(int x, int y, int desplazamiento, Graphics g,
							Color color, double ancho) {
		this.thread = Thread.currentThread();
		this.x = x;
		this.y = y;
		this.desplazamiento = desplazamiento;
		this.g = g;
		this.color = color;
		this.ancho = ancho;

	}

	@Override

	public void run() {

		for (int i = 0; i <= 3000; i++) {
			repaint();
			if (x + ancho > getWidth()) {
				do {
					x = x - desplazamiento;
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					repaint();
				} while (x > 0);
			} else {
				x = x + desplazamiento;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException ex) {

			}

		}
	}

	public void paint(Graphics g, Color color, int x, int y) {
		super.paint(g);
		g.setColor(color);
		g.fillOval(x, y, 15, 15);
		g.drawOval(x, y, 15, 15);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(color);
		g.fillOval(x, y, 10, 10);
		g.drawOval(x, y, 10, 10);
	}

	@Override public void actionPerformed(ActionEvent e) {

	}
}