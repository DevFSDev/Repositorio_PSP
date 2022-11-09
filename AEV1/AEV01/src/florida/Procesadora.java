package florida;


/**
 * Clase Procesadora
 * 
 * @author lopez
 *
 */


public class Procesadora {


	/**
	 * Array utilizado para el tiempo de creacion de cada croqueta
	 */
	public static Integer tiempoEspera[];
	/**
	 * Array utilizado para cada nombre de los cuatro tipos de croquetas
	 */
	public static String croquetas_nombres[];
	/**
	 * Array utilizado para la cantidad de croquetas que introduce el usuario
	 */
	public static Integer croquetas_cantidades[];
	/**
	 * Variable utilizada para la cantidad de croquetas que hay creadas
	 */
	public static int contador = 0;
	/**
	 * Thread que ejecuta todos los hilos mediante un bucle for
	 */
	public Thread hilo;
	/**
	 * Variable utilizada para saber el fin del tiempo de ejecucion
	 */
	public static long fin = 0;
	/**
	 * Variable utilizada para saber el inicio del tiempo de ejecucion
	 */
	public static long inicio = 0;

	/**
	 * 
	 * @param args Recibe los argumentos de la clase Lanzadora y los pasa al metodo lanzarCroquetas de esta misma clase
	 */
	public static void main(String[] args) {
		int Jamon = Integer.parseInt(args[0]);
		int Pollo = Integer.parseInt(args[1]);
		int Bacalao = Integer.parseInt(args[2]);
		int Queso = Integer.parseInt(args[3]);
		int probabilidadJamon = Integer.parseInt(args[4]);
		int probabilidadPollo = Integer.parseInt(args[5]);
		int probabilidadBacalao = Integer.parseInt(args[6]);
		int probabilidadQueso = Integer.parseInt(args[7]);
		
		try {
			lanzarCroquetas(Jamon, Pollo, Bacalao, Queso, probabilidadJamon, probabilidadPollo, probabilidadBacalao, probabilidadQueso);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	/**
	 * El metodo lanzar croqueta recoge de lanzadora todos los argumentos e inicia
	 * la ejecucion de hilos por cada una de ellas
	 * 
	 * @param croquetasJamon   Hace referencia a la cantidad que ha introducido el
	 *                         usuario de este tipo de croqueta
	 * @param croquetasPollo
	 * @param CroquetasBacalao
	 * @param CroquetasQueso
	 * @param PrioridadJamon   Hace referencia a la prioridad que ha introducido el
	 *                         usuario de este tipo de croqueta
	 * @param PrioridadPollo
	 * @param PrioridadBacalao
	 * @param PrioridadQueso
	 * @throws InterruptedException El error hace referencia a cuando el subproceso
	 *                              esta esperando u ocupado
	 */
	public static void lanzarCroquetas(Integer croquetasJamon, Integer croquetasPollo, Integer CroquetasBacalao,
			Integer CroquetasQueso, Integer PrioridadJamon, Integer PrioridadPollo, Integer PrioridadBacalao,
			Integer PrioridadQueso) throws InterruptedException {
		/**
		 * Desde aqui empezamos a contar lo que tarda la aplicacion en terminar
		 */
		inicio = System.currentTimeMillis();
		Thread hilo1;
		/**
		 * Cada indice de los 4 arrays estan relacionados entre si por su posicion
		 */
		croquetas_cantidades = new Integer[] { croquetasJamon, croquetasPollo, CroquetasBacalao, CroquetasQueso };
		croquetas_nombres = new String[] { "Jamon", "Pollo", "Bacalao", "Queso" };
		tiempoEspera = new Integer[] { 5000, 6000, 7000, 8000 };
		int[] prioridad = { PrioridadJamon, PrioridadPollo, PrioridadBacalao, PrioridadQueso };
		int totalFabricar = croquetasJamon + croquetasPollo + CroquetasBacalao + CroquetasQueso;
		
		Pedido pedidoUsuario = new Pedido(totalFabricar);
		/**
		 * Bucle for anidado para que itere por cada tipo de croqueta(4) las cantidades
		 * que introduce el usuario(m), su variable contador interno cuenta las
		 * croquetas que se fabrican
		 */
		for (int i = 0; i < croquetas_nombres.length; i++) {
			for (int j = 0; j < croquetas_cantidades[i]; j++) {
				contador++;
				Croqueta croqueta1 = new Croqueta(tiempoEspera[i], croquetas_nombres[i], contador, pedidoUsuario);
				Thread.sleep(5);
				hilo1 = new Thread(croqueta1);
				hilo1.setPriority(prioridad[i]);
				hilo1.start();

			}
		}

	}
		
}
