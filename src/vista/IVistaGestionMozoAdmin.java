package vista;

import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import controlador.ControladorVistaGestionMozoAdmin;

public interface IVistaGestionMozoAdmin {

	String getNyA();
	int getCantHijos();
	JComboBox getComboBox();
	void addActionListener(ActionListener actionListener);
	void limpiarVista();
	void ventanaEmergente(String mensaje);
}
