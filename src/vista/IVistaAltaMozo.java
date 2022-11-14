package vista;

import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import modelo.Enumerados;

public interface IVistaAltaMozo {
	
	void addAcionListener (ActionListener actionListener);
	String getNyA();
	int getCantHijos();
	int getDiaNacimiento();
	int getMesNacimiento();
	int getAnioNacimiento();
	Enumerados.estadoMozo getEstado();
	GregorianCalendar fechaNacimiento();
	void limpiarVista();
	void ventanaEmergente(String mensaje);
}
