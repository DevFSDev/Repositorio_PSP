package florida;

import javax.swing.JOptionPane;

public class Croqueta implements Runnable{
	
	/**
	 * Variable utilizada para saber las croquetas que estan en fabricacion
	 */
	public static int dentro;
	/**
	 * Lo indica en el constructor
	 */
	public String nombre;
	/**
	 * Lo indica en el constructor
	 */
	public int indice;
	/**
	 * Lo indica en el constructor
	 */
	public int limite;
	/**
	 * Lo indica en el constructor
	 */
	public Pedido pedido;
	/**
	 * Variable utilizada para saber las croquetas finalizadas y poder ejecutar correctamente el popup
	 */
	public static int terminadas = 0;
	
	/**
	 * Constructor de la clase Croqueta con los argumentos limite, nombre,
	 * indice y pedido
	 * 
	 * @param limite El parametro limite es el tiempo que tarda en crear la croqueta
	 *               de ese tipo
	 * @param nombre El parametro que indica de que tipo es la croqueta
	 * @param indice El parametro indica el indice para saber en que posicion esta
	 *               la croqueta en cada momento
	 * @param pedido El parametro indica la cantidad de croquetas que ha pedido el usuario
	 */
	Croqueta(Integer limite, String nombre, Integer indice, Pedido pedido) {
		this.limite = limite;
		this.nombre = nombre;
		this.indice = indice;
		this.pedido = pedido;

	}
	
	/**
	 * fabricarCroquetas es encargado de fabricar las croquetas y parar cuando llegan a cien,
	 * cuando llega todas las demas las ponemos en (sleep) tres segundos, cuando
	 * trascurre el tiempo volvemos a comprobar cuantas estan en proceso de
	 * fabricacion (semaforo)
	 * @throws InterruptedException Lanzado cuando un hilo está esperando,durmiendo o ocupado de otra manera,y el hilo se interrumpe.
	 */
	void fabricarCroquetas() throws InterruptedException {


		boolean verificacion = true;
		double avance = 0, porcentaje = 0;
		dentro = dentro - terminadas;
		while (true) {
			synchronized (this) {
			while (verificacion != true) wait(); {
				if (dentro < 100) {
					dentro++;
					System.out.println("La croqueta de " + nombre + " Numero " + indice + " se ha comenzado a fabricar");
					break;
				} else {
					verificacion = false;
					notify();
					}
				}
			}

			synchronized (this) {
			while (verificacion != false) wait(); {
				System.err.println("La lanzadora se ha detenido 3 segundos");
				System.err.println("La croqueta de " + nombre + " Numero " + indice + " esta en pausa");
				try {
					Thread.sleep(3000);
					verificacion = true;
					notify();
				
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}

			}

		}
	
		/**
		 * Bucle encargado de mostrar por consola el avance de cada croqueta, respentado
		 * su tiempo de fabricacion individual
		 */
		while (avance < limite) {

			avance = avance + 500;
			porcentaje = 100 * avance / limite;
			System.out
					.println("La croqueta de " + nombre + " " + "esta al " + String.format("(%.0f", porcentaje) + "%)");
			if (porcentaje == 100.0){
				terminadas++;
				System.out.println("La croqueta de " + nombre + " Numero " + indice + " ha terminado su ejecucion");
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		
		}
		
		
		Procesadora.fin = System.currentTimeMillis();
		
		
		/**
		 * Condicional encargado de que cuando terminen todas muestre el tiempo que se
		 * ha tardado en fabricarlas
		 */
		if (terminadas == pedido.getTotalAFabricar()) {
			double tiempo = (double) ((Procesadora.fin - Procesadora.inicio) / 1000);
			JOptionPane.showMessageDialog(null, "La aplicación ha tardado en terminar: " + tiempo + " segundos",
					"Tiempo ejecucion", JOptionPane.INFORMATION_MESSAGE);
			System.exit(Procesadora.contador);

		}
		
	}

	
	@Override
	public void run() {
		try {
			fabricarCroquetas();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
