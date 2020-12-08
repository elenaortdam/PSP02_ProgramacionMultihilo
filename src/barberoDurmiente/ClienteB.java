package barberoDurmiente;

public class ClienteB extends Thread {

	private final BarberoDurmiente barbero;
	private final int num;

	public ClienteB(BarberoDurmiente barbero, int num) {
		this.barbero = barbero;
		this.num = num;
	}

	public void run() {
		boolean t = false;
		while (true) {
			try {
				Thread.sleep(2000);
				t = barbero.entrar(num);
				if (t) {
					Thread.sleep(200000);
				} else {
					Thread.sleep(4000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
