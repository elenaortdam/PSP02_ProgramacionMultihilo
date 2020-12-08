package Ejercicio2_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HiloBolita extends JPanel implements Runnable, ActionListener {

	private Thread thread;
	private boolean parar;
	private Button b1;
	private int x;
	private int y;
	private int desplazamiento;
	private Graphics g;
	private Color color;
	private double ancho;

	public HiloBolita(int x, int y, int desplazamiento, Graphics g, Color color, double ancho) {
		this.thread = Thread.currentThread();
		this.x = x;
		this.y = y;
		this.desplazamiento = desplazamiento;
		this.g = g;
		this.color = color;
		this.ancho = ancho;

	}

	public void start() {

	}

	public void init() {
		add(b1 = new Button("Parar bola 1"));
		b1.addActionListener(this);

	}

	@Override

	public void run() {

		parar = false;
		Thread hiloActual = Thread.currentThread();
		while (thread == hiloActual && !parar) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException ex) {

			}
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

		}

	}

	public void paint(Graphics g, Color color, int x, int y) {
		super.paint(g);
		g.clearRect(0, 0, 400, 400);
		g.setColor(color);
		g.fillOval(x, y, 15, 15);
		g.drawOval(x, y, 15, 15);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.clearRect(0, 0, 400, 400);
		g.setColor(color);
		g.fillOval(x, y, 10, 10);
		g.drawOval(x, y, 10, 10);
	}

	@Override public void actionPerformed(ActionEvent e) {

	}
}