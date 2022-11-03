package negocio;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;

import excepciones.CantHijosInvalida_Exception;
import excepciones.EdadInvalida_Exception;
import excepciones.MesaOcupada_Exception;
import excepciones.NoExisteID_Exception;
import excepciones.NoExisteMesa_Exception;
import excepciones.NoExisteMozo_Exception;
import excepciones.NoExisteOperario_Exception;
import excepciones.UserNameRepetido_Exception;
import excepciones.precioInvalido_Exception;
import excepciones.prodEnUso_Exception;
import modelo.Enumerados;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Producto;

public class FuncionalidadAdmin extends FuncionalidadOperario {

	public FuncionalidadAdmin(Operario operario) {
		super(operario);
	}

	public void agregaMozo(String NyA, GregorianCalendar fechaNacimiento, int cantHijos, Enumerados.estadoMozo estado) throws EdadInvalida_Exception, CantHijosInvalida_Exception {
		LocalDate today = LocalDate.now();
        LocalDate fechaNac = LocalDate.of(fechaNacimiento.get(Calendar.YEAR), fechaNacimiento.get(Calendar.MONTH), fechaNacimiento.get(Calendar.DAY_OF_MONTH));
        long edad = ChronoUnit.YEARS.between(fechaNac, today);
       
		if (edad < 18)
			throw new EdadInvalida_Exception("Debe ser mayor de 18 anios.");
		if (cantHijos<0)
			throw new CantHijosInvalida_Exception("Ingrese una cantidad de hijos valida.");
		Sistema.getInstance().getMozos().put(NyA, new Mozo(NyA,cantHijos));
	}

	public void eliminaMozo(String NyA)throws NoExisteMozo_Exception{	
		if (Sistema.getInstance().getMozos().get(NyA)!= null)
			Sistema.getInstance().getMozos().remove(NyA);
		else
			throw new NoExisteMozo_Exception("El mozo que desea eliminar no existe");
	}
	
	/**
	 * Metodo que registra un nuevo operario en el sistema. <br>
	 * Post: Agrega un nuevo operario al HashMap
	 * 
	 * @param NyA      atributo correspondiente al nombre y apellido del operario
	 *                 que desea registrarse. <br>
	 * @param userName atributo correspondiente al nombre de usuario que usara el
	 *                 operario para el login. <br>
	 * @param password atributo que representa la contrasena y que corresponde al
	 *                 userName. <br>
	 * @throws UserNameRepetido_Exception si el nombre de usuario ingresado esta
	 *                                    asociado a otra cuenta.
	 */
	
	public void registraOperario (String NyA, String userName, String password) throws UserNameRepetido_Exception{
		if(Sistema.getInstance().getOperariosRegistrados().putIfAbsent(userName, new Operario(NyA,userName,password,true)) != null)	// si ya estaba registrado tiramos excepcion????
			throw new UserNameRepetido_Exception("El userName '"+userName+"' ya esta asociado a un operario.");
	}
	
	public void eliminaOperario(String userName)throws NoExisteOperario_Exception{
		if (Sistema.getInstance().getOperariosRegistrados().get(userName)!= null)
			Sistema.getInstance().getOperariosRegistrados().remove(userName);
		else
			throw new NoExisteOperario_Exception("No existe el operario que desea eliminar");
	}

	public void agregaProducto(String nombre, double precioCosto, double precioVenta, int stockInicial) throws precioInvalido_Exception{
		
		if(precioVenta < precioCosto) 
			throw new precioInvalido_Exception("El precio de venta debe ser mayor o igual al costo.");
		else
			if(precioVenta < 0 || precioCosto < 0) 
				throw new precioInvalido_Exception("Ninguno de los precios puede ser negativo.");
			
		Producto producto = new Producto(nombre,precioCosto,precioVenta,stockInicial);
		Sistema.getInstance().getProductos().put(producto.getIdProd(), producto);
			
	}

	public void eliminaProducto(int idProd) throws prodEnUso_Exception, NoExisteID_Exception {
		if (Sistema.getInstance().getProductos().get(idProd)==null) //fijarse de ponerlo en gestion prod venta
			throw new NoExisteID_Exception("No existe el producto que desea eliminar");
		if(GestionComandas.contieneProd(idProd) == true)
			throw new prodEnUso_Exception("El producto esta en una comanda activa, no puede ser eliminado");
		Sistema.getInstance().getProductos().remove(idProd);
	}
	
	public void agregaMesa(int cantSillas) {
		Mesa mesa = new Mesa(cantSillas);
		Sistema.getInstance().getMesas().put(mesa.getNroMesa(), mesa);
	}
	
	public void eliminaMesa(int nroMesa) throws NoExisteMesa_Exception, MesaOcupada_Exception {
		if (Sistema.getInstance().getMesas().get(nroMesa)==null) //fijarse de ponerlo en gestion mesa
			throw new NoExisteMesa_Exception("No existe el producto que desea eliminar");
		if (Sistema.getInstance().getMesas().get(nroMesa).getEstado() == Enumerados.estadoMesa.OCUPADA)
			throw new MesaOcupada_Exception("Espere a que se libere la mesa para elimianrla.");
		Sistema.getInstance().getMesas().remove(nroMesa);
	}

	public void modificaPassword(String password) {
		this.getOperario().setPassword(password);
	}
}
