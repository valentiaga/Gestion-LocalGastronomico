package negocio;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;

import excepciones.CantComensalesInvalida_Exception;
import excepciones.CantHijosInvalida_Exception;
import excepciones.ContrasenaIncorrecta_Exception;
import excepciones.EdadInvalida_Exception;
import excepciones.MesaOcupada_Exception;
import excepciones.NoExisteID_Exception;
import excepciones.NoExisteMesa_Exception;
import excepciones.NoExisteMozo_Exception;
import excepciones.NoExisteOperario_Exception;
import excepciones.NyARepetido_Exception;
import excepciones.UserNameRepetido_Exception;
import excepciones.precioInvalido_Exception;
import excepciones.prodEnUso_Exception;
import modelo.Enumerados;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Producto;
import modelo.Sueldo;
import util.Mensajes;

public class FuncionalidadAdmin extends FuncionalidadOperario
{

	public FuncionalidadAdmin(Operario operario)
	{
		super(operario);
	}

	public FuncionalidadAdmin()
	{

	}

	/**
	 * Metodo para agregar un mozo a la coleccion de mozos. <br>
	 * Pre: NyA != null, Nya != "" <br>
	 * Post: Se agrego el mozo a la coleccion. <br>
	 * 
	 * @param NyA              Nombre y apellido, identificador del mozo. <br>
	 * @param fechaNacimiento. <br>
	 * @param cantHijos.       <br>
	 * @param estado           activo, de franco, ausente. <br>
	 * @throws EdadInvalida_Exception      cuando la edad es menor que 18. <br>
	 * @throws CantHijosInvalida_Exception cuando la cantidad de hijos es menor que
	 *                                     0. <br>
	 * @throws NyARepetido_Exception       cuando ya hay registrado un mozo con ese
	 *                                     NyA. <br>
	 */

	public void agregaMozo(String NyA, GregorianCalendar fechaNacimiento, int cantHijos, Enumerados.estadoMozo estado)
			throws EdadInvalida_Exception, CantHijosInvalida_Exception, NyARepetido_Exception
	{
		LocalDate today = LocalDate.now();
		LocalDate fechaNac = LocalDate.of(fechaNacimiento.get(Calendar.YEAR), fechaNacimiento.get(Calendar.MONTH),
				fechaNacimiento.get(Calendar.DAY_OF_MONTH));
		long edad = ChronoUnit.YEARS.between(fechaNac, today);
		if (Sistema.getInstance().getMozos().get(NyA) != null)
			throw new NyARepetido_Exception("Ya existe un mozo registrado con este nombre");
		if (edad < 18)
			throw new EdadInvalida_Exception("Debe ser mayor de 18 anios.");
		if (cantHijos < 0)
			throw new CantHijosInvalida_Exception("Ingrese una cantidad de hijos valida.");
		Sistema.getInstance().getMozos().put(NyA, new Mozo(NyA, cantHijos));
	}

	/**
	 * Metodo que elimina mozo de la coleccion de mozos. <br>
	 * Pre: NyA != null, Nya != "" <br>
	 * Post: Se elimina el mozo. <br>
	 * 
	 * @param NyA Nombre y apellido, identificador del mozo. <br>
	 * @throws NoExisteMozo_Exception cuando el mozo que se quiere eliminar no
	 *                                existe en la coleccion. <br>
	 */

	public void eliminaMozo(String NyA) throws NoExisteMozo_Exception
	{
		if (Sistema.getInstance().getMozos().get(NyA) != null)
			Sistema.getInstance().getMozos().remove(NyA);
		else
			throw new NoExisteMozo_Exception("El mozo que desea eliminar no existe");
	}

	/**
	 * Metodo para modificar el estado de un operario. <br>
	 * Pre; userName != null, userName != "" <br>
	 * Post: Se modifica el estado del operario. <br>
	 * 
	 * @param userName Nombre de usuario del operario, identificador del operario.
	 *                 <br>
	 * @param activo   Boolean que representa el estado del operario. <br>
	 * @throws NoExisteOperario_Exception cuando el operario que se quiere modificar
	 *                                    no se encuentra en la coleccion. <br>
	 */

	public void modificaEstadoOperario(String userName, boolean activo) throws NoExisteOperario_Exception
	{
		Operario opActual = Sistema.getInstance().getOperariosRegistrados().get(userName);
		if (opActual != null)
			opActual.setActivo(activo);
		else
			throw new NoExisteOperario_Exception("No existe el opeario que desea modificar");
	}

	/**
	 * Metodo que registra un nuevo operario en el sistema. <br>
	 * Pre: NyA != null, Nya != "" <br>
	 * Post: Agrega un nuevo operario al HashMap
	 * 
	 * @param NyA      Nombre y apellido, identificador del mozo. <br>
	 * @param userName atributo correspondiente al nombre de usuario que usara el
	 *                 operario para el login. <br>
	 * @param password atributo que representa la contrasena y que corresponde al
	 *                 userName. <br>
	 * @throws UserNameRepetido_Exception     si el nombre de usuario ingresado esta
	 *                                        asociado a otra cuenta.
	 * @throws ContrasenaIncorrecta_Exception
	 */

