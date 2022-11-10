package vista;

import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import controlador.ControladorVistaGestionMozoAdmin;

public interface IVistaGestionMozoAdmin {

	public JComboBox getComboBox();
	void addActionListener(ActionListener actionListener);
	
}
