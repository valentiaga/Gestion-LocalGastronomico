package vista;

import java.awt.event.ActionListener;

import modelo.Enumerados;
import modelo.Mozo;

public interface IVistaModificaMozoAdmin {
	
	void addAcionListener (ActionListener actionListener);
	void limpiarVista();
	void ventanaEmergente(String mensaje);
	String getNyA();
	int getCantHijos();
	float getSueldo();
	Enumerados.estadoMozo getEstadoMozo();
	Mozo getMozo();
	void actualizaComboBox();
	
}
