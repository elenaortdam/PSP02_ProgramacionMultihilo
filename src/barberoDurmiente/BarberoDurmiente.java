package barberoDurmiente;

public class BarberoDurmiente extends Thread {

	private final int nSillasEspera;
	private int nSillasOcupadas;
	private boolean sillaBarberoOcupada = false;
	private boolean finCorte = false;
	private boolean barberoDormido = false;

	public BarberoDurmiente(int numSillas) {
		this.nSillasEspera = numSillas;
	}

	public synchronized boolean entrar(int clienteId) throws InterruptedException {
		if (nSillasOcupadas == nSillasEspera) {
			//Si no hay sillas libres me voy
			System.out.println("****** El cliente " + clienteId + " intenta entrar pero no hay sitio ******");
			return false;
		}
		nSillasOcupadas++;
		System.out.println("****** El cliente " + clienteId + " se sienta en una silla en la sala de espera ******");

		while (sillaBarberoOcupada) {
			wait();
		}

		nSillasOcupadas--;
		sillaBarberoOcupada = true;
		finCorte = false;
		if (barberoDormido) {
			System.out.println("****** El cliente " + clienteId + " despierta al barbero ******");
			notifyAll();
		}

		System.out.println("****** El cliente " + clienteId + " está en la silla del barbero ******");
		while (!finCorte) {
			wait();
		}
		sillaBarberoOcupada = false;
		notifyAll();
		System.out.println("****** El cliente " + clienteId + " se va con el pelo cortado ******");
		return true;

	}

	public synchronized void esperarCliente() throws InterruptedException {
		barberoDormido = true;
		while (!sillaBarberoOcupada) {
			System.out.println("            Barbero se duerme esperando clientes -.- ZZzzzz");
			wait();
		}
		barberoDormido = false;
		System.out.println("              Barbendo cortando el pelo XXXXXXX");
	}

	public synchronized void acabarCorte() {
		finCorte = true;
		System.out.println("             Barbero termina de cortar el pelo y llama al siguiente");
		notifyAll();
	}
}
