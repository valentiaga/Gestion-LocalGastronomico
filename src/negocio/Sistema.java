/*
 * Los estados de mozo y operario los maneja cada uno al final del dia o el sistema / admin??
 * Si esta en el contrato lo consideramos como una precondicion? Por lo tanto no lanzamos excepcion (producto)
 * 
 */

package negocio;

import java.util.ArrayList;
import java.util.HashMap;

import excepciones.ContrasenaIncorrecta_Exception;
import excepciones.OperarioInactivo_Exception;
import excepciones.UserNameIncorrecto_Exception;
import modelo.Administrador;
import modelo.Cerveceria;
import modelo.Comanda;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Producto;
import modelo.PromocionProd;
import modelo.PromocionTemporal;

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
	//private HashMap<Integer, Comanda> comandas
	//private HashMap<String, PromocionTemporal> promocionTemp = Cerveceria.getInstance().getPromocionTemp();
	private ArrayList<PromocionTemporal> promocionesTemp = Cerveceria.getInstance().getPromocionesTemp();
	private HashMap<String, String> contrasena = Cerveceria.getInstance().getContrasena();
	//private Operario operarioActual;
	private FuncionalidadOperario funcionalidadOperario;
	private FuncionalidadAdmin funcionalidadAdmin;
	//private boolean esAdmin;
	private static Sistema instance = null;
	private String usuarioAdministrador = "ADMIN";
	private String codigoAdministrador = "ADMIN1234";
	private Operario operarioActual;
	
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


	/*public HashMap<String, PromocionTemporal> getPromocionTemp() {
		return promocionTemp;
	}*/


	public HashMap<String, String> getContrasena() {
		return contrasena;
	}


	public ArrayList<PromocionTemporal> getPromocionesTemp() {
		return promocionesTemp;
	}


	public FuncionalidadOperario getFuncionalidadOperario() {
		return funcionalidadOperario;
	}

	public void setFuncionalidadOperario(FuncionalidadOperario funcionalidadOperario) {
		this.funcionalidadOperario = funcionalidadOperario;
	}
	
	
	public FuncionalidadAdmin getFuncionalidadAdmin() {
		return funcionalidadAdmin;
	}


	public void setFuncionalidadAdmin(FuncionalidadAdmin funcionalidadAdmin) {
		this.funcionalidadAdmin = funcionalidadAdmin;
	}


	public void seteaAdmin() {
		Administrador admin = Administrador.getInstance();
		if(this.operariosRegistrados.isEmpty() == true) {
			admin.setActivo(true);
			admin.setUserName(this.usuarioAdministrador);
			admin.setPassword(codigoAdministrador);
			admin.setNyA("Administrador");
			this.operariosRegistrados.put(admin.getUserName(), admin);
		}
	}
	
	public void setMozos(HashMap<String, Mozo> mozos) {
		this.mozos = mozos;
	}


	public void setProductos(HashMap<Integer, Producto> productos) {
		this.productos = productos;
	}


	public void setOperariosRegistrados(HashMap<String, Operario> operariosRegistrados) {
		this.operariosRegistrados = operariosRegistrados;
	}


	public void setMesas(HashMap<Integer, Mesa> mesas) {
		this.mesas = mesas;
	}


	public void setPromocionProds(HashMap<Integer, PromocionProd> promocionProds) {
		this.promocionProds = promocionProds;
	}


	public void setComandas(ArrayList<Comanda> comandas) {
		this.comandas = comandas;
	}


	public void setPromocionesTemp(ArrayList<PromocionTemporal> promocionesTemp) {
		this.promocionesTemp = promocionesTemp;
	}


	public void setContrasena(HashMap<String, String> contrasena) {
		this.contrasena = contrasena;
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
	
/*	public FuncionalidadOperario login(String userName, String password)
			throws UserNameIncorrecto_Exception, ContrasenaIncorrecta_Exception, OperarioInactivo_Exception {
		FuncionalidadOperario funcionalidad = null;
		if(this.operariosRegistrados.containsKey(userName)) {
			Operario operario = this.operariosRegistrados.get(userName);
			if(operario.verificaPassword(password) == true) {
				//this.operarioActual = operario;										// podriamos tener solo funcionalidad, porque tiene el operario
				if(operario.isActivo() == false)
					throw new OperarioInactivo_Exception("El usuario '"+userName+"' se encuentra inactivo.");
				if(userName == this.usuarioAdministrador)								// si la contrasena sigue siendo Admin1234 hay que obligarlo a cambiarla
					funcionalidad = new FuncionalidadAdmin(operario);
				else
					funcionalidad = new FuncionalidadOperario(operario);
			}
			else {	
				throw new ContrasenaIncorrecta_Exception("Contrasena incorrecta.");
			}
		}
		else {
			throw new UserNameIncorrecto_Exception("El usuario '"+userName+"' no se encuentra registrado en el sistema.");
		}
		return funcionalidad;
	}*/
	public void login(String userName, String password)
			throws UserNameIncorrecto_Exception, ContrasenaIncorrecta_Exception, OperarioInactivo_Exception {
		//FuncionalidadOperario funcionalidad = null;
		if(this.operariosRegistrados.containsKey(userName)) {
			Operario operario = this.operariosRegistrados.get(userName);
			if(operario.verificaPassword(password) == true) {
				this.operarioActual = operario;										// podriamos tener solo funcionalidad, porque tiene el operario
				if(operario.isActivo() == false)
					throw new OperarioInactivo_Exception("El usuario '"+userName+"' se encuentra inactivo.");
				if(userName.equals(this.usuarioAdministrador))								// si la contrasena sigue siendo Admin1234 hay que obligarlo a cambiarla
					this.funcionalidadAdmin = new FuncionalidadAdmin(operario);
				else
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
