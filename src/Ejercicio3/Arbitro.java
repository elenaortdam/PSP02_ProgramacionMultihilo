package Ejercicio3;

public class Arbitro {

	private final int totalJugadores;
	private final int numeroAdivinar;
	private int turno;
	private boolean finJuego;

	public Arbitro(int totalJugadores) {
		this.totalJugadores = totalJugadores;
		this.turno = 1 + (int) (totalJugadores * Math.random());
		this.numeroAdivinar = 1 + (int) (10 * Math.random());
		System.out.println("El número para adivinar es: " + this.numeroAdivinar);
		finJuego = false;
	}

	public int getTurno() {
		return turno;
	}

	public boolean isFinJuego() {
		return finJuego;
	}

	public synchronized void nuevaJugada(int jugador, int numeroJugador) {
		if (jugador == getTurno()) {
			System.out.println("Jugador" + jugador + " dice: " + numeroJugador);
			if (numeroJugador == numeroAdivinar) {
				System.out.println("El jugador" + jugador + " ha acertado");
				this.finJuego = true;
			} else if (turno == totalJugadores) {
				turno = 1;
			} else {
				turno++;
			}
		}
	}

}
