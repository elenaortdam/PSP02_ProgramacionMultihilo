package Ejercicio2;

import javax.swing.*;
import java.awt.*;

public class HiloBolitaDAM implements Runnable {

	int x;
	int y;
	int desplazamiento;
	Graphics g;
	Color color;
	double ancho;

	public HiloBolitaDAM(int x, int y, int desplazamiento, Graphics g,
						 Color color, double ancho) {

		this.x = x;
		this.y = y;
		this.desplazamiento = desplazamiento;
		this.g = g;
		this.color = color;
		this.ancho = ancho;

	}

	@Override

	public void run() {

		miJPanel Panel = new miJPanel();
		JFrame ventana = new JFrame();
		HiloBolita hiloBolita = new HiloBolita(1,1,1,ventana.getGraphics(),Color.RED, 1);
		ventana.add(hiloBolita);

		for (int i = 0; i <= 3000; i++) {

			Panel.paint(g, color, x, y);

			Panel.repaint();
			if (x + ancho > Panel.getWidth()) {
				do {
					x = x - desplazamiento;
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Panel.repaint();
				} while (x > 0);
			} else {
				x = x + desplazamiento;
			}

			try {

				Thread.sleep(30);

			} catch (InterruptedException ex) {

			}

		}

	}

	class MyFrame extends JFrame {
		public MyFrame() {
			setBounds(500, 500, 450, 300);
			setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);
			setResizable(false);
		}
	}

	class miJPanel extends JPanel {

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

	}

}
