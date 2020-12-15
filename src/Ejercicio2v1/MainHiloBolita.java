package Ejercicio2v1;

import javax.swing.*;
import java.awt.*;

public class MainHiloBolita {

	public static final int WIDTH = 450;

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws InterruptedException {

		HiloBolita bolita1;
		HiloBolita bolita2;
		HiloBolita bolita3;
		JFrame ventana = new JFrame();
		ventana.setSize(WIDTH, 300);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		ventana.setResizable(false);

		Thread thread = new Thread(bolita1 = new HiloBolita(0, 50, 1,
															ventana.getGraphics(),
															Color.RED, WIDTH),
								   "Bola 1");

		ventana.add(bolita1);
		final RepaintManager repaintBola1 = RepaintManager.currentManager(bolita1);
		repaintBola1.addInvalidComponent(bolita1);
		repaintBola1.addDirtyRegion(bolita1, 0, 50, WIDTH, 20);
		Thread.sleep(100);

		Thread thread2 = new Thread(bolita2 = new HiloBolita(0, 100, 2,
															 ventana.getGraphics(),
															 Color.BLUE, WIDTH),
									"Bola 2");

		ventana.add(bolita2);

		Thread thread3 = new Thread(bolita3 = new HiloBolita(0, 150, 3,
															 ventana.getGraphics(),
															 Color.GREEN, WIDTH),
									"Bola 3");

		ventana.add(bolita3);

		thread.start();

		thread2.start();

		thread3.start();
	}
}
