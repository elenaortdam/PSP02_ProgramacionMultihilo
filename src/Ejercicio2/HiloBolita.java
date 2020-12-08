package Ejercicio2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class HiloBolita extends JPanel implements Runnable, ActionListener {

	private Thread thread;
	private int x;
	private int y;
	private int desplazamiento;
	private Graphics g;
	private Color color;
	private double ancho;
	private Button b1;
	private boolean parar;
	List<Thread> threads = new ArrayList<>();

	public HiloBolita(int x, int y, int desplazamiento, Graphics g,
					  Color color, double ancho) {
//		this.thread = new Thread(this);
//		this.thread.start();
		this.x = x;
		this.y = y;
		this.desplazamiento = desplazamiento;
		this.g = g;
		this.color = color;
		this.ancho = ancho;

	}

	@Override

	public void run() {

		parar = false;
		Thread hiloActual = Thread.currentThread();
		while (hiloActual.getThreadGroup().getName().equals("Bolitas") && !parar) {

			repaint();
			if (x + ancho > getWidth()) {
				do {
					x = x - desplazamiento;
					try {
						Thread.currentThread().sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					repaint();
				} while (x > 0);
			} else {
				x = x + desplazamiento;
			}
			try {
				Thread.currentThread().sleep(10);
			} catch (InterruptedException ex) {

			}
			Thread.yield();
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