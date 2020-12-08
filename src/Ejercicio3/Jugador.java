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
			if (arbitro.getTurno() == numeroJugador) {
				int jugada = 1 + (int) (10 * Math.random());
				arbitro.nuevaJugada(numeroJugador, jugada);
			}
		}
	}
}


