package negocio;

import java.util.ArrayList;
import java.util.HashMap;

import excepciones.CantComensalesInvalida_Exception;
import excepciones.CantHijosInvalida_Exception;
import excepciones.ContrasenaIncorrecta_Exception;
import excepciones.EstadoIncorrecto_Exception;
import excepciones.MesaNoOcupadaException;
import excepciones.MesaOcupada_Exception;
import excepciones.MozoInactivo_Exception;
import excepciones.NoExisteID_Exception;
import excepciones.NoExisteMesa_Exception;
import excepciones.NyARepetido_Exception;
import excepciones.PromoIdRepetido_Exception;
import excepciones.PromoInvalida_Exception;
import excepciones.PromoRepetida_Exception;
import excepciones.StockInsuficiente_Exception;
import excepciones.UserNameRepetido_Exception;
import excepciones.precioInvalido_Exception;
import excepciones.prodEnUso_Exception;
import modelo.Comanda;
import modelo.Enumerados;
import modelo.Mesa;
import modelo.MesaAtendida;
import modelo.Mozo;
import modelo.Operario;
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
	public FuncionalidadOperario() {
		
	}
	public Operario getOperario() {
		return operario;
	}

	/**
	 * Metodo para setear el estado de un mozos. <br>
	 * Pre: Nya != null, NyA != "" <br>
	 * Post: Se setea el estado del mozo. <br>
	 * @param estado activo, de franco, ausente. <br>
	 * @param nya Nombre y apellido, identificador del mozo. <br>
	 */
	public void estableceEstadosMozos(Enumerados.estadoMozo estado, String nya) { 
		Mozo mozoActual = Sistema.getInstance().getMozos().get(nya);
		mozoActual.setEstado(estado);
	}

	/**
	 * Metodo utilizado para modificar el o los campos de Operario que se deseen. <br>
	 * Pre: Nya != null, NyA != "", userName != null, userName != "", password != null, password != "" <br>
	 * Post: Se modifican los atributos del operario. <br>
	 * @param NyA      nombre y apellido nuevo. <br>
	 * @param userName nuevo nombre de usuario. <br>
	 * @param password nueva contrasenia. <br>
	 * @param activo   nuevo estado del Operario. <br>
	 * @throws UserNameRepetido_Exception Se lanza si el nuevo nombre de usuario ya existe en el sistema. <br>
	 * @throws ContrasenaIncorrecta_Exception  
	 */
	
	public void modificaOperario(String NyA, String userName, String password)
			throws UserNameRepetido_Exception, ContrasenaIncorrecta_Exception {
		if (userName != this.operario.getUserName()
				&& Sistema.getInstance().getOperariosRegistrados().containsKey(userName))
			throw new UserNameRepetido_Exception("El nombre de usuario ya se encuentra registrado en el sistema.");
		else if (this.verificaPassword(password)== false)
			throw new ContrasenaIncorrecta_Exception("El campo contrase�a debe contener entre 6 y 12 caracteres. Con al menos 1 d�gito y 1 may�scula");
		else {
			this.operario.setNyA(NyA);
			this.operario.setPassword(password);
			this.operario.setUserName(userName);
		}
	}

	/**
	 * metodo para modificar el/los atributos del mozo que se deseen.<br>
	 * Pre: Nya != null, NyA != "" <br>
	 * Post: Mozo modificado. <br>
	 * @param cantHijos nueva cantidad de hijos. <br>
	 * @param mozo      que se desea modificar.  <br>
	  * @throws CantHijosInvalida_Exception cuando la cantidad de hijos es negativa. <br>
	 * @throws NyARepetido_Exception Ya existe un mozo con el nombre que intenta ingresar. <br>
	 */
	public void modificaMozo(Mozo mozo, Enumerados.estadoMozo estado, int cantHijos) throws CantHijosInvalida_Exception, NyARepetido_Exception { 
		if (cantHijos < 0)
			throw new CantHijosInvalida_Exception("Ingrese una cantidad de hijos valida.");
		else{
			mozo.setCantHijos(cantHijos);
			mozo.setEstado(estado);
		}
	}

	/**
	 * metodo para modificar el/los atributos que se deseen del producto. <br>
	 * @param id           correspondiente al producto. <br>
	 * @param nombre       nuevo nombre del producto. <br>
	 * @param precioCosto  nuevo precio de costo. <br>
	 * @param precioVenta  nuevo precio de venta. <br>
	 * @param stockInicial nuevo stock inicial. <br>
	 * @throws NoExisteID_Exception Se lanza si el ID ingresado no esta relacionado a ningun producto del sistema.
	 * @throws precioInvalido_Exception	
	 * @throws prodEnUso_Exception
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
	 * @throws NoExisteMesa_Exception Se lanza si el ID no corresponde con ninguna mesa cargada en el sistema. <br>
	  * @throws CantComensalesInvalida_Exception cuando la cantidad de comensales de una mesa es menos que 2.  <br>                           
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
	} 

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
	 * @throws NoExisteID_Exception 
	 * @throws PromoIdRepetido_Exception Se lanza si se intenta asignar un
	 *                                   identificador de promo existente. <br>
	 */
	public void agregaPromocionProd(int idProd, Enumerados.diasDePromo dia, boolean aplica2x1,
			boolean aplicaDtoPorCantidad, int dtoPorCantidad_CantMinima, double dtoPorCantidad_PrecioUnitario,
			boolean activa) throws PromoInvalida_Exception, NoExisteID_Exception {
		Producto producto = Sistema.getInstance().getProductos().get(idProd);
		if (producto == null)
			throw new NoExisteID_Exception("No existe el producto con id " + idProd + ".");
		if (aplica2x1 == false && aplicaDtoPorCantidad == false)
			throw new PromoInvalida_Exception("Alguna de las promos 2x1 o dto por cantidad debe ser verdadera.");
		PromocionProd promoNueva = new PromocionProd(activa, dia, producto, aplica2x1, aplicaDtoPorCantidad,
				dtoPorCantidad_CantMinima, dtoPorCantidad_PrecioUnitario);
		Sistema.getInstance().getPromocionProds().put(promoNueva.getIdProm(), promoNueva);
	}

	/**
	 * Metodo para modificar el estado de una promo.<br>
	 * 
	 * @param idProm identificador de la promo. <br>
	 * @param activa estado de la promo. <br>
	 */

	public void modificaPromocionProd(int idProm, boolean activa, Enumerados.diasDePromo dia, boolean aplica2x1,
			boolean aplicaDtoPorCantidad, int dtoPorCantidad_CantMinima, double dtoPorCantidad_PrecioUnitario)
			throws PromoInvalida_Exception, NoExisteID_Exception {
		PromocionProd promoActual = Sistema.getInstance().getPromocionProds().get(idProm);
		if (promoActual == null)
			throw new NoExisteID_Exception("No existe la promo " + idProm + ".");

		if (aplica2x1 == false && aplicaDtoPorCantidad == false)
			throw new PromoInvalida_Exception("Alguna de las promos 2x1 o dto por cantidad debe ser verdadera.");

		promoActual.setAplica2x1(aplica2x1);
		promoActual.setAplicaDtoPorCant(aplicaDtoPorCantidad);
		promoActual.setDtoPorCant_CantMinima(dtoPorCantidad_CantMinima);
		promoActual.setDtoPorCant_PrecioUnitario(dtoPorCantidad_PrecioUnitario);
		promoActual.setActiva(activa);
	}

	/**
	 * Metodo que elimina la promo. <br>
	 * 
	 * @param idProm identificador de la promo. <br>
	 */

	public void eliminaPromocionProd(int idProm) throws PromoInvalida_Exception {
		if (Sistema.getInstance().getPromocionProds().get(idProm) != null)
			Sistema.getInstance().getPromocionProds().remove(idProm);
		else
			throw new PromoInvalida_Exception("No existe la promo que intenta eliminar");
	}

	/**
	 * Metodo para agregar una promocion temporal a la coleccion de promociones temporales. <br>
	 * @param activa	
	 * @param diasDePromo determina el dia en el que es validad la promocion (LUNES,MARTES,MIERCOLES,JUEVES,VIERNES,SABADO,DOMINGO;). <br>
	 * @param nombre de la promocion. (identificador de la promocion temporal)<br>
	 * @param formaDePago puede ser EFECTIVO,TARJETA,MERCPAGO,CTADNI. <br>
	 * @param porcentajeDesc porcentaje de descuento. <br>
	 * @param esAcumulable determina si la promocion es acumulable con otras promociones. <br>
	 * @param horaInicio
	 * @param horaFinal
	 * @throws PromoRepetida_Exception cuando la promocion que se desea agregar ya existe en la coleccion de promociones temporales. <br>
	 */
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

	/**
	 * Metodo para eliminar una promocion temporal de la coleccion de promociones temporales. <br>
	 * Pre: nombre != null, nombre != "". <br>
	 * Post: Se elimina la promocion temporal. <br>
	 * @param nombre de la promocion a eliminar(identificador de la promocion temporal). <br>
	 * @throws PromoInvalida_Exception cuando la promocion que se desea eliminar no existe en la coleccion de promociones temporales. <br>
	 */
	public void eliminaPromocionTemporal(String nombre) throws PromoInvalida_Exception  {
		ArrayList<PromocionTemporal> promosTemp = Sistema.getInstance().getPromocionesTemp();
		int bandera = 0, i = 0;
		while (i < promosTemp.size() && bandera == 0) {
			if (promosTemp.get(i).getNombre() == nombre) {
				promosTemp.remove(i);
				bandera = 1;
			}		
			i++;
		}
		if (bandera == 0)
			throw new PromoInvalida_Exception("No existe la promo que intenta eliminar");
	}

	/**
	 * Metodo que modifica una promocion temporal. <br>
	 * Pre: nombre != null, nombre != "". <br>
	 * Post: Se modifica la promocion temporal. <br>
	 * @param nombre de la promocion temporal que se quiere modificar (identificador de la promocion temporal). <br>
	* @param diasDePromo determina el dia en el que es validad la promocion (LUNES,MARTES,MIERCOLES,JUEVES,VIERNES,SABADO,DOMINGO;). <br>
	 * @param nombre de la promocion. (identificador de la promocion temporal)<br>
	 * @param formaDePago puede ser EFECTIVO,TARJETA,MERCPAGO,CTADNI. <br>
	 * @param porcentajeDesc porcentaje de descuento. <br>
	 * @param esAcumulable determina si la promocion es acumulable con otras promociones. <br>
	 * @param activo
	 * @param horaInicio
	 * @param horaFinal
	 * @throws PromoInvalida_Exception cuando la promocion a modificar no existe. <br>
	 */
	public void modificaPromocionTemporal(String nombre, Enumerados.diasDePromo diasDePromo,
			Enumerados.formaDePago formaDePago, boolean activo, int porcentajeDescuento, boolean esAcumulable,
			int horaInicio, int horaFinal) throws PromoInvalida_Exception {

		Sistema sistema = Sistema.getInstance();
		ArrayList<PromocionTemporal> promosTemp = sistema.getPromocionesTemp();
		PromocionTemporal promocionTemporal = null;

		for (int i = 0; i < promosTemp.size(); i++)
			if (promosTemp.get(i).getNombre() == nombre) {
				promocionTemporal = promosTemp.get(i);
				promocionTemporal.setActiva(activo);
				promocionTemporal.setPorcentajeDesc(porcentajeDescuento); 
				promocionTemporal.setEsAcumulable(esAcumulable);
				promocionTemporal.setHoraInicio(horaInicio); 
				promocionTemporal.setHoraFinal(horaFinal);
				promocionTemporal.setFormaDePago(formaDePago);
				promocionTemporal.setDiasDePromo(diasDePromo);
			}
		if (promocionTemporal == null)
			throw new PromoInvalida_Exception("La promocion '" + nombre + "' no existe.");
	}

	/**
	 * Metodo que setea a una mesa un mozo.<br>
	 * Pre: mozo != null <br>
	 * Post: Se setea el mozo en la mesa. <br>
	 * @param nroMesa ID de mesa. <br>
	 * @param mozo
	 * @throws NoExisteMesa_Exception Se lanza cuando la mesa no existe en la coleccion de mesas. <br>
	 * @throws EstadoIncorrecto_Exception Se lanza cuando el estado del mozo a setear es distinto de ACTIVO. <br>
	 */
	public void setMesaMozo(int nroMesa, Mozo mozo) throws NoExisteMesa_Exception, EstadoIncorrecto_Exception{
		Mesa mesa = Sistema.getInstance().getMesas().get(nroMesa);
		if (mesa!= null)
			if (mozo.getEstado() == Enumerados.estadoMozo.ACTIVO)
				mesa.setMozo(mozo);
			else
				throw new EstadoIncorrecto_Exception("El mozo no se encuentra ACTIVO");
		else
			throw new NoExisteMesa_Exception("No existe la mesa seleccionada");
	}
	
	/**
	 * Metodo para cerrar una mesa. <br>
	 * Post: Se cierra la mesa. <br>
	 * @param nroMesa ID de mesa. <br>
	 * @param formaDePago puede ser EFECTIVO,TARJETA,MERCPAGO,CTADNI. <br>
	 * @throws MesaNoOcupadaException cuando la mesa == null, o el estado de la mesa sigue en ocupada. <br>
	 */
	
	public void cierraMesa(int nroMesa, Enumerados.formaDePago formaDePago) throws MesaNoOcupadaException{

		Mesa mesaActual = Sistema.getInstance().getMesas().get(nroMesa);
		if (mesaActual!=null && mesaActual.getEstado() == Enumerados.estadoMesa.OCUPADA) {
			Comanda comanda = mesaActual.getComanda(); 
			comanda.setEstado(Enumerados.estadoComanda.CERRADO);
			Mozo mozo = mesaActual.getMozo();
			double total = GestionComandas.totalComandaSinDescuento(comanda);
			MesaAtendida mesaAtendida = new MesaAtendida(comanda.getMesa(), comanda.getPedidos(), total, formaDePago);
			mozo.getMesasAtendidas().add(mesaAtendida);
			GestionProdPromo.cargaPromosProd(comanda);
			GestionProdTemp.cargaPromosTemp(comanda);
			GestionComandas.totalComandaConDescuento(mesaAtendida, comanda);
			mesaActual.setEstado(Enumerados.estadoMesa.LIBRE);
		}
		else
			throw new MesaNoOcupadaException("La mesa no esta ocupada o no existe.");
	}


	/**
	 * Metodo para abrir una comanda. <br>
	 * Post: Se abre una comanda en la mesa ingresada. <br>
	 * @param mesa a en la que se va a crear la comanda. <br>
	 * @throws NoExisteMesa_Exception cuando la mesa es null. <br>
	 * @throws MesaOcupada_Exception cuando la mesa ya se encuentra ocupada. <br>
	 * @throws MozoInactivo_Exception cuando no hay ningun mozo activo para asignar a la mesa.<br>
	 */
	public void abreComanda(Mesa mesa) throws NoExisteMesa_Exception, MesaOcupada_Exception, MozoInactivo_Exception{ 
		int i=0, bandera=0;
		String nombreMozo="";
		HashMap<String, Mozo> mozos = Sistema.getInstance().getMozos();
		ArrayList<String> arrayMozo = new ArrayList<String>();
		for (HashMap.Entry<String, Mozo> entry : mozos.entrySet()) {
			arrayMozo.add(entry.getKey());
		}
		if (mesa != null) { 
			if (Sistema.getInstance().getMesas().get(mesa.getNroMesa()).getEstado() == Enumerados.estadoMesa.LIBRE) {
				Sistema.getInstance().getMesas().get(mesa.getNroMesa()).setEstado(Enumerados.estadoMesa.OCUPADA);
				Sistema sistema = Sistema.getInstance();
				Comanda comanda = new Comanda(mesa, Enumerados.estadoComanda.ABIERTO);
				mesa.setComanda(comanda); 
				sistema.getComandas().add(comanda);	
				while (i<30 && bandera==0) {
					i = (int) (Math.random() * (arrayMozo.size()+1));
					nombreMozo = arrayMozo.get(i);
					if (Sistema.getInstance().getMozos().get(nombreMozo).getEstado()==Enumerados.estadoMozo.ACTIVO) {
						bandera=1;
						mesa.setMozo(Sistema.getInstance().getMozos().get(nombreMozo));
					}
				}
				if (bandera==0)
					throw new MozoInactivo_Exception("No hay mozos activos en este momento");
			}
			else throw new MesaOcupada_Exception("La mesa se encuentra ocupada.");
		}
		else
			throw new NoExisteMesa_Exception("No existe la mesa en el local");
	}

	/*public void agregaPedidos(Comanda comanda, int cant, int idProd) {

		Producto producto = Sistema.getInstance().getProductos().get(idProd);

		comanda.agregaPedido(new Pedido(producto, cant));
	}*/
	
	/**
	 * Metodo para agregar un pedido a la comanda de una mesa. <br>
	 * @param nroMesa ID de la mesa. <br>
	 * @param cant cantidad del producto. <br>
	 * @param idProd identificador del producto a agregar. <br>
	 * @throws StockInsuficiente_Exception	cuando la cantidad de productos a agregar es mayor a su stock. <br>
	 * @throws NoExisteID_Exception	cuando el idProd no corresponde a ningun producto. <br>
	 */
	public void agregaPedidos(int nroMesa, int cant, int idProd) throws StockInsuficiente_Exception, NoExisteID_Exception {
		GestionMesas.agregaPedidos(Sistema.getInstance().getMesas().get(nroMesa), cant, idProd);
	}
	/**
	 * Metodo que modifica el password del operario. <br>
	 * Pre: password != "", password != null, 6 <= password <= 12 caracteres con al menos un digito y una mayuscula. <br>
	 * @param password
	 */
	public void modificaPassword(String password) {
		this.getOperario().setPassword(password);
	}
	
	/**
	 * Metodo que verifica que 6 <= password <= 12 caracteres con al menos un digito y una mayuscula. <br>
	 * @param password
	 * @return 
	 */
	public boolean verificaPassword (String password){
		boolean res = false, banMayus = false, banDigit = false;
		if (password.length()>12 || password.length()<6 ) {
			return res;
		}
		else {
			for (int i = 0; i < password.length(); i++) {
				if (Character.isUpperCase(password.charAt(i)))
					banMayus = true;
				if (Character.isDigit(password.charAt(i)))
					banDigit = true;
			}
			if (banMayus == true  && banDigit==true)
				res=true;
		}
		return res;
	}
	
	
}
