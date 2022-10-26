package modelo;

import excepciones.NoExisteMozo_Exception;

import excepciones.NoExisteOperario_Exception;

import java.util.GregorianCalendar;

public class Administrador extends Operario
{
	private static Administrador instance= null;
	
	public Administrador() {}
	
	public static Administrador getInstance() {
		
		if(instance == null)
			instance = new Administrador();
		return instance;
	}
}
