/*
 * Los estados de mozo y operario los maneja cada uno al final del dia o el sistema / admin??
 * Si esta en el contrato lo consideramos como una precondicion? Por lo tanto no lanzamos excepcion (producto)
 * 
 */

package negocio;

import java.util.ArrayList;

import java.util.GregorianCalendar;
import java.util.HashMap;

import excepciones.ContrasenaIncorrecta_Exception;
import excepciones.NoExisteID_Exception;
import excepciones.NoExisteMesa_Exception;
import excepciones.NoExisteMozo_Exception;
import excepciones.NoExisteOperario_Exception;
import excepciones.PromoIdRepetido_Exception;
import excepciones.UserNameIncorrecto_Exception;
import excepciones.UserNameRepetido_Exception;
import modelo.Cerveceria;
import modelo.Comanda;
import modelo.Enumerados;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Producto;
import modelo.PromocionProd;
import modelo.PromocionTemporal;
import modelo.Sueldo;

/**
 * Clase Singleton que representa a la empresa gastronomica. mozos: Key -> Nya
 * Value -> Mozo productos: Key -> id del producto Value -> Producto operarios:
 * Key -> userNamer Value -> Operario mesas: Key -> numero de mesa Value -> Mesa
 * promocionProds: Key -> idProm Value -> PromocionProd
 */

public class Sistema {

	private HashMap<String, Mozo> mozos = Cerveceria.getInstance().getMozos();
	private HashMap<Integer, Producto> productos = Cerveceria.getInstance().getProductos();
	private HashMap<String, Operario> operariosRegistrados = Cerveceria.getInstance().getOperarios();	// operariosRegistrados
	private HashMap<Integer, Mesa> mesas = Cerveceria.getInstance().getMesas();
	private HashMap<Integer, PromocionProd> promocionProds = Cerveceria.getInstance().getPromocionProds();
	private ArrayList<Comanda> comandas = Cerveceria.getInstance().getComandas();
	private HashMap<String, PromocionTemporal> promocionTemp = Cerveceria.getInstance().getPromocionTemp();
	private HashMap<String, String> contrasena = Cerveceria.getInstance().getContrasena();
	//private Operario operarioActual;
	private FuncionalidadOperario funcionalidadOperario;
	//private boolean esAdmin;
	private static Sistema instance = null;
	
	// private Sueldo sueldo; //ESTO ACA ESTA
	// RAROOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO, hay que volarlo y explicar que
	// usamos el metodo y atributo de la CLASE

	public static Sistema getInstance() {
		if (instance == null)
			instance = new Sistema();
		return instance;
	}
	
	
//	public Operario getOperarioActual() {
//		return operarioActual;
//	}
//
//	public void setOperarioActual(Operario operarioActual) {
//		this.operarioActual = operarioActual;
//	}

	public HashMap<String, Mozo> getMozos() {
		return mozos;
	}


	public HashMap<Integer, Producto> getProductos() {
		return productos;
	}


	public HashMap<String, Operario> getOperariosRegistrados() {
		return operariosRegistrados;
	}


	public HashMap<Integer, Mesa> getMesas() {
		return mesas;
	}


	public HashMap<Integer, PromocionProd> getPromocionProds() {
		return promocionProds;
	}


	public ArrayList<Comanda> getComandas() {
		return comandas;
	}


	public HashMap<String, PromocionTemporal> getPromocionTemp() {
		return promocionTemp;
	}


	public HashMap<String, String> getContrasena() {
		return contrasena;
	}


	public FuncionalidadOperario getFuncionalidadOperario() {
		return funcionalidadOperario;
	}

	public void setFuncionalidadOperario(FuncionalidadOperario funcionalidadOperario) {
		this.funcionalidadOperario = funcionalidadOperario;
	}
	
	/**
	 * metodo para logear un operario. <br>
	 * Pre: El operario debe estar activo <br>
	 * Pre: El campo password debe contener entre 6 y 12 caracteres. Con al menos un
	 * digito y una mayuscula <br>
	 * Post: El operario queda logeado. <br>
	 * 
	 * @param userName utilizado para logear al usuario. <br>
	 * @param password correspondiente al userName. <br>
	 * @return Retorna un objeto de la clase Operario. <br>
	 * @throws UserNameIncorrecto_Exception
	 * @throws ContrasenaIncorrecta_Exception
	 */

//	public FuncionalidadOperario login(String userName, String password)
//			throws UserNameIncorrecto_Exception, ContrasenaIncorrecta_Exception {
	
	public void login(String userName, String password)
			throws UserNameIncorrecto_Exception, ContrasenaIncorrecta_Exception {
		
		if(this.operariosRegistrados.containsKey(userName)) {
			Operario operario = this.operariosRegistrados.get(userName);
			if(operario.verificaPassword(password) == true) {
				//this.operarioActual = operario;										// podriamos tener solo funcionalidad, porque tiene el operario
				this.funcionalidadOperario = new FuncionalidadOperario(operario);
			}
			else {	
				throw new ContrasenaIncorrecta_Exception("Contrasena incorrecta.");
			}
		}
		else {
			throw new UserNameIncorrecto_Exception("El usuario '"+userName+"' no se encuentra registrado en el sistema.");
		}
	}
	


}
