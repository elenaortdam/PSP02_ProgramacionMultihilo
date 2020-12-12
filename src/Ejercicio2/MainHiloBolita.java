package Ejercicio2;

import javax.swing.*;
import java.awt.*;

public class MainHiloBolita {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws InterruptedException {
		HiloBolita bolita1;
		HiloBolita bolita2;
		HiloBolita bolita3;
		JFrame ventana = new JFrame();
		ventana.setSize(450, 300);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		ventana.setResizable(false);

		ThreadGroup threadGroup = new ThreadGroup("Bolitas");

		Thread thread = new Thread(threadGroup, bolita1 = new HiloBolita(0, 50, 1,
																		 ventana.getGraphics(),
																		 Color.RED, 20),
								   "Bola 1");

		ventana.add(bolita1);
		final RepaintManager repaintBola1 = RepaintManager.currentManager(bolita1);
		repaintBola1.addInvalidComponent(bolita1);

		Thread.sleep(100);

		Thread thread2 = new Thread(threadGroup,
									bolita2 = new HiloBolita(0, 100, 1,
															 ventana.getGraphics(),
															 Color.BLUE, 20),
									"Bola 2");

		ventana.add(bolita2);

		Thread.sleep(100);

		Thread thread3 = new Thread(threadGroup,
									bolita3 = new HiloBolita(0, 150, 4,
															 ventana.getGraphics(),
															 Color.GREEN, 20),
									"Bola 3");

		ventana.add(bolita3);

		thread.start();
		Thread.sleep(100);

		thread2.start();
		Thread.sleep(100);

		thread3.start();

	}

}
