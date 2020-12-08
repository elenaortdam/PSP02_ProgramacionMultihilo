package Ejercicio2_1;

import javax.swing.*;
import java.awt.*;

public class MainHiloBolita {
	public static void main(String[] args) {

		JFrame ventana = new JFrame();
		ventana.setSize(450, 300);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		Button boton = new Button();
//		boton.setLabel("Activar");
//		boton.setBounds(175,100,50,25);
//		ventana.add(boton);
		HiloBolita h = new HiloBolita(0, 50, 5,
									  ventana.getGraphics(), Color.BLUE, 20);
		ventana.add(h);
		Thread thread1 = new Thread(h, "Bola 1");
		thread1.start();

		HiloBolita h2 = new HiloBolita(0, 10, 1,
									   ventana.getGraphics(), Color.RED, 20);
		ventana.add(h2);
		Thread thread2 = new Thread(h2);
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
