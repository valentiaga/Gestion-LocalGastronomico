package vista;

import java.awt.event.ActionListener;

public interface IVistaModificaMozo {
	void addAcionListener (ActionListener actionListener);
	String getNyA();
	int getCantHijos();
	float getSueldo();
	void limpiarVista();
	void ventanaEmergente(String mensaje);
}
