package Reloj;

public class EjemploHilo {

	public static void main(String[] args) {
		ThreadGroup grupoRelojes = new ThreadGroup("relojes");
		MiHiloReloj miHiloReloj = new MiHiloReloj("Madrid", 5, grupoRelojes, "Europe/Madrid");
		miHiloReloj.getHilo().start();
	}
}
