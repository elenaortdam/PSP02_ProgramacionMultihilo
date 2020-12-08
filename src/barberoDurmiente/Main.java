package barberoDurmiente;

public class Main {

	public static void main(String[] args) {

		int numeroSillas = 4;
		int numeroClientes = 6;

		BarberoDurmiente barbero = new BarberoDurmiente(numeroSillas);
		new BarberoB(barbero).start();
		for (int i = 0; i < numeroClientes; i++) {
			new ClienteB(barbero, i).start();
		}

	}
}
