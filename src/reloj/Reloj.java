package reloj;

import java.applet.Applet;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Reloj extends Applet implements Runnable {

	private Thread hilo = null;
	private Font fuente;
	private String horaActual;

	public void init() {
		fuente = new Font("Verdana", Font.BOLD, 26);
		setBackground(Color.YELLOW);
		setFont(fuente);
	}

	public void start() {
		if (hilo == null) {
			hilo = new Thread(this);
			hilo.start();
		}
	}

	@Override public void run() {
		Thread hiloActual = Thread.currentThread();
		while (hilo == hiloActual) {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			horaActual = sdf.format(cal.getTime());
			repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
		}
	}

	public void paint(Graphics g) {
		g.clearRect(1, 1, getSize().width, getSize().height);
		g.drawString(horaActual, 20, 50);
	}

	public void stop() {
		hilo = null;
	}
}
