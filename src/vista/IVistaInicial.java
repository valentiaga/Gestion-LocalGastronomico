package vista;

import java.awt.event.ActionListener;

public interface IVistaInicial {
	
	void limpiarVista();
	String getUsuario();
	String getContrasena();
	void ventanaEmergente(String mensaje);
	void addActionListener(ActionListener actionListener);
}
