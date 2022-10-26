package negocio;

import java.util.ArrayList;

import excepciones.CantComensalesInvalida_Exception;
import excepciones.CantHijosInvalida_Exception;
import excepciones.NoExisteID_Exception;
import excepciones.NoExisteMesa_Exception;
import excepciones.ProductoNulo_Exception;
import excepciones.PromoIdRepetido_Exception;
import excepciones.PromoInvalida_Exception;
import excepciones.PromoRepetida_Exception;
import excepciones.UserNameRepetido_Exception;
import excepciones.precioInvalido_Exception;
import excepciones.prodEnUso_Exception;
import modelo.Comanda;
import modelo.Enumerados;
import modelo.Mesa;
import modelo.MesaAtendida;
import modelo.Mozo;
import modelo.Operario;
import modelo.Pedido;
import modelo.Producto;
import modelo.PromocionProd;
import modelo.PromocionTemporal;

public class FuncionalidadOperario {

	private Operario operario;
	private Sistema sistema = Sistema.getInstance();

	public FuncionalidadOperario(Operario operario) {
		super();
		this.operario = operario;
	}

	public Operario getOperario() {
		return operario;
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
		if (userName != this.operario.getUserName()
				&& Sistema.getInstance().getOperariosRegistrados().containsKey(userName))
			throw new UserNameRepetido_Exception("El nombre de usuario ya se encuentra registrado en el sistema.");
		this.operario.setNyA(NyA);
		this.operario.setPassword(password);
		this.operario.setUserName(userName);
		this.operario.setActivo(activo); // El estado se modifica?
	}

	public void eliminaOperario() { // consideramos que el operario puede eliminarse por s� mismo al igual que
									// puede
									// eliminarlo el admin.
		Sistema.getInstance().getOperariosRegistrados().remove(this.operario); // hay q volver a la vista inicial una
																				// vez eliminado
	}

