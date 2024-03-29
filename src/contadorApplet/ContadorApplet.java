package contadorApplet;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContadorApplet extends Applet implements Runnable, ActionListener {

	private Thread h;
	long CONTADOR = 0;
	private boolean parar;
	private Font fuente;
	private Button b1, b2;

	public void start() {
	}

	public void init() {
		setBackground(Color.YELLOW);
		add(b1 = new Button("Iniciar contador"));
		b1.addActionListener(this);
		add(b2 = new Button("Parar contador"));
		b2.addActionListener(this);
		fuente = new Font("Verdana", Font.BOLD, 26);
	}

	@Override
	public void run() {
		parar = false;
		Thread hiloActual = Thread.currentThread();
		while (h == hiloActual && !parar) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
			CONTADOR++;
		}
	}

	@Override public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			b1.setLabel("Continuar");
			if (h != null && h.isAlive()) {

			} else {
				h = new Thread(this);
				h.start();
			}
		} else if (e.getSource() == b2) {
			parar = true;
		}
	}

	public void stop() {
		h = null;
	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, 400, 400);
		g.setFont(fuente);
		g.drawString(String.valueOf(CONTADOR), 80, 100);
	}

	public Long getContador() {
		return CONTADOR;
	}
}
