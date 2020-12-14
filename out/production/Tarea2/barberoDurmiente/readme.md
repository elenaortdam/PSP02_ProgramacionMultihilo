## El barbero durmiente
El barbero abre su establecimiento a las 9 de la mañana. Si no hay clientes, se echa una siesta. Existe 
una sala de espera con 4 sillas y pueden venir 6 clientes. Si todas las sillas están ocupadas el cliente 
no puede entrar en la barbería. Si hay sillas libres entra y se sienta en la sala de espera. Esperará su 
turno para cortarse el pelo. 

- Si el barbero está durmiendo el cliente que ya está en la barbería lo despierta. 
- Si la silla del barbero está libre el cliente puede sentarse y el barbero le cortará el pelo. 
- Cuando termine, se notificará a los demás clientes que la silla del barbero está disponible y podrá pasar otro cliente a cortarse el pelo. 
---
*El programa de prueba tendrá la siguiente forma:*

        int numeroSillas = 4;
		int numeroClientes = 6;

		BarberoDurmiente barbero = new BarberoDurmiente(numeroSillas);
		new BarberoB(barbero).start();
		for (int i = 0; i < numeroClientes; i++) {
			new ClienteB(barbero, i).start();
		}
		
La clase Barbero durmiente usará las siguientes variables

    private final int nSillasEspera;
	private int nSillasOcupadas;
	private boolean sillaBarberoOcupada = false;
	private boolean finCorte = false;
	private boolean barberoDormido = false;
	
y los métodos sincronizados entrar(idCliente), esperarCliente() y acabarCorte(). 