	/**
	 * metodo para modificar el/los atributos del mozo que se desee/n.
	 * 
	 * @param NyA       nombre y apellido nuevo.
	 * @param cantHijos nueva cantidad de hijos.
	 * @param mozo      que se desea modificar.
	 */
	public void modificaMozo(Mozo mozo, String NyA, int cantHijos) throws CantHijosInvalida_Exception { // el estado lo
																										// modifica el o
																										// // el
																										// sistema??
		if (cantHijos < 0)
			throw new CantHijosInvalida_Exception("Ingrese una cantidad de hijos valida.");
		mozo.setCantHijos(cantHijos);
		mozo.setNyA(NyA);
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
	public void modificaProducto(int idProd, String nombre, double precioCosto, double precioVenta, int stockInicial)
			throws NoExisteID_Exception, precioInvalido_Exception, prodEnUso_Exception {
		Producto prodActual = Sistema.getInstance().getProductos().get(idProd);
		if (prodActual == null)
			throw new NoExisteID_Exception("No existe el producto que desea modificar. Ingrese un ID valido.");
		if (precioCosto < 0 || precioVenta < 0)
			throw new precioInvalido_Exception("Ninguno de los precios puede ser negativo.");
		if (GestionComandas.contieneProd(idProd) == true)
			throw new prodEnUso_Exception("El producto esta en una comanda activa, no puede ser modificado");
		prodActual.setNombre(nombre);
		prodActual.setPrecioCosto(precioCosto);
		prodActual.setPrecioVenta(precioVenta);
		prodActual.setStockInicial(stockInicial);
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

	public void modificaMesa(int nroMesa, int cantPax, Enumerados.estadoMesa estado)
			throws NoExisteMesa_Exception, CantComensalesInvalida_Exception {
		Mesa mesaActual = Sistema.getInstance().getMesas().get(nroMesa);
		if (mesaActual == null)
			throw new NoExisteMesa_Exception("No existe la mesa que desea modificar.");
		if (cantPax < 2 && nroMesa > 0)
			throw new CantComensalesInvalida_Exception("La cantidad de comensales debe ser mayor a uno.");
		mesaActual.setCantPax(cantPax);
		mesaActual.setEstado(estado);
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
	public void agregaPromocionProd(Producto producto, Enumerados.diasDePromo dia, boolean aplica2x1,
			boolean aplicaDtoPorCantidad, int dtoPorCantidad_CantMinima, double dtoPorCantidad_PrecioUnitario,
			boolean activa) throws ProductoNulo_Exception, PromoInvalida_Exception {
		if (producto == null)
			throw new ProductoNulo_Exception("El producto no puede ser nulo.");
		if (aplica2x1 == false && aplicaDtoPorCantidad == false)
			throw new PromoInvalida_Exception("Alguna de las promos 2x1 o dto por cantidad debe ser verdadera.");
		PromocionProd promoNueva = new PromocionProd(activa, dia, producto, aplica2x1, aplicaDtoPorCantidad,
				dtoPorCantidad_CantMinima, dtoPorCantidad_PrecioUnitario);
		Sistema.getInstance().getPromocionProds().put(promoNueva.getIdProm(), promoNueva);
	}

	/**
	 * metodo para modificar el estado de una promo.<br>
	 * 
	 * @param idProm identificador de la promo. <br>
	 * @param activa estado de la promo. <br>
	 */

	public void modificaPromocionProd(int idProm, boolean activa, Enumerados.diasDePromo dia, boolean aplica2x1,
			boolean aplicaDtoPorCantidad, int dtoPorCantidad_CantMinima, double dtoPorCantidad_PrecioUnitario)
			throws PromoInvalida_Exception, NoExisteID_Exception {

		if (aplica2x1 == false && aplicaDtoPorCantidad == false)
			throw new PromoInvalida_Exception("Alguna de las promos 2x1 o dto por cantidad debe ser verdadera.");
		PromocionProd promoActual = Sistema.getInstance().getPromocionProds().get(idProm);

		if (promoActual == null)
			throw new NoExisteID_Exception("No existe la promo " + idProm + ".");

		promoActual.setAplica2x1(aplica2x1);
		promoActual.setAplicaDtoPorCant(aplicaDtoPorCantidad);
		promoActual.setDtoPorCant_CantMinima(dtoPorCantidad_CantMinima);
		promoActual.setDtoPorCant_PrecioUnitario(dtoPorCantidad_PrecioUnitario);
		promoActual.setActiva(activa);
	}

	/**
	 * metodo que elimina la promo. <br>
	 * 
	 * @param idProm identificador de la promo. <br>
	 */

	public void eliminaPromocionProd(int idProm) {
		Sistema.getInstance().getPromocionProds().remove(idProm);
	}

	/*public void agregaPromocionTemporal(boolean activa, modelo.Enumerados.diasDePromo diasDePromo, String nombre,
			modelo.Enumerados.formaDePago formaDePago, int porcentajeDesc, boolean esAcumulable, int horaInicio,
			int horaFinal) throws PromoRepetida_Exception {

		PromocionTemporal promoActual = new PromocionTemporal(activa, diasDePromo, nombre, formaDePago, porcentajeDesc,
				esAcumulable, horaInicio, horaFinal);
		if (Sistema.getInstance().getPromocionTemp().put(nombre, promoActual) != null)
			throw new PromoRepetida_Exception("Ya existe la promo '" + nombre + "'.");
	}*/
	public void agregaPromocionTemporal(boolean activa, modelo.Enumerados.diasDePromo diasDePromo, String nombre,
			modelo.Enumerados.formaDePago formaDePago, int porcentajeDesc, boolean esAcumulable, int horaInicio,
			int horaFinal) throws PromoRepetida_Exception {

		ArrayList<PromocionTemporal> promosTemp = Sistema.getInstance().getPromocionesTemp();
		PromocionTemporal promoActual = new PromocionTemporal(activa, diasDePromo, nombre, formaDePago, porcentajeDesc,
				esAcumulable, horaInicio, horaFinal);
		if (promosTemp.contains(promoActual))
			throw new PromoRepetida_Exception("Ya existe la promo '" + nombre + "'.");
		else
			promosTemp.add(promoActual);
	}

	/*public void eliminaPromocionTemporal(String nombre) {
		Sistema.getInstance().getPromocionTemp().remove(nombre);
	}*/
	public void eliminaPromocionTemporal(String nombre) {
		ArrayList<PromocionTemporal> promosTemp = Sistema.getInstance().getPromocionesTemp();
		for (int i = 0; i<promosTemp.size(); i++)
			if (promosTemp.get(i).getNombre() == nombre)
				promosTemp.remove(i);
	}

	/*public void modificaPromocionTemporal(String nombre, Enumerados.diasDePromo diasDePromo,
			Enumerados.formaDePago formaDePago, boolean activo, int porcentajeDescuento, boolean esAcumulable,
			int horaInicio, int horaFinal) throws PromoInvalida_Exception {

		Sistema sistema = Sistema.getInstance();
		PromocionTemporal promocionTemporal = sistema.getPromocionTemp().get(nombre);

		if (promocionTemporal == null)
			throw new PromoInvalida_Exception("La promocion '" + nombre + "' no existe.");

		promocionTemporal.setActiva(activo);
		promocionTemporal.setPorcentajeDesc(porcentajeDescuento); // controlar en la ventana que sea > 0
		promocionTemporal.setEsAcumulable(esAcumulable);
		promocionTemporal.setHoraInicio(horaInicio); // controlar en la ventana que sea 0< > 24
		promocionTemporal.setHoraFinal(horaFinal);
		promocionTemporal.setFormaDePago(formaDePago);
		promocionTemporal.setDiasDePromo(diasDePromo);
	}*/
	
	public void modificaPromocionTemporal(String nombre, Enumerados.diasDePromo diasDePromo,
			Enumerados.formaDePago formaDePago, boolean activo, int porcentajeDescuento, boolean esAcumulable,
			int horaInicio, int horaFinal) throws PromoInvalida_Exception {

		Sistema sistema = Sistema.getInstance();
		ArrayList<PromocionTemporal> promosTemp = sistema.getPromocionesTemp();
		PromocionTemporal promocionTemporal = null;
		
		for (int i = 0; i<promosTemp.size(); i++)
			if (promosTemp.get(i).getNombre() == nombre) {
				promocionTemporal = promosTemp.get(i);
				promocionTemporal.setActiva(activo);
				promocionTemporal.setPorcentajeDesc(porcentajeDescuento); // controlar en la ventana que sea > 0
				promocionTemporal.setEsAcumulable(esAcumulable);
				promocionTemporal.setHoraInicio(horaInicio); // controlar en la ventana que sea 0< > 24
				promocionTemporal.setHoraFinal(horaFinal);
				promocionTemporal.setFormaDePago(formaDePago);
				promocionTemporal.setDiasDePromo(diasDePromo);
			}
		if (promocionTemporal == null)
			throw new PromoInvalida_Exception("La promocion '" + nombre + "' no existe.");
	}

	public void setEstadoMozo(Mozo mozo, Enumerados.estadoMozo estado) {
		mozo.setEstado(estado);
	}

	public void setMesaMozo(Mesa mesa, Mozo mozo) {
		mesa.setMozo(mozo);
	}

	// verifica promos, instancia MesaAtendida, y la agrega a el ArrayList del mozo
	public void cierraMesa(Comanda comanda, Enumerados.formaDePago formaDePago) { // forma de pago la eligen en la
																					// ventana

		Mesa mesaActual = comanda.getMesa();
		comanda.setEstado(Enumerados.estadoComanda.CERRADO);
		Mozo mozo = mesaActual.getMozo();
		double total = GestionComandas.totalComandaSinDescuento(comanda);

		MesaAtendida mesaAtendida = new MesaAtendida(comanda.getMesa(), comanda.getPedidos(), total, formaDePago);
		GestionProdPromo.cargaPromosProd(comanda);
		GestionProdTemp.cargaPromosTemp(comanda);
		//falta calcular el total con descuento. Maybe en GestionComanda.
		mozo.getMesasAtendidas().add(mesaAtendida);

		mesaActual.setEstado(Enumerados.estadoMesa.LIBRE);
	}

	// crea comanda
	public void abreComanda(Mesa mesa) {
		Sistema sistema = Sistema.getInstance();

		sistema.getComandas().add(new Comanda(mesa, Enumerados.estadoComanda.ABIERTO));
	}

	public void agregaPedidos(Comanda comanda, int cant, int idProd) {

		Producto producto = Sistema.getInstance().getProductos().get(idProd);

		comanda.agregaPedido(new Pedido(producto, cant));
	}

}
