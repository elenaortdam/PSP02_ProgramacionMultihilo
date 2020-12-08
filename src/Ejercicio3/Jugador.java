package Ejercicio3;

public class Jugador extends Thread {
	Arbitro arbitro;
	int numeroJugador;

	public Jugador(int numeroJugador, Arbitro elArbitro) {
		arbitro = elArbitro;
		this.numeroJugador = numeroJugador;
	}

	public void run() {
		while (!arbitro.isFinJuego()) {

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (arbitro.getTurno() == numeroJugador) {
				int jugada = 1 + (int) (10 * Math.random());
				try {
					arbitro.comprobarJugada(numeroJugador, jugada);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}


