package Ejercicio2;

import javax.swing.*;
import java.awt.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class MainHiloBolita {

	public static void main(String[] args) throws InterruptedException {
		HiloBolita bolita1;
		HiloBolita bolita2;
		JFrame ventana = new JFrame();
		ventana.setSize(450, 300);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ThreadGroup threadGroup = new ThreadGroup("Bolitas");
		Thread thread = new Thread(threadGroup, bolita1 = new HiloBolita(0, 50, 5,
																		 ventana.getGraphics(),
																		 Color.RED, 20),
								   "Bola 1");
		ventana.add(bolita1);

		Thread thread2 = new Thread(threadGroup,
									bolita2 = new HiloBolita(0, 100, 2,
															 ventana.getGraphics(),
															 Color.BLUE, 20),
									"Bola 2");
		ventana.add(bolita2);
		thread.start();
		thread2.start();

		/*
		HiloBolita h3 = new HiloBolita(0, 50, 2,
									  ventana.getGraphics(), Color.YELLOW, 20);
		ventana.add(h3);

		Thread thread3 = new Thread(h3);
		thread3.start();

		 */

	}
}
