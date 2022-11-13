package vista;

import java.awt.event.ActionListener;

public interface IVistaAltaMozo {
	
	void addAcionListener (ActionListener actionListener);
	String getNyA();
	int getCantHijos();
	String fechaNacimiento();
	//GregorianCalendar fechaNacimiento();
	void limpiarVista();
	void ventanaEmergente(String mensaje);
}
