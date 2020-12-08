package Reloj;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class MiHiloReloj implements Runnable {

	private Thread hilo;
	private String zonaHoraria;

	private TimeZone timeZone;
	private SimpleDateFormat formato;
	private Calendar calendario;

	private String hora;

	public MiHiloReloj(String nombre, int prioridad, ThreadGroup grupo, String zonahoraria) {
		this.hilo = new Thread(grupo, this, nombre);
		this.zonaHoraria = zonahoraria;
		this.timeZone = TimeZone.getTimeZone(zonahoraria);
		this.formato = new SimpleDateFormat("HH:mm:ss");
		formato.setTimeZone(this.timeZone);
	}

	@Override public void run() {
		while (true) {
			actualizarHora();
			mostrarHora();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void mostrarHora() {
		System.out.println("Zona horaria de " + this.zonaHoraria + " -> " + this.hora);
	}

	public void actualizarHora() {
		calendario = Calendar.getInstance(timeZone);
		this.hora = formato.format(calendario.getTime());
	}

	public Thread getHilo() {
		return hilo;
	}

	public void setHilo(Thread hilo) {
		this.hilo = hilo;
	}

	public String getZonaHoraria() {
		return zonaHoraria;
	}

	public void setZonaHoraria(String zonaHoraria) {
		this.zonaHoraria = zonaHoraria;
	}

	public TimeZone getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(TimeZone timeZone) {
		this.timeZone = timeZone;
	}

	public SimpleDateFormat getFormato() {
		return formato;
	}

	public void setFormato(SimpleDateFormat formato) {
		this.formato = formato;
	}

	public Calendar getCalendario() {
		return calendario;
	}

	public void setCalendario(Calendar calendario) {
		this.calendario = calendario;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
}
