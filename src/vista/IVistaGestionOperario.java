package vista;

import java.awt.event.ActionListener;

public interface IVistaGestionOperario {
	
	void addActionListener(ActionListener actionListener);
	void limpiarVista();
	void ventanaEmergente(String mensaje);
}
