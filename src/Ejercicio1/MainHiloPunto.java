package Ejercicio1;


import javax.swing.*;
import java.awt.*;

public class MainHiloPunto {

	public static final int ANCHO_VENTANA = 450;
	public static final int ALTO_VENTANA = 300;
	public static final int SLEEP_TIME = 10000; //3 Segundos

	public static void main(String[] args) throws InterruptedException {

		JFrame ventana = new JFrame();
		ventana = new JFrame();
		ventana.setSize(450, 300);
		ventana.setVisible(true);
		ventana.setResizable(false);

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
