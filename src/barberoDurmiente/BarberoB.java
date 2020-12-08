package barberoDurmiente;

public class BarberoB extends Thread {

	BarberoDurmiente barbero;
	int num;

	public BarberoB(BarberoDurmiente barbero) {
		this.barbero = barbero;
	}

	public void run() {
		while (true) {
			try {
				barbero.esperarCliente();
				Thread.sleep(5000);
				barbero.acabarCorte();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
