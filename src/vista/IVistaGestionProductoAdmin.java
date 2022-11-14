package vista;

import java.awt.event.ActionListener;

public interface IVistaGestionProductoAdmin {

	void addActionListener(ActionListener actionListener);
	void limpiarVista();
	void ventanaEmergente(String mensaje);
	int getIdProd();
}
