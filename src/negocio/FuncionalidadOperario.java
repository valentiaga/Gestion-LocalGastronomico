package negocio;

import excepciones.NoExisteID_Exception;
import excepciones.NoExisteMesa_Exception;
import excepciones.PromoIdRepetido_Exception;
import excepciones.UserNameRepetido_Exception;
import modelo.Comanda;
import modelo.Enumerados;
import modelo.Mesa;
import modelo.MesaAtendida;
import modelo.Mozo;
import modelo.Operario;
import modelo.PromocionTemporal;

public class FuncionalidadOperario {

	private Operario operario;

	public FuncionalidadOperario(Operario operario) {
		super();
		this.operario = operario;
	}

	/**
	 * metodo utilizado para modificar el o los campos de Operario que se deseen.
	 * 
	 * @param NyA      nombre y apellido nuevo.
	 * @param userName nuevo nombre de usuario.
	 * @param password nueva contrasenia.
	 * @param activo   nuevo estado del Operario.
	 * @throws UserNameRepetido_Exception Se lanza si el nuevo nombre de usuario ya
	 *                                    existe en el sistema.
	 */
	public void modificaOperario(String NyA, String userName, String password, boolean activo)
			throws UserNameRepetido_Exception {

		// llamamos al operario actual y modificamos a ese
		// se delega a la Clase Operario
		// El estado se modifica?
	}

	public void eliminaOperario() { // consideramos que el operario puede eliminarse por s� mismo al igual que puede
									// eliminarlo el admin.
		// se llama al actual y se lo elimina
	}

	/**
	 * metodo para modificar el/los atributos del mozo que se desee/n.
	 * 
	 * @param NyA       nombre y apellido nuevo.
	 * @param cantHijos nueva cantidad de hijos.
	 * @param mozo      que se desea modificar.
	 */
	public void modificaMozo(Mozo mozo, String NyA, int cantHijos) { // el estado lo modifica el o el sistema??
		// el estado se modifica?
	}

	/**
	 * metodo para modificar el/los atributos que se deseen del producto.
	 * 
	 * @param id           correspondiente al producto. <br>
	 * @param nombre       nuevo nombre del producto. <br>
	 * @param precioCosto  nuevo precio de costo. <br>
	 * @param precioVenta  nuevo precio de venta. <br>
	 * @param stockInicial nuevo stock inicial. <br>
	 * @throws NoExisteID_Exception Se lanza si el ID ingresado no esta relacionado
	 *                              a ningun producto del sistema.
	 */
	public void modificaProducto(int id, String nombre, double precioCosto, double precioVenta, int stockInicial)
			throws NoExisteID_Exception {
	}

	/**
	 * metodo para modificar el/los atributos que se deseen de la mesa.
	 * 
	 * @param nroMesa    ID de mesa. <br>
	 * @param cantSillas cantidad de personas que ocuparan la mesa. <br>
	 * @param libre      estado de la mesa. <br>
	 * @throws NoExisteMesa_Exception Se lanza si el ID no corresponde con ninguna
	 *                                mesa cargada en el sistema.
	 */

	public void modificaMesa(int nroMesa, int cantSillas, boolean libre) throws NoExisteMesa_Exception {
	} // tira excepcion de no existe mesa? O vamos a tener un mapa de mesas
		// si elegimos en la ventana la mesa del array de mesa, no se va a tirar la
		// excepcion nunca

	/**
	 * metodo para agregar un nuevo producto en promo al menu. <br>
	 * Pre: El producto debe ser distinto de null. <br>
	 * Pre: La promo aplica2x1 y
	 * 
	 * @param idProd                        ID del producto al que se le aplica la
	 *                                      promo. <br>
	 * @param dia                           de la semana en el que estara disponible
	 *                                      la promo. <br>
	 * @param aplica2x1                     tipo de descuento. <br>
	 * @param aplicaDtoPorCantidad          tipo de descuento. <br>
	 * @param dtoPorCantidad_CantMinima     tipo de descuento. <br>
	 * @param dtoPorCantidad_PrecioUnitario tipo de descuento. <br>
	 * @param activa                        determina si esta activa o no en el
	 *                                      momento actual. <br>
	 * @throws PromoIdRepetido_Exception Se lanza si se intenta asignar un
	 *                                   identificador de promo existente. <br>
	 */
	public void agregaPromocionProd(int idProd, Enumerados.diasDePromo dia, boolean aplica2x1,
			boolean aplicaDtoPorCantidad, int dtoPorCantidad_CantMinima, double dtoPorCantidad_PrecioUnitario,
			boolean activa) throws PromoIdRepetido_Exception {}

	/**
	 * metodo para modificar el estado de una promo.<br>
	 * 
	 * @param idProm identificador de la promo. <br>
	 * @param activa estado de la promo. <br>
	 */

	public void modificaPromocionProd(int idProm, boolean activa) {
		/* solo activa o desactiva la promo */}

	/**
	 * metodo que elimina la promo. <br>
	 * 
	 * @param idProm identificador de la promo. <br>
	 */
	
	public void eliminaPromocionProd(int idProm) {}

	public void agregaPromocionTemporal(String nombre, Enumerados.formaDePago formaDePago, int porcentajeDescuento,
			Enumerados.diasDePromo diasDePromo, boolean activo, boolean esAcumulable) {}

	public void eliminaPromocionTemporal(String nombre) {}
	
	public void modificaPromocionTemporal(String nombre,boolean activo,int porcentajeDescuento,boolean esAcumulable) {}

	public void setEstadoMozo(Mozo mozo) {}

	public void setMesaMozo(Mesa mesa, Mozo mozo) {}

	// verifica promos, instancia MesaAtendida, y la agrega a el ArrayList del mozo
	public void cierraMesa(Comanda comanda) {}

	public void cierraComanda(Comanda comanda) {}

	// crea comanda
	public void abreComanda(Mesa mesa) {}

	public void agregaPedidos(Comanda comanda, int cant, int idProd) {}

}
