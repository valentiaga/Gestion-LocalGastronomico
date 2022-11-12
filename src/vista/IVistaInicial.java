package vista;

import java.awt.event.ActionListener;

public interface IVistaInicial {
	
	void limpiarVista();
	void ventanaEmergente(String mensaje);
	String getUsuario();
	String getContrasena();
	void addActionListener(ActionListener actionListener);
}
