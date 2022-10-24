package negocio;

import java.util.GregorianCalendar;

import excepciones.NoExisteMozo_Exception;
import excepciones.NoExisteOperario_Exception;
import excepciones.NyAExistente_Exception;
import modelo.Enumerados;
import modelo.Operario;

public class GestionAdmin extends GestionOperarios {

	public GestionAdmin(Operario operario) {
		super(operario);
	}

	public void agregaMozo(String NyA, GregorianCalendar fecha, int cantHijos, Enumerados.estadoMozo estado)
			throws NyAExistente_Exception {
	}

	public void eliminaMozo(String NyA) throws NoExisteMozo_Exception {
	}

	public void agregaOperario (String NyA, String userName, String password) {
		
	}
	public void eliminaOperario(String userName) throws NoExisteOperario_Exception {
	}

	public void agregaProducto(String nombre, double precioCosto, double precioVenta, int stockInicial) {
	}

	public void eliminaProducto(int idProd) {
		
	}
	
	public void agregaMesa(int cantSillas, boolean libre) {
	}
	
	public void eliminaMesa(int numeroMesa) {
		
	}

}
