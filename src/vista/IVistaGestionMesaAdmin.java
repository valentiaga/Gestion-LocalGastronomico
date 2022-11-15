package vista;

import java.awt.event.ActionListener;

import modelo.Mozo;

public interface IVistaGestionMesaAdmin {
	void addActionListener(ActionListener actionListener);
	int getNroMesa ();
	int getCantPax();
	void limpiarVista();
	void ventanaEmergente(String mensaje);
	int getCant();
	int getIdProd();
	void actualizaComboBox();
	Mozo getMozo();
}
