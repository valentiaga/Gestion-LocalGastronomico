package vista;

import java.awt.event.ActionListener;

public interface IVistaGestionMesaAdmin {
	void addActionListener(ActionListener actionListener);
	int getNroMesa ();
	int getCantPax();
	void limpiarVista();
	void ventanaEmergente(String mensaje);
	int getCant();
	int getIdProd();
}
