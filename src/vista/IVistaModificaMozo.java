package vista;

import java.awt.event.ActionListener;

public interface IVistaModificaMozo {
	
	void addAcionListener (ActionListener actionListener);
	void limpiarVista();
	void ventanaEmergente(String mensaje);
	String getNyA();
	int getCantHijos();
	float getSueldo();
	
}
