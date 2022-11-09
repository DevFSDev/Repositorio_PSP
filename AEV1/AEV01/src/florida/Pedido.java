package florida;

/**
 * Clase Pedido
 * 
 * @author lopez
 *
 */
public class Pedido {

	int totalAFabricar;

	/**
	 * Metodo constructor de la clase Pedido
	 * 
	 * @param Recibe como parametro el total de croqetas que se van a fabricar
	 */
	Pedido(int totalAFabricar) {
		this.totalAFabricar = totalAFabricar;
	}

	/**
	 * Setter del total de croquetas a fabricar
	 * 
	 * @param Recibe como parametro el total de croqetas que se van a fabricar
	 */
	public void setTotalAFabricar(int totalAFabricar) {
		this.totalAFabricar = totalAFabricar;
	}

	/**
	 * Getter del total de croquetas a fabricar
	 * 
	 * @return Retorna el total de croqetas que se van a fabricar
	 */
	public int getTotalAFabricar() {
		return totalAFabricar;
	}
}