	public void registraOperario(String NyA, String userName, String password, Enumerados.estadoOperario estado)
			throws UserNameRepetido_Exception, ContrasenaIncorrecta_Exception
	{
		boolean activo = true;
		if (estado == Enumerados.estadoOperario.INACTIVO)
			activo = false;
		if (this.verificaPassword(password) == false)
			throw new ContrasenaIncorrecta_Exception(
					"El campo contrase�a debe contener entre 6 y 12 caracteres. Con al menos 1 d�gito y 1 may�scula");
		else if (Sistema.getInstance().getOperariosRegistrados().putIfAbsent(userName,
				new Operario(NyA, userName, password, activo)) != null) // si ya estaba registrado tiramos excepcion????
			throw new UserNameRepetido_Exception("El userName '" + userName + "' ya esta asociado a un operario.");
	}

	/**
	 * Metodo que elimina un operario de la coleccion de operarios. <br>
	 * Pre; userName != null, userName != "" <br>
	 * Post: Se modifica el estado del operario. <br>
	 * 
	 * @param userName Nombre de usuario del operario, identificador del operario.
	 *                 <br>
	 * @throws NoExisteOperario_Exception cuando el operario que se quiere eliminar
	 *                                    no se encuentra en la coleccion. <br>
	 */
	public void eliminaOperario(String userName) throws NoExisteOperario_Exception
	{
		if (GestionOperario.existeOperario(userName) == false)
			throw new NoExisteOperario_Exception("No existe el operario que desea eliminar");
		else
			GestionOperario.eliminaOperario(userName);
	}

	/**
	 * Metodo para agregar un producto a la coleccion de productos. <br>
	 * Pre: nombre != null, nombre != "" <br>
	 * Post: Se agrego el producto. <br>
	 * 
	 * @param nombre       nombre del producto. <br>
	 * @param precioCosto
	 * @param precioVenta
	 * @param stockInicial
	 * @throws precioInvalido_Exception cuando alguno de los precios es negativo.
	 *                                  <br>
	 */
	public void agregaProducto(String nombre, double precioCosto, double precioVenta, int stockInicial)
			throws precioInvalido_Exception
	{

		if (precioVenta < precioCosto)
			throw new precioInvalido_Exception(Mensajes.PRECIO_VENTA_MENOR_COSTO);
		else if (precioVenta < 0 || precioCosto < 0)
			throw new precioInvalido_Exception(Mensajes.PRECIO_INVALIDO);

		Producto producto = new Producto(nombre, precioCosto, precioVenta, stockInicial);
		Sistema.getInstance().getProductos().put(producto.getIdProd(), producto);
	}

	/**
	 * Metodo para eliminar un producto de la coleccion de productos. <br>
	 * 
	 * @param idProd identificador del producto. <br>
	 * @throws prodEnUso_Exception  cuando el producto que se quiere eliminar se
	 *                              encuentra en una comanda activa. <br>
	 * @throws NoExisteID_Exception cuando el producto que se quiere eliminar no
	 *                              existe en la coleccion. <br>
	 */
	public void eliminaProducto(int idProd) throws prodEnUso_Exception, NoExisteID_Exception
	{
		if (GestionProductos.existeProducto(idProd) == false) // fijarse de ponerlo en gestion prod venta
			throw new NoExisteID_Exception("No existe el producto que desea eliminar");
		if (GestionComandas.contieneProd(idProd) == true)
			throw new prodEnUso_Exception("El producto esta en una comanda activa, no puede ser eliminado");
		GestionProductos.eliminaProducto(idProd);
	}

	/**
	 * Metodo para agregar una mesa a la coleccion de mesas. <br>
	 * 
	 * @param cantSillas cantidad de personas que ocuparan la mesa. <br>
	 * @throws CantComensalesInvalida_Exception cuando se quiere agregar una mesa
	 *                                          (la mesa nro 0 es la barra) que no
	 *                                          es la barra, la cantidad de sillas
	 *                                          debe ser mayor a 2. <br>
	 */
	public void agregaMesa(int cantSillas) throws CantComensalesInvalida_Exception
	{
		if (Mesa.getSiguienteNroMesa() > 0 && cantSillas < 2)
		{
			throw new CantComensalesInvalida_Exception("Solo se permiten menos de dos comensales en la barra");
		}
		Mesa mesa = new Mesa(cantSillas);
		Sistema.getInstance().getMesas().put(mesa.getNroMesa(), mesa);
	}

	/**
	 * Metodo para eliminar una mesa. <br>
	 * 
	 * @param nroMesa identificador de la mesa. <br>
	 * @throws NoExisteMesa_Exception cuando la mesa no existe en la coleccion de
	 *                                mesas. <br>
	 * @throws MesaOcupada_Exception  cuando la mesa que se desea eliminar se
	 *                                encuentra ocupada. <br>
	 */
	public void eliminaMesa(int nroMesa) throws NoExisteMesa_Exception, MesaOcupada_Exception
	{
		if (GestionMesas.existeMesa(nroMesa) == false) // fijarse de ponerlo en gestion mesa
			throw new NoExisteMesa_Exception("No existe la mesa que desea eliminar");
		if (Sistema.getInstance().getMesas().get(nroMesa).getEstado() == Enumerados.estadoMesa.OCUPADA)
			throw new MesaOcupada_Exception("Espere a que se libere la mesa para elimianrla.");
		GestionMesas.eliminaMesa(nroMesa);
	}

	/**
	 * Metodo para modificar la remuneracion basica. <br>
	 * 
	 * @param remBasica atributo cuyo valor se utiliza para calcular los sueldos.
	 *                  <br>
	 */
	public void modificaRemuneracionBasica(double remBasica)
	{
		Sueldo.setRemBasic(remBasica);
	}

}
