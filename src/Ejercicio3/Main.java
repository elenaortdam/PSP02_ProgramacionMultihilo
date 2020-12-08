package Ejercicio3;

public class Main {

	public static void main(String[] args) {

		Arbitro arbitro = new Arbitro(2);
		Jugador jugador1 = new Jugador(1, arbitro);
		Jugador jugador2 = new Jugador(2, arbitro);
		jugador1.start();
		jugador2.start();

	}
}
