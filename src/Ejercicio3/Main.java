package Ejercicio3;

public class Main {

	public static void main(String[] args) {

		int numeroJugadores = 5;
		Arbitro arbitro = new Arbitro(numeroJugadores);
		for (int i = 1; i <= numeroJugadores; i++) {
			new Jugador(i, arbitro).start();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
