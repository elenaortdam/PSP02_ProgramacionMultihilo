package Ejercicio1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainHiloPunto {

	public void mostrarMensajeCerrar(JFrame ventana) {
		ventana.addWindowListener(new WindowAdapter() {
			@Override public void windowClosing(WindowEvent e) {
				System.out.println("Fin del proceso...");
				super.windowClosing(e);
			}
		});

	}

	public static void main(String[] args) throws InterruptedException {

		JFrame ventana = new JFrame();
		ventana = new JFrame();
		ventana.setSize(450, 300);
		ventana.setVisible(true);
		ventana.setResizable(false);
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		MainHiloPunto hiloPunto = new MainHiloPunto();
		hiloPunto.mostrarMensajeCerrar(ventana);

		HiloPunto panel = new HiloPunto(ventana.getSize().getWidth(),
										ventana.getSize().getHeight(),
										ventana.getGraphics(), Color.RED);
		ventana.add(panel);
		Thread thread = new Thread(panel);
		thread.start();

		HiloPunto dos = new HiloPunto(ventana.getSize().getWidth(),
									  ventana.getSize().getHeight(),
									  ventana.getGraphics(), Color.BLUE);
		ventana.add(dos);
		Thread thread1 = new Thread(dos);
		thread1.start();

		HiloPunto tres = new HiloPunto(ventana.getSize().getWidth(),
									   ventana.getSize().getHeight(),
									   ventana.getGraphics(), Color.GREEN);
		ventana.add(tres);
		Thread thread2 = new Thread(tres);
		thread2.start();

	}
}